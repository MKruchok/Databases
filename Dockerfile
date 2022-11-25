FROM openjdk:11
EXPOSE 8080
ADD target/db6mk-1.1.0.jar db6mk-1.1.0.jar
ENTRYPOINT ["java","-jar","/db6mk-1.1.0.jar"]