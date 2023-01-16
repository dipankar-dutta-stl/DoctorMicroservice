package com.spring.microservice.doctor.repo;

import com.spring.microservice.doctor.model.AppointmentSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AppointmetScheduleRepo extends JpaRepository<AppointmentSchedule,String> {
    @Query(value="select * from appointment_schedule where doctor_id=?",nativeQuery = true)
    public List<AppointmentSchedule> findAppointmentScheduleByDOCTOR_ID(String id);
}
