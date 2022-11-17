FROM adoptopenjdk/openjdk11:alpine

LABEL version="0.0.1" description="Api State Monitoring"

COPY ./target/estudoactuator-0.0.1-SNAPSHOT.jar /app/app.jar

WORKDIR /app

EXPOSE 8281

ENTRYPOINT exec java -jar app.jar