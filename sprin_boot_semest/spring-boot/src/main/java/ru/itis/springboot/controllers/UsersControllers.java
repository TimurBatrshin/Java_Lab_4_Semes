package ru.itis.springboot.controllers;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.springboot.models.User;
import ru.itis.springboot.services.UsersService;

import java.util.List;
import java.util.Optional;

@RestController
@Controller
public class UsersControllers {

    @Autowired
    private UsersService usersService;

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/users")
    @ResponseBody
    public String getUsersPage(Model model) {
        List<User> users = usersService.getAllUsers();
        model.addAttribute("users", users);
        return "users_page";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/banAll")
    @ResponseBody
    public String banUsers() {
        usersService.banAll();
        return "redirect:/users";
    }

    @ApiOperation(value = "Находим пользователя по id")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Успешно", response = User.class)})
    @GetMapping("/user")
    @ResponseBody
    public ResponseEntity<List<User>> getUser(){
        return ResponseEntity.ok(usersService.getAllUsers());
    }


}
