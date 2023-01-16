package com.spring.microservice.doctor.model;

import java.util.List;

public class Doctor {
    private DoctorLogin DL;
    private DoctorDetails DD;

    private List<AppointmentSchedule> AS;

    public Doctor() {
    }

    public Doctor(DoctorLogin DL, DoctorDetails DD, List<AppointmentSchedule> AS) {
        this.DL = DL;
        this.DD = DD;
        this.AS = AS;
    }

    public DoctorLogin getDL() {
        return DL;
    }

    public void setDL(DoctorLogin DL) {
        this.DL = DL;
    }

    public DoctorDetails getDD() {
        return DD;
    }

    public void setDD(DoctorDetails DD) {
        this.DD = DD;
    }

    public List<AppointmentSchedule> getAS() {
        return AS;
    }

    public void setAS(List<AppointmentSchedule> AS) {
        this.AS = AS;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "DL=" + DL +
                ", DD=" + DD +
                ", AS=" + AS +
                '}';
    }
}
