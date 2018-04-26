FROM openjdk:8-jre-alpine3.7
COPY /target/service-project-0.1.0.jar /home/service-project-0.1.0.jar
CMD ["java", "-jar", "/home/service-project-0.1.0.jar"]