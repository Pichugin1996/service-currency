FROM openjdk:8-jdk-alpine
EXPOSE 8085
COPY build/libs/service-currency-1.jar .
ENTRYPOINT ["java", "-jar", "service-currency-1.jar"]
