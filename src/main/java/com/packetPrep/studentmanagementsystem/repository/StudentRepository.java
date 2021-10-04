package com.packetPrep.studentmanagementsystem.repository;

import com.packetPrep.studentmanagementsystem.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long > {
}
