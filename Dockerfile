FROM openjdk:20

WORKDIR /app
COPY ./target/GuavaPay-task-0.0.1-SNAPSHOT.jar /app

EXPOSE 8080

CMD ["java", "-jar", "GuavaPay-task-0.0.1-SNAPSHOT.jar"]