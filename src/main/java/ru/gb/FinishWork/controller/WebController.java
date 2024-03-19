package ru.gb.FinishWork.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.gb.FinishWork.model.Note;
import ru.gb.FinishWork.model.User;
import ru.gb.FinishWork.service.FileGateway;
import ru.gb.FinishWork.service.impl.NoteServiceImplements;
import ru.gb.FinishWork.service.impl.UsersServiceImplements;
import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/main")
public class WebController {
    private final NoteServiceImplements noteService;
    private final UsersServiceImplements usersServiceImplements;//?
    private final FileGateway fileGateway;

    @GetMapping()
    public String getAllNotes(Model model, Principal principal) {
        List<Note> noteList = noteService.getAllNotesByIdUser(usersServiceImplements
                .getUserByName(principal.getName()).get().getId());
        model.addAttribute("notes", noteList);
        return "show";
    }

    @GetMapping("/register")
    public String registerForm(){
        return "register";
    }
    @PostMapping("/register")
    public String addUser(User user, Model model){
        usersServiceImplements.newUser(user);
        return "redirect:/main";
    }

    @PostMapping()
    public String addNote(Note note, Model model, Principal principal) {
        note.setIdUser(usersServiceImplements.getUserByName(principal.getName()).get().getId());
        noteService.newNote(note);
        fileGateway.writeToFile("NewNotes.txt", "Заголовок: " + note.getTitle() + ", тело заметки:  "
                + note.getDescription() + " ,дата создания: " + note.getDateTime());
        return "redirect:/main";
    }

    @GetMapping("/update/{id}")
    public String updateNoteForm(@PathVariable("id") long id, Model model) {
        model.addAttribute("note", noteService.getNoteById(id));
        return "update";
    }

    @PutMapping("/update")
    public String updateNote(@PathVariable("id") Long id, @ModelAttribute("note") Note note) {
        noteService.updateNote(id, note);
        return "redirect:/main";
    }
    @GetMapping("/delete/{id}")
    public String deleteNote(@PathVariable("id") Long id) {
        fileGateway.writeToFile("DeletedNotes.txt", "Удалена заметка с Id = " + id + " ,дата удаления: "
                + LocalDateTime.now() + " ,заголовок: " + noteService.getNoteById(id).getTitle() + " ,тело заметки: "
                + noteService.getNoteById(id).getDescription() + " ,дата создания: "
                + noteService.getNoteById(id).getDateTime());
        noteService.deleteNoteById(id);
        return "redirect:/main";
    }
}