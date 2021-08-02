FROM openjdk:11.0.12-jdk-oracle

COPY target/DemoEureka-0.0.1-SNAPSHOT.jar DemoEureka-0.0.1-SNAPSHOT.jar

# Make port 8080 available to the world outside this container
EXPOSE 8761

# Run the jar file 
ENTRYPOINT ["java","-jar","DemoEureka-0.0.1-SNAPSHOT.jar"]
