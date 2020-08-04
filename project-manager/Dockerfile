FROM iartifactory.infinera.com/tnps-docker-local/tnps-java:0.0.1
VOLUME /tmp
ADD build/libs/project-manager-0.0.1-SNAPSHOT.jar project-manager.jar
ADD src/main/resources/application.yml src/main/resources/application.yml
ENTRYPOINT ["java","-jar","/project-manager.jar"]