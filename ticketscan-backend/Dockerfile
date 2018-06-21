FROM openjdk:8-jdk-alpine
COPY /target/*.jar /ticketscan.jar
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/ticketscan.jar"]
