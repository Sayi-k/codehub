FROM openjdk:11.0-jre-buster
RUN mkdir -p /home/app
ARG JAR_FILE=target/mongo-app.jar
COPY ${JAR_FILE} /home/app
CMD ["java", "-jar", "/home/app/mongo-app.jar"]