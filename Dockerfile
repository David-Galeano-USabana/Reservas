FROM openjdk:11
COPY build/libs/citas-0.0.1-SNAPSHOT.jar .
CMD ["java","-jar","citas-0.0.1-SNAPSHOT.jar"]