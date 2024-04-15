FROM adoptopenjdk:11-jre-hotspot

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java", "-jar", "/java-web-project.jar"]
