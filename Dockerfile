FROM openjdk:11-jdk
VOLUME /tmp
EXPOSE 8081
ADD target/testTrycore-0.0.1-SNAPSHOT.jar testTrycore-0.0.1.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/testTrycore-0.0.1.jar"]