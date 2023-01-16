package com.spring.microservice.doctor.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DoctorLogin {
	@Id
	private String EMAIL_ID;
	private String PASSWORD;

	public DoctorLogin() {
	}

	public DoctorLogin(String eMAIL_ID, String pASSWORD) {

		EMAIL_ID = eMAIL_ID;
		PASSWORD = pASSWORD;
	}

	public String getEMAIL_ID() {
		return EMAIL_ID;
	}

	public void setEMAIL_ID(String eMAIL_ID) {
		EMAIL_ID = eMAIL_ID;
	}

	public String getPASSWORD() {
		return PASSWORD;
	}

	public void setPASSWORD(String pASSWORD) {
		PASSWORD = pASSWORD;
	}

	@Override
	public String toString() {
		return "DoctorLogin{" + "EMAIL_ID='" + EMAIL_ID + '\'' + ", PASSWORD='" + PASSWORD + '\'' + '}';
	}
}
