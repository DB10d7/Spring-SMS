package com.packetPrep.studentmanagementsystem.service;


import com.packetPrep.studentmanagementsystem.DTO.AdminRegisterRequest;
import com.packetPrep.studentmanagementsystem.model.Admin;
import com.packetPrep.studentmanagementsystem.repository.AdminRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class AuthService {

    private final AdminRepository adminRepository;

    @Transactional
    public void signup(AdminRegisterRequest adminRegisterRequest) {
        Admin admin = new Admin();
        admin.setAdminName(adminRegisterRequest.getAdminName());
        admin.setEmail(adminRegisterRequest.getEmail());
        admin.setPassword(passwordEncoder.encode(adminRegisterRequest.getPassword()));
        adminRepository.save(admin);
        String token = generateVerificationToken(admin);
        mailService.sendMail(new NotificationEmail("Please Activate your Account",
                user.getEmail(), "Thank you for signing up to Spring Reddit, " +
                "please click on the below url to activate your account : " +
                "http://localhost:8080/api/auth/accountVerification/" + token));
    }
}
