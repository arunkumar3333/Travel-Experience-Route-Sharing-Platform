package com.example.Travel_Experience_Route_Sharing_Platform.Controller;

import com.example.Travel_Experience_Route_Sharing_Platform.Entity.Users;
import com.example.Travel_Experience_Route_Sharing_Platform.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/insert")
    public Users createUser(@RequestBody Users users){
        return userService.createUser(users);
    }
    @PostMapping("/insertmany")
    public List<Users> createUserMany(@RequestBody List<Users> users){
        return userService.createUserMany(users);
    }

    @GetMapping("fetch")
    public List<Users> fetch(){
        return userService.fetch();
    }

    @GetMapping("/fetch/{id}")
    public Users fetchId(@PathVariable Long id){
        return userService.fetchById(id);
    }
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        return userService.delete(id);
    }

    @PutMapping("/update/{id}")
    public Users update(@PathVariable Long id,@RequestBody Users users){
        return userService.update(id,users);
    }
}
