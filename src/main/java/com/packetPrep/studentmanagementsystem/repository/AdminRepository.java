package com.packetPrep.studentmanagementsystem.repository;

import com.packetPrep.studentmanagementsystem.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
}
