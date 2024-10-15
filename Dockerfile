FROM ubuntu:22.04

# Install OpenJDK and basic utilities
RUN apt-get update && \
    apt-get install -y openjdk-21-jdk curl wget git

ADD target/hotelservice.jar hotelservice.jar
EXPOSE 8080
# Set the active profile to dock
ENV SPRING_PROFILES_ACTIVE dock
ENTRYPOINT ["java", "-jar", "hotelservice.jar"]
