package web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;


@Controller
public class UsersController {
    @Autowired
    UserService userService;


    @GetMapping("/")
    public String users(ModelMap modelMap){
        modelMap.addAttribute("users", userService.getAllUsers());
        return "users";
    }

    @GetMapping("/{id}")
    public String userByID(@PathVariable("id") int id, ModelMap modelMap){
        modelMap.addAttribute("user", userService.userByID(id));
        return "user_by_id";
    }

    @GetMapping("/{id}/edit")
    public String editUser(@PathVariable("id") int id, ModelMap modelMap){
        modelMap.addAttribute("user", userService.userByID(id));
        return "edit_user";
    }


    @GetMapping("/add_user")
    public String addUser(ModelMap modelMap){
        modelMap.addAttribute("user", new User());
        return "add_user";
    }

    @PostMapping("/")
    public String create(@ModelAttribute("user") User user){
        userService.addUser(user);
        return "redirect:/";
    }

    @PatchMapping("/{id}")
    public String edit(@PathVariable("id") int id, @ModelAttribute("user") User updatedUser){
        userService.updateUser(id, updatedUser);
        return "redirect:/";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id){
        userService.deleteUser(id);
        return "redirect:/";
    }


}
