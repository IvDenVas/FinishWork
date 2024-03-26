package ru.gb.FinishWork.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.gb.FinishWork.model.Note;
import ru.gb.FinishWork.model.User;
import ru.gb.FinishWork.service.impl.NoteServiceImplements;
import ru.gb.FinishWork.service.impl.UsersServiceImplements;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/admin")
public class AdminController {
    private UsersServiceImplements usersServiceImplements;
    private NoteServiceImplements noteServiceImplements;

    @GetMapping()
    public String adminForm(Model model) {
        List<Note> noteList = noteServiceImplements.getAllNotes();
        List<User> userList = usersServiceImplements.getAllUsers();
        model.addAttribute("users", userList)
                .addAttribute("notes", noteList);
        return "adminPage";
    }

    @PostMapping()
    public String addUser(User user) {
        usersServiceImplements.newUser(user);
        return "redirect:/admin";
    }

    @GetMapping("/delete/{id}")
    @Transactional
    public String deleteUser(@PathVariable("id") Long id) {
        noteServiceImplements.deleteAllNoteByIdUser(id);
        usersServiceImplements.deleteUserById(id);
        return "redirect:/admin";
    }
    @GetMapping("/updateUser/{id}")
    public String updateUserForm(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", usersServiceImplements
                .getUserById(id));
        return "updateUser";
    }

    @PutMapping("/updateUser")
    public String updateUser(@PathVariable("id") Long id,
                             @ModelAttribute("user") User user) {
        usersServiceImplements.updateUser(id, user);
        return "redirect:/admin";
    }

    @GetMapping("/deleteFromAdmin/{id}")
    public String deleteNote(@PathVariable("id") Long id) {
        noteServiceImplements.deleteNoteById(id);
        return "redirect:/admin";
    }
}
