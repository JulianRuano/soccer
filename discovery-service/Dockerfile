# Etapa de construcción
FROM eclipse-temurin:24-jdk-alpine AS builder
WORKDIR /app
COPY . /app
RUN chmod +x ./mvnw
RUN ./mvnw clean package -DskipTests

# Etapa principal
FROM eclipse-temurin:24-jre-alpine AS main
WORKDIR /app
COPY --from=builder /app/target/*.jar /usr/local/springboot-app.jar
CMD ["java", "-jar", "/usr/local/springboot-app.jar"]
