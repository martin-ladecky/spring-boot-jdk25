# --- STAGE 1: The "Construction Site" (Build) ---
# This stage has our secrets, but it will be THROWN AWAY.
FROM openjdk:26-ea-25-slim-trixie AS builder

# A: We copy the secret here to use during build (e.g., private repo access)
COPY secret.properties /tmp/secret.properties

# B: We build our application
COPY . /app
WORKDIR /app
# Simulate using the secret
RUN echo "Authenticating with $(cat /tmp/secret.properties)..." && ./mvnw package -DskipTests

# --- STAGE 2: The "Clean Room" (Runtime) ---
# This is the ONLY part that the customer/hacker receives.
FROM openjdk:26-ea-25-slim-trixie

# C: We ONLY copy the finished artifact from the builder stage
COPY --from=builder /app/target/martin-0.0.1-SNAPSHOT.jar /app.jar

# D: The /tmp/secret.properties file DOES NOT EXIST in this stage.
ENTRYPOINT ["java", "-jar", "/app.jar"]