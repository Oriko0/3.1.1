package ru.timkrug.crudspringboot311.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import ru.timkrug.crudspringboot311.model.User;
import ru.timkrug.crudspringboot311.service.UserService;


@Controller
public class UserController {
    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String showAllUsers(Model model) {
        model.addAttribute("allUsers", userService.getAllUsers());
        return "allusers";
    }
    @GetMapping("/addNewUser")
    public String addNewUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "user-info";
    }
    @GetMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/";

    }
    @GetMapping("/updateInfo")
    public String updateUser(@RequestParam("usrId") int id, Model model) {
        User user = userService.getUser(id);
        model.addAttribute("user", user);
        return "user-info";
    }
    @GetMapping("/deleteUser")
    public String deleteUser(@RequestParam("usrId") int id) {
        userService.deleteUser(id);
        return "redirect:/";
    }
}
