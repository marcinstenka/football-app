FROM eclipse-temurin:17.0.6_10-jre


LABEL org.opencontainers.image.title="football-app-player"
LABEL org.opencontainers.image.authors="Marcin Stenka"
LABEL org.opencontainers.image.vendor="Gdańsk University of Technology"
LABEL org.opencontainers.image.version="1.0.0-SNAPSHOT"


ENV VERSION="1.0.0"
ENV TITLE="football-app-player"

ENV SERVER_PORT=8080

ENV SPRING_DATASOURCE_URL=jdbc:h2:mem:football-app-player
ENV SPRING_DATASOURCE_DRIVERCLASSNAME=org.h2.Driver
ENV SPRING_DATASOURCE_USERNAME=admin
ENV SPRING_DATASOURCE_PASSWORD=password

ENV SPRING_JPA_DATABASE_PLATFORM=org.hibernate.dialect.H2Dialect
ENV SPRING_JPA_GENERATE_DDL=true
ENV SPRING_JPA_HIBERNATE_DDL_AUTO=update

ENV SPRING_H2_CONSOLE_enabled=true

EXPOSE 8080

COPY target/*.jar /opt/football-app-player/football-app-player.jar


CMD ["java", "-jar", "/opt/football-app-player/football-app-player.jar"]
