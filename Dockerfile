FROM eclipse-temurin:17-jdk AS build-stage
WORKDIR /app
COPY mvnw /app/mvnw
COPY .mvn /app/.mvn
COPY pom.xml /app/pom.xml
COPY src /app/src
RUN chmod +x /app/mvnw && /app/mvnw package -DskipTests

FROM eclipse-temurin:17-jre AS final-stage
WORKDIR /app
COPY --from=build-stage /app/target/*.jar /app/bankflow-api.jar
USER 1000
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/bankflow-api.jar"]
