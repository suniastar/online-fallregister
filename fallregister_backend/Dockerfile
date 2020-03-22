FROM openjdk:13-slim

ENV SPRING_PROFILES_ACTIVE="postgres"

ENV API_PORT="8080"

WORKDIR /srv

COPY target/*.jar /srv/app.jar

CMD ["sh", "-c", "java ${JAVA_OPTS} -jar app.jar"]