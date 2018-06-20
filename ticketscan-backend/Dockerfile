FROM openjdk:8-jdk-alpine
RUN "./mvnw package -Dmaven.test.skip=true"
COPY /target/*.jar /ticketscan.jar
ENTRYPOINT ["java", "-jar", "/ticketscan.jar"]
