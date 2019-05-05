FROM openjdk:8-jre-alpine
COPY target/*.jar app.jar
CMD [ "sh", "-c", "java -jar app.jar" ]
