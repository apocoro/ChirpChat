FROM eclipse-temurin:17-jre
WORKDIR /app
COPY target/ChirpCharts-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-Xms256m","-Xmx512m","-jar","app.jar"]


