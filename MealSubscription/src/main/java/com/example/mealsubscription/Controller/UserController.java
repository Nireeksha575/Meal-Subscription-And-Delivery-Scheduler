package com.example.mealsubscription.Controller;

import com.example.mealsubscription.Entity.User;
import com.example.mealsubscription.Service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody User user){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.addUser(user));
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@RequestBody User user,@PathVariable long id){
        return ResponseEntity.ok(service.updateUser(user,id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable long id){
        service.deleteUser(id);
        return ResponseEntity.ok("user with id:"+id+" deleted");
    }
}
