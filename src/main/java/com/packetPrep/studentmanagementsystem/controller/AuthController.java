package com.packetPrep.studentmanagementsystem.controller;


import com.packetPrep.studentmanagementsystem.DTO.AdminRegisterRequest;
import com.packetPrep.studentmanagementsystem.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/admin/signup")
    public ResponseEntity<String> signup(@RequestBody AdminRegisterRequest adminRegisterRequest) {
        authService.signup(adminRegisterRequest);
        return new ResponseEntity<>("Admin Registration Successful", HttpStatus.OK);
    }
}
