# -------- BUILD STAGE --------
FROM maven:3.9.9-eclipse-temurin-25 AS build

WORKDIR /app

# Copy everything
COPY . .

# Build the jar
RUN mvn clean package -DskipTests

# -------- RUN STAGE --------
FROM eclipse-temurin:25-jre

WORKDIR /app

# Copy jar from build stage
COPY --from=build /app/target/*.jar app.jar

# Expose Spring Boot port
EXPOSE 8080

# Run the application
CMD ["java", "-jar", "app.jar"]
