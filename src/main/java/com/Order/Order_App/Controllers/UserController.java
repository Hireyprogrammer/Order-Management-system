package com.Order.Order_App.Controllers;

import com.Order.Order_App.Models.User;
import com.Order.Order_App.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/newuser")
    public String showAddUserForm(Model model) {
        model.addAttribute("user", new User());
        return "newuser";
    }

    @PostMapping("/adduser")
    public String addUser(@Validated @ModelAttribute("user") User user,
                          BindingResult result,
                          @RequestParam("userImage") MultipartFile file,
                          Model model,
                          RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return "newuser";
        }
        if (file == null || file.isEmpty()) {
            model.addAttribute("fileError", "Profile image is required");
            return "newuser";
        }
        try {
            userService.saveUser(user, file);
            redirectAttributes.addFlashAttribute("successMessage", "User successfully added!");
        } catch (IOException e) {
            model.addAttribute("message", "File upload failed");
            return "newuser";
        }
        return "redirect:/newuser";
    }
}
