FROM iartifactory.infinera.com/tnps-docker-local/tnps-java:0.0.1
VOLUME /tmp
ADD build/libs/db-core-0.0.1-SNAPSHOT.jar db-core.jar
ENTRYPOINT ["java","-jar","/db-core.jar"]