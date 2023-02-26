package com.spring.microservice.doctor.security;

import com.spring.microservice.doctor.model.DoctorLogin;
import com.spring.microservice.doctor.repo.DoctorLoginRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class DoctorLoginDetailsService implements UserDetailsService {
    @Autowired
    DoctorLoginRepo doctorLoginRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        DoctorLogin doctorLogin = doctorLoginRepo.findById(username).get();
        if (doctorLogin != null) {
            return new DoctorLoginDetails(doctorLogin);
        }
        return null;
    }
}
