FROM openjdk:8-jdk-alpine
EXPOSE 8082
ADD /build/libs/cc-0.0.1-SNAPSHOT.jar cc.jar
ENTRYPOINT ["java", "-jar", "cc.jar"]