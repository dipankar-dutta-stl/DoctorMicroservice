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

	public DoctorDetails() {

	}

	public DoctorDetails(String ID, String EMAIL_ID, String MOBILE_NO, String FIRST_NAME, String LAST_NAME,
			String GENDER, String CHEMBAR_ADDRESS, String SPECIALIZATION, Integer VISITING_PRICE, String TAGS) {
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
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getEMAIL_ID() {
		return EMAIL_ID;
	}

	public void setEMAIL_ID(String eMAIL_ID) {
		EMAIL_ID = eMAIL_ID;
	}

	public String getMOBILE_NO() {
		return MOBILE_NO;
	}

	public void setMOBILE_NO(String mOBILE_NO) {
		MOBILE_NO = mOBILE_NO;
	}

	public String getFIRST_NAME() {
		return FIRST_NAME;
	}

	public void setFIRST_NAME(String fIRST_NAME) {
		FIRST_NAME = fIRST_NAME;
	}

	public String getLAST_NAME() {
		return LAST_NAME;
	}

	public void setLAST_NAME(String lAST_NAME) {
		LAST_NAME = lAST_NAME;
	}

	public String getGENDER() {
		return GENDER;
	}

	public void setGENDER(String gENDER) {
		GENDER = gENDER;
	}

	public String getCHEMBAR_ADDRESS() {
		return CHEMBAR_ADDRESS;
	}

	public void setCHEMBAR_ADDRESS(String cHEMBAR_ADDRESS) {
		CHEMBAR_ADDRESS = cHEMBAR_ADDRESS;
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

	public void setVISITING_PRICE(Integer vISITING_PRICE) {
		VISITING_PRICE = vISITING_PRICE;
	}

	public String getTAGS() {
		return TAGS;
	}

	public void setTAGS(String tAGS) {
		TAGS = tAGS;
	}

	@Override
	public String toString() {
		return "DoctorDetails{" + "ID='" + ID + '\'' + ", EMAIL_ID='" + EMAIL_ID + '\'' + ", MOBILE_NO='" + MOBILE_NO
				+ '\'' + ", FIRST_NAME='" + FIRST_NAME + '\'' + ", LAST_NAME='" + LAST_NAME + '\'' + ", GENDER='"
				+ GENDER + '\'' + ", CHEMBAR_ADDRESS='" + CHEMBAR_ADDRESS + '\'' + ", SPECIALIZATION='" + SPECIALIZATION
				+ '\'' + ", VISITING_PRICE=" + VISITING_PRICE + ", TAGS='" + TAGS + '\'' + '}';
	}
}
