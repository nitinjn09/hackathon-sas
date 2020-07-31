FROM iartifactory.infinera.com/tnps-docker-local/tnps-java:0.0.1
VOLUME /tmp
ADD build/libs/sas-tool-0.0.1-SNAPSHOT.jar sas-tool.jar
ENTRYPOINT ["java","-jar","/sas-tool.jar"]