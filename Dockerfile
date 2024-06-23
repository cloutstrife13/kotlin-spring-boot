FROM gradle:8.8.0-jdk17 as builder
USER root
WORKDIR /builder
ADD . /builder
RUN gradle build --stacktrace

FROM openjdk:17-jdk-slim
WORKDIR /app
EXPOSE 8080
COPY --from=builder /builder/build/libs/server.jar .
CMD ["java", "-jar", "server.jar"]