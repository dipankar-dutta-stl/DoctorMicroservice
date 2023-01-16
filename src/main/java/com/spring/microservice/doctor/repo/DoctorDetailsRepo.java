package com.spring.microservice.doctor.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.microservice.doctor.model.DoctorDetails;
import org.springframework.data.jpa.repository.Query;

public interface DoctorDetailsRepo extends JpaRepository<DoctorDetails, String> {

    @Query(value = "select * from doctor_details where email_id=?",nativeQuery = true)
    public DoctorDetails findByEMAIL_ID(String email);
}
