package com.spring.microservice.doctor;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;

@SpringBootTest
class DoctorMicroserviceApplicationTests {

    @Test
    void contextLoads() {
    }

    // @Test
    // public void testAuthentication(){
    // 	String jsonBody="{\"email_ID\":\"vignessh.raj@gmail.com\",\"password\":\"123\"}";
    // 	String token=given()
    // 			.header("Content-Type", "application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
    // 			.body(jsonBody)
    // 			.when()
    // 			.post("http://localhost:8001/api/v1/doctor/authenticate")
    // 			.then()
    // 			.assertThat().statusCode(200)
    // 			.extract().response().asString();

    // }

    // @Test
    // public void testDoctor() {
    // 	// GET TOKEN
    // 	String jsonBody = "{\"email_ID\":\"vignessh.raj@gmail.com\",\"password\":\"123\"}";
    // 	String token = given()
    // 			.header("Content-Type", "application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
    // 			.body(jsonBody)
    // 			.when()
    // 			.post("http://localhost:8001/api/v1/doctor/authenticate")
    // 			.then()
    // 			.assertThat().statusCode(200)
    // 			.extract().response().asString();

    // 	// GET DOCTOR DETAILS
    // 	String data = given()
    // 			.header("Authorization", "Bearer " + token).contentType(ContentType.JSON).accept(ContentType.JSON)
    // 			.when()
    // 			.get("http://localhost:8001/api/v1/doctor/get/vignessh.raj@gmail.com")
    // 			.then().assertThat().statusCode(200).extract().response().asString();
    // 	System.out.println(data);

    // }


    // @Test
    // public void testGetDoctorById(){
    // 	String data = given()
    // 			.header("Content-Type", "application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
    // 			.when()
    // 			.get("http://localhost:8001/api/v1/doctor/get/id/536cdccd-9b84-490b-89c6-feb4b19d079d")
    // 			.then().assertThat().statusCode(200).extract().response().asString();
    // 	System.out.println(data);
    // }

    // @Test
    // public void testValidateToken(){
    // 	String data = given()
    // 			.header("Content-Type", "application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
    // 			.when()
    // 			.get("http://localhost:8001/api/v1/doctor/validate/eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ2aWduZXNzaC5yYWpAZ21haWwuY29tIiwiZXhwIjoxNjc0OTEwMzk5LCJpYXQiOjE2NzQ4OTIzOTl9.GuEITsx7BTnX6rQ_InUbv6eClCzB2P3LyFwH92soIZLBJJOpl2LESZBH6OCqEg5iQgkHAN0bZs7R_K-Cunljrw")
    // 			.then().assertThat().statusCode(200).extract().response().asString();
    // 	System.out.println(data);
    // }
}
