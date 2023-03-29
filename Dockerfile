FROM openjdk:17
EXPOSE 8001
ADD target/DoctorMicroservice.jar DoctorMicroservice.jar
ENTRYPOINT ["java","-jar","/DoctorMicroservice.jar"]