### build image ###
FROM openjdk:11-jdk-slim-buster as build
WORKDIR /workspace/app
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src

# build fat jar & unpack it
#RUN --mount=type=cache,target=/root/.m2 ./mvnw install -DskipTests
RUN ./mvnw install -DskipTests
RUN mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)

### application image ###
FROM openjdk:11-jdk-slim-buster
VOLUME /tmp
RUN apt-get update; \
    apt-get install -y bash curl
ARG DEPENDENCY=/workspace/app/target/dependency
COPY --from=build ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY --from=build ${DEPENDENCY}/META-INF /app/META-INF
COPY --from=build ${DEPENDENCY}/BOOT-INF/classes /app
COPY docker/* /app
ENTRYPOINT ["app/entrypoint.sh"]

EXPOSE 8080
