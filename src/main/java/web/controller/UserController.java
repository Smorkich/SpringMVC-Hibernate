package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.User;
import web.service.UserService;
import javax.validation.Valid;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String show(Model model) {
        model.addAttribute("users", userService.getUsers());
        return "users";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("user", new User());
        return "addUserPage";
    }
    @PostMapping("/add")
    public String addUser(@ModelAttribute("user") @Valid User user) {
        userService.addUser(user);
        return "redirect:/";
    }
    @GetMapping("/edit")
    public String edit(Model model, @RequestParam(value = "id") Long id) {
        model.addAttribute("user",userService.getUserById(id));
        return "/editPage";
    }
    @PatchMapping("/edit")
    public String update (@ModelAttribute("user") User user) {
        userService.updateUser(user);
        return "redirect:/";
    }
    @DeleteMapping("/delete")
    public String delete(@RequestParam("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/";
    }
}
