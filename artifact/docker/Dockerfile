FROM openjdk:11-jdk-slim

ARG VERSION
LABEL ue.app.group="ue.app.ntpartner" ue.app.name="ntpartner" ue.app.version="${VERSION}"

WORKDIR /app
COPY *.jar /app/ntpartner.jar
COPY logback.xml /app/logback.xml
COPY run.sh /app/run.sh

EXPOSE 8080

ENV JAVA_OPTS="-Xmx1g"
ENTRYPOINT ["/app/run.sh"]

