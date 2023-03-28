FROM openjdk:17
EXPOSE 8001
ADD target/DoctorMicroservice.jar DoctorMicroserviceImg
ENTRYPOINT ["java","-jar","/DoctorMicroservice.jar"]