FROM adoptopenjdk/openjdk11
VOLUME /tmp
ADD build/libs/application-server-0.0.1-SNAPSHOT.jar application-server.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/application-server.jar"]