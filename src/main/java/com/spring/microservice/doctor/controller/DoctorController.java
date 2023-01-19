package com.spring.microservice.doctor.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.microservice.doctor.jwt.JwtUtills;
import com.spring.microservice.doctor.model.AppointmentSchedule;
import com.spring.microservice.doctor.model.Doctor;
import com.spring.microservice.doctor.model.DoctorDetails;
import com.spring.microservice.doctor.model.DoctorLogin;
import com.spring.microservice.doctor.repo.AppointmetScheduleRepo;
import com.spring.microservice.doctor.repo.DoctorDetailsRepo;
import com.spring.microservice.doctor.repo.DoctorLoginRepo;
import com.spring.microservice.doctor.security.DoctorLoginDetails;
import com.spring.microservice.doctor.security.DoctorLoginDetailsService;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/v1/doctor")
public class DoctorController {

	@Autowired
	DoctorLoginRepo doctorLoginRepo;
	@Autowired
	DoctorDetailsRepo doctorDetailsRepo;
	@Autowired
	AppointmetScheduleRepo appointmetScheduleRepo;
	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	DoctorLoginDetailsService doctorLoginDetailsService;
	@Autowired
	JwtUtills jwtUtills;

	@PostMapping("/add")
	public String addDoctor(@RequestBody Doctor D) {

		DoctorLogin doctorLogin = D.getDL();
		DoctorDetails doctorDetails = D.getDD();
		List<AppointmentSchedule> appointmentScheduleList = D.getAS();
		try {
			DoctorLogin isDoctorAvailabel = doctorLoginRepo.findById(doctorLogin.getEMAIL_ID()).get();
		} catch (java.util.NoSuchElementException x) {
			BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
			UUID id = UUID.randomUUID();
			String encryptPass = bCryptPasswordEncoder.encode(doctorLogin.getPASSWORD());
			doctorLogin.setPASSWORD(encryptPass);
			doctorDetails.setID(id.toString());
			doctorDetails.setEMAIL_ID(doctorLogin.getEMAIL_ID());
			doctorDetails.setTAGS(doctorDetails.getFIRST_NAME() + "," + doctorDetails.getLAST_NAME() + ","
					+ doctorDetails.getSPECIALIZATION());
			doctorLoginRepo.save(doctorLogin);
			doctorDetailsRepo.save(doctorDetails);
			for (AppointmentSchedule as : appointmentScheduleList) {
				as.setID(UUID.randomUUID().toString());
				as.setDOCTOR_ID(doctorDetails.getID());
				appointmetScheduleRepo.save(as);
			}
			return "REGISTRATION SUCCESSFULL";
		}
		return "YOU ARE ALREADY REGISTERED";

	}

	@PostMapping("/authenticate")
	public String authenticateDoctor(@RequestBody DoctorLogin doctorLogin) {
		try {
			Authentication authentication = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(doctorLogin.getEMAIL_ID(), doctorLogin.getPASSWORD()));
			if (authentication.isAuthenticated()) {
				SecurityContextHolder.getContext().setAuthentication(authentication);
				DoctorLoginDetails doctorLoginDetails = (DoctorLoginDetails) doctorLoginDetailsService
						.loadUserByUsername(doctorLogin.getEMAIL_ID());
				String TOKEN = jwtUtills.generateJwtToken(doctorLoginDetails);
				return TOKEN;
			} else {
				return "LOGIN FAILED";
			}
		} catch (Exception ex) {
			return "LOGIN FAILED";
		}

	}

	@GetMapping("/alldoctors")
	public List<Doctor> getAllDoctors() {
		List<Doctor> doctorList = new ArrayList<Doctor>();
		List<DoctorDetails> doctorDetailsList = doctorDetailsRepo.findAll();
		for (DoctorDetails d : doctorDetailsList) {
			List<AppointmentSchedule> appointmentScheduleList = appointmetScheduleRepo
					.findAppointmentScheduleByDOCTOR_ID(d.getID());
			doctorList.add(new Doctor(null, d, appointmentScheduleList));
		}
		return doctorList;
	}

	@GetMapping("/get/{email}")
	public Doctor getDoctor(@PathVariable("email") String email) {
		DoctorLogin doctorLogin = doctorLoginRepo.findById(email).get();
		DoctorDetails doctorDetails = doctorDetailsRepo.findByEMAIL_ID(email);
		List<AppointmentSchedule> appointmentScheduleList = appointmetScheduleRepo
				.findAppointmentScheduleByDOCTOR_ID(doctorDetails.getID());
		return new Doctor(doctorLogin, doctorDetails, appointmentScheduleList);
	}
	
	@GetMapping("/get/id/{id}")
	public Doctor getDoctorById(@PathVariable("id") String id) {
		try {
			Doctor doctor=new Doctor();
			doctor.setDD(doctorDetailsRepo.findById(id).get());
			doctor.setAS(appointmetScheduleRepo.findAppointmentScheduleByDOCTOR_ID(id));
			return doctor;
		}catch(Exception x) {
			return null;
		}
	}

	@GetMapping("/validate/{token}")
	public Boolean checkTokenValidity(@PathVariable("token") String token) {
		try {
			String username = jwtUtills.getUsernameFromToken(token);
			DoctorLoginDetails doctorLoginDetails = (DoctorLoginDetails) doctorLoginDetailsService
					.loadUserByUsername(username);
			Boolean isValid = jwtUtills.validateJwtToken(token, doctorLoginDetails);
			return isValid;
		} catch (Exception x) {
			return false;
		}
	}

	@PostMapping("/addschedule")
	public String addAppointmetSchedule(@RequestBody AppointmentSchedule as) {
		UUID appointment_ID = UUID.randomUUID();
		as.setID(appointment_ID.toString());
		appointmetScheduleRepo.save(as);
		return "SUCCESSFULLY ADDED";

	}

	@PutMapping("/updateschedule")
	public String updateAppointmetSchedule(@RequestBody AppointmentSchedule as) {
		try {
			appointmetScheduleRepo.save(as);
			return "UPDATE SUCCESSFULL";
		} catch (Exception x) {
			return "UPDATE SCHEDULE FAILED";
		}

	}

	@PutMapping("/update")
	public String updateDoctor(@RequestBody DoctorDetails dd) {
		try {
			doctorDetailsRepo.save(dd);
			return "UPDATE SUCCESSFUL";
		} catch (Exception Ex) {
			return "UPDATE FAILED";
		}

	}

	@DeleteMapping("/deleteschedule/{id}")
	public String deleteSchedule(@PathVariable("id") String id) {
		try {
			appointmetScheduleRepo.deleteById(id);
			return "SCHEDULE DELETED";
		} catch (Exception x) {
			return "DELETE FAILED";
		}

	}

}
