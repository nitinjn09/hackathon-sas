FROM adoptopenjdk/openjdk11
VOLUME /tmp
ADD build/libs/db-core-0.0.1-SNAPSHOT.jar db-core.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/db-core.jar"]