package com.packetPrep.studentmanagementsystem.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminRegisterRequest {
    private String adminName;
    private String email;
    private String password;
}
