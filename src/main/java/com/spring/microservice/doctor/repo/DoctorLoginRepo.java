package com.spring.microservice.doctor.repo;


import com.spring.microservice.doctor.model.DoctorLogin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorLoginRepo extends JpaRepository<DoctorLogin, String> {
}
