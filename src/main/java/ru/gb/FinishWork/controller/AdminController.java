package ru.gb.FinishWork.controller;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.gb.FinishWork.model.Note;
import ru.gb.FinishWork.model.User;
import ru.gb.FinishWork.service.impl.NoteServiceImplements;
import ru.gb.FinishWork.service.impl.UsersServiceImplements;
import java.util.List;

@Controller
@AllArgsConstructor
//@NoArgsConstructor
@RequestMapping("/admin")
public class AdminController {
    private UsersServiceImplements usersServiceImplements;
    private NoteServiceImplements noteServiceImplements;

    @GetMapping()
    @PreAuthorize("hasAuthority('admin')")
    public String adminForm(Model model) {
        List<Note> noteList = noteServiceImplements.getAllNotes();
        List<User> userList = usersServiceImplements.getAllUsers();
        model.addAttribute("users", userList).addAttribute("notes", noteList);
        return "adminPage";
    }

    @PostMapping()
    @PreAuthorize("hasAuthority('admin')")
    public String addUser(User user, Model model) {
        usersServiceImplements.newUser(user);
//        fileGateway.writeToFile("NewNotes.txt", "Заголовок: " + note.getTitle() + ", тело заметки:  "
//                + note.getDescription() + " ,дата создания: " + note.getDateTime());
        return "redirect:/admin";
    }

    @GetMapping("/delete/{id}")
    @PreAuthorize("hasAuthority('admin')")
    public String deleteNote(@PathVariable("id") Long id) {
        usersServiceImplements.deleteUserById(id);
        return "redirect:/admin";
    }
    @GetMapping("/updateUser/{id}")
    @PreAuthorize("hasAuthority('admin')")
    public String updateNoteForm(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", usersServiceImplements.getUserById(id));
        return "updateUser";
    }

    @PutMapping("/updateUser")
    @PreAuthorize("hasAuthority('admin')")
    public String updateNote(@PathVariable("id") Long id, @ModelAttribute("note") User user) {
        usersServiceImplements.updateUser(id, user);
        return "redirect:/admin";
    }
}
