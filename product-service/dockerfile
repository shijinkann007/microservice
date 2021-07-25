FROM openjdk:11.0.12-jdk-oracle

COPY target/productService-0.0.1-SNAPSHOT.jar productService-0.0.1-SNAPSHOT.jar

# Make port 8080 available to the world outside this container
EXPOSE 8082

# Run the jar file 
ENTRYPOINT ["java","-jar","productService-0.0.1-SNAPSHOT.jar"]
