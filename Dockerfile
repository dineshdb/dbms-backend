FROM openjdk
WORKDIR /
COPY /build/libs/ .
EXPOSE 81
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-Dspring.profiles.active=container", "-jar", "/ictc_events.jar"]
