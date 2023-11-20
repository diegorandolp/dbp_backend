package com.example.demo.auth;

import com.example.demo.user.UserRequestDto;
import com.example.demo.auth.JwtAuthenticationResponse;
import com.example.demo.user.SigninRequest;
import com.example.demo.auth.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin
public class AuthController {
    private final AuthenticationService authenticationService;

    @Autowired
    public AuthController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }
    @CrossOrigin
    @PostMapping("/signup")
    public ResponseEntity<JwtAuthenticationResponse> signup(@RequestBody UserRequestDto request) {
        return ResponseEntity.ok(authenticationService.signup(request));
    }
    @CrossOrigin
    @PostMapping("/signin")
    public ResponseEntity<JwtAuthenticationResponse> signin(@RequestBody SigninRequest request) {
        return ResponseEntity.ok(authenticationService.signin(request));
    }


}
