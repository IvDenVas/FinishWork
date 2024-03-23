package ru.gb.FinishWork.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.gb.FinishWork.model.User;
import ru.gb.FinishWork.model.UserRole;
import ru.gb.FinishWork.service.impl.UsersServiceImplements;

@Controller
@AllArgsConstructor
public class RegistrationController {
    private UsersServiceImplements usersServiceImplements;

    @GetMapping("/register")
    public String registerForm(Model model){
        model.addAttribute("user", new User());
        return "register";
    }
    @PostMapping("/register")
    public String addUser(@ModelAttribute ("user") User user, Model model){
        user.setUserRole(UserRole.user);
        model.addAttribute("user", user);
        usersServiceImplements.registrationUser(user);
        return "redirect:/main";
    }
}