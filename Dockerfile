FROM amazoncorretto:22
EXPOSE 8080:8080
RUN mkdir /app
COPY app/build/libs/*-all.jar /app/ktor-docker-sample.jar
ENTRYPOINT ["java","-jar","/app/ktor-docker-sample.jar"]
