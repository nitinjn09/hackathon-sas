FROM iartifactory.infinera.com/tnps-docker-local/tnps-java:0.0.1
ADD build/libs/application-server-0.0.1-SNAPSHOT.jar application-server.jar
ENTRYPOINT ["java","-jar","/application-server.jar"]