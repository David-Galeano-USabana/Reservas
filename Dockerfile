FROM openjdk:11
COPY target/reservas.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]