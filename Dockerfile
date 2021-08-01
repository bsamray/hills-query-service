FROM openjdk:11.0.1-jre-slim-stretch
EXPOSE 8080
COPY target/*.jar /hills-service.jar
ENTRYPOINT ["java","-jar","/hills-service.jar"]