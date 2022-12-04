package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UserControllers {

    private final UserService userService;


    public UserControllers(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String getAllUsers(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "users/index";
    }

    @GetMapping("/{id}")
    public String getUser(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.getById(id));
        return "users/show";
    }

    @GetMapping("/new")
    public String getFormForCreate(@ModelAttribute("user") User user) {
        return "users/new";
    }

    @PostMapping()
    public String createUser(@ModelAttribute("user") @Valid User user) {
        userService.addUser(user);
        return "redirect:/users/";
    }

    @GetMapping("/{id}/edit")
    public String getFormForUpdate(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.getById(id));
        return "users/edit";
    }

    @PutMapping("/{id}")
    public String updateUser(@ModelAttribute("user") @Valid User user, @PathVariable int id) {
        userService.editUser(user, id);
        return "redirect:/users/";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userService.deleteUser(id);
        return "redirect:/users/";
    }
}
