FROM adoptopenjdk/maven-openjdk11 AS MAVEN_TOOL_CHAIN

COPY pom.xml /tmp
COPY application /tmp/application
COPY configuration /tmp/configuration
COPY core /tmp/core
COPY integration-adapter /tmp/integration-adapter
COPY persistence-adapter /tmp/persistence-adapter
COPY web-adapter /tmp/web-adapter

WORKDIR /tmp
RUN mvn clean install

FROM adoptopenjdk/openjdk11:ubi
COPY --from=MAVEN_TOOL_CHAIN /tmp/configuration/target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]