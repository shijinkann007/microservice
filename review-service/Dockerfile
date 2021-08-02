FROM openjdk:11.0.12-jdk-oracle

COPY target/reviewService-0.0.1-SNAPSHOT.jar reviewService-0.0.1-SNAPSHOT.jar

EXPOSE 8083

# Run the jar file 
ENTRYPOINT ["java","-jar","reviewService-0.0.1-SNAPSHOT.jar"]
