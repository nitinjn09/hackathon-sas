FROM adoptopenjdk/openjdk11
VOLUME /tmp
ADD build/libs/project-manager-0.0.1-SNAPSHOT.jar project-manager.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/project-manager.jar"]