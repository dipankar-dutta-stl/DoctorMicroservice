package com.spring.microservice.doctor.security;

import com.spring.microservice.doctor.model.DoctorLogin;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class DoctorLoginDetails implements UserDetails {

    private DoctorLogin DL;

    public DoctorLoginDetails(DoctorLogin DL) {
        this.DL = DL;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority("DOCTOR"));
    }

    @Override
    public String getPassword() {
        return DL.getPASSWORD();
    }

    @Override
    public String getUsername() {
        return DL.getEMAIL_ID();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
