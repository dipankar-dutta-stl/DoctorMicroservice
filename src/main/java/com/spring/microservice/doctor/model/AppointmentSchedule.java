package com.spring.microservice.doctor.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AppointmentSchedule {
    @Id
    private String ID;
    private String DOCTOR_ID;
    private String SCHEDULE_DAY;
    private String SCHEDULE_TIME_START;
    private String SCHEDULE_TIME_END;

    public AppointmentSchedule() {
    }

    public AppointmentSchedule(String ID, String DOCTOR_ID, String SCHEDULE_DAY, String SCHEDULE_TIME_START, String SCHEDULE_TIME_END) {
        this.ID = ID;
        this.DOCTOR_ID = DOCTOR_ID;
        this.SCHEDULE_DAY = SCHEDULE_DAY;
        this.SCHEDULE_TIME_START = SCHEDULE_TIME_START;
        this.SCHEDULE_TIME_END = SCHEDULE_TIME_END;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getDOCTOR_ID() {
        return DOCTOR_ID;
    }

    public void setDOCTOR_ID(String DOCTOR_ID) {
        this.DOCTOR_ID = DOCTOR_ID;
    }

    public String getSCHEDULE_DAY() {
        return SCHEDULE_DAY;
    }

    public void setSCHEDULE_DAY(String SCHEDULE_DAY) {
        this.SCHEDULE_DAY = SCHEDULE_DAY;
    }


    public String getSCHEDULE_TIME_START() {
        return SCHEDULE_TIME_START;
    }

    public void setSCHEDULE_TIME_START(String sCHEDULE_TIME_START) {
        SCHEDULE_TIME_START = sCHEDULE_TIME_START;
    }

    public String getSCHEDULE_TIME_END() {
        return SCHEDULE_TIME_END;
    }

    public void setSCHEDULE_TIME_END(String sCHEDULE_TIME_END) {
        SCHEDULE_TIME_END = sCHEDULE_TIME_END;
    }

    @Override
    public String toString() {
        return "AppointmentSchedule [ID=" + ID + ", DOCTOR_ID=" + DOCTOR_ID + ", SCHEDULE_DAY=" + SCHEDULE_DAY
                + ", SCHEDULE_TIME_START=" + SCHEDULE_TIME_START + ", SCHEDULE_TIME_END=" + SCHEDULE_TIME_END + "]";
    }


}
