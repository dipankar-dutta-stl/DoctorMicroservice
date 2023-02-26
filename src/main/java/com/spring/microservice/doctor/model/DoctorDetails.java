package com.spring.microservice.doctor.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DoctorDetails {
    @Id
    private String ID;
    private String EMAIL_ID;
    private String MOBILE_NO;
    private String FIRST_NAME;
    private String LAST_NAME;
    private String GENDER;
    private String CHEMBAR_ADDRESS;
    private String SPECIALIZATION;
    private Integer VISITING_PRICE;
    private String TAGS;

    private String CITY;
    private String STATE;
    private String PIN;

    public DoctorDetails() {

    }

    public DoctorDetails(String ID, String EMAIL_ID, String MOBILE_NO, String FIRST_NAME, String LAST_NAME, String GENDER, String CHEMBAR_ADDRESS, String SPECIALIZATION, Integer VISITING_PRICE, String TAGS, String CITY, String STATE, String PIN) {
        this.ID = ID;
        this.EMAIL_ID = EMAIL_ID;
        this.MOBILE_NO = MOBILE_NO;
        this.FIRST_NAME = FIRST_NAME;
        this.LAST_NAME = LAST_NAME;
        this.GENDER = GENDER;
        this.CHEMBAR_ADDRESS = CHEMBAR_ADDRESS;
        this.SPECIALIZATION = SPECIALIZATION;
        this.VISITING_PRICE = VISITING_PRICE;
        this.TAGS = TAGS;
        this.CITY = CITY;
        this.STATE = STATE;
        this.PIN = PIN;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getEMAIL_ID() {
        return EMAIL_ID;
    }

    public void setEMAIL_ID(String EMAIL_ID) {
        this.EMAIL_ID = EMAIL_ID;
    }

    public String getMOBILE_NO() {
        return MOBILE_NO;
    }

    public void setMOBILE_NO(String MOBILE_NO) {
        this.MOBILE_NO = MOBILE_NO;
    }

    public String getFIRST_NAME() {
        return FIRST_NAME;
    }

    public void setFIRST_NAME(String FIRST_NAME) {
        this.FIRST_NAME = FIRST_NAME;
    }

    public String getLAST_NAME() {
        return LAST_NAME;
    }

    public void setLAST_NAME(String LAST_NAME) {
        this.LAST_NAME = LAST_NAME;
    }

    public String getGENDER() {
        return GENDER;
    }

    public void setGENDER(String GENDER) {
        this.GENDER = GENDER;
    }

    public String getCHEMBAR_ADDRESS() {
        return CHEMBAR_ADDRESS;
    }

    public void setCHEMBAR_ADDRESS(String CHEMBAR_ADDRESS) {
        this.CHEMBAR_ADDRESS = CHEMBAR_ADDRESS;
    }

    public String getSPECIALIZATION() {
        return SPECIALIZATION;
    }

    public void setSPECIALIZATION(String SPECIALIZATION) {
        this.SPECIALIZATION = SPECIALIZATION;
    }

    public Integer getVISITING_PRICE() {
        return VISITING_PRICE;
    }

    public void setVISITING_PRICE(Integer VISITING_PRICE) {
        this.VISITING_PRICE = VISITING_PRICE;
    }

    public String getTAGS() {
        return TAGS;
    }

    public void setTAGS(String TAGS) {
        this.TAGS = TAGS;
    }

    public String getCITY() {
        return CITY;
    }

    public void setCITY(String CITY) {
        this.CITY = CITY;
    }

    public String getSTATE() {
        return STATE;
    }

    public void setSTATE(String STATE) {
        this.STATE = STATE;
    }

    public String getPIN() {
        return PIN;
    }

    public void setPIN(String PIN) {
        this.PIN = PIN;
    }

    @Override
    public String toString() {
        return "DoctorDetails{" +
                "ID='" + ID + '\'' +
                ", EMAIL_ID='" + EMAIL_ID + '\'' +
                ", MOBILE_NO='" + MOBILE_NO + '\'' +
                ", FIRST_NAME='" + FIRST_NAME + '\'' +
                ", LAST_NAME='" + LAST_NAME + '\'' +
                ", GENDER='" + GENDER + '\'' +
                ", CHEMBAR_ADDRESS='" + CHEMBAR_ADDRESS + '\'' +
                ", SPECIALIZATION='" + SPECIALIZATION + '\'' +
                ", VISITING_PRICE=" + VISITING_PRICE +
                ", TAGS='" + TAGS + '\'' +
                ", CITY='" + CITY + '\'' +
                ", STATE='" + STATE + '\'' +
                ", PIN='" + PIN + '\'' +
                '}';
    }
}
