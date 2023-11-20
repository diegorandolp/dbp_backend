package com.example.demo.user;

import io.jsonwebtoken.Jwt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    /*
    @PostMapping
    public ResponseEntity<String> addUser(@RequestBody UserRequestDto userRequestDto) {
        userService.addUser(userRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Created.");
    }*/
    @Secured({"ADMIN", "USER"})
    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> getUser(@PathVariable Long id) {
        UserResponseDto userResponseDto = userService.getUserById(id);
        return new ResponseEntity<>(userResponseDto, HttpStatus.OK);
    }
    @Secured({"ADMIN", "USER"})
    @GetMapping
    public ResponseEntity<List<UserResponseDto>> getUsers() {
        List<UserResponseDto> userResponseDtos = userService.getUsers();
        return new ResponseEntity<>(userResponseDtos, HttpStatus.OK);
    }
    @Secured({"ADMIN", "USER"})
    @GetMapping("/profile")
    public ResponseEntity<UserResponseDto> getCurrentUser(Authentication authentication) {
        UserResponseDto currentUser = userService.getCurrentUser(authentication);

        return ResponseEntity.ok(currentUser);
    }

}

