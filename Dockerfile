FROM openjdk:26-ea-25-slim-trixie

# Step A: The Leak
# We copy a sensitive file into the image
COPY secret.properties /tmp/secret.properties

# Step B: The "Fake" Cleanup
# We delete it, thinking it's gone from the final image
RUN rm /tmp/secret.properties

COPY target/martin-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
