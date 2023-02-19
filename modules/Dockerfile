FROM eclipse-temurin:18.0.2_9-jdk-alpine

RUN mkdir /example
COPY application/target/application-1.0-SNAPSHOT-dir/* /example/

ENTRYPOINT java -p /example -m org.example.application
