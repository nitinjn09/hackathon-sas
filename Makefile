
build-project-manager:
	gradle build -b ./project-manager/build.gradle

build: build-app-server build-project-manager build-db-core build-sas-tool

docker:
	docker image build -t project-manager-image:0.0.1 ./project-manager
	docker image build -t sas-tool-image:0.0.1 ./sas-ui

start-as:
	java -jar ./application-server/build/libs/application-server-0.0.1-SNAPSHOT.jar
start-pm:
	java -jar ./project-manager/build/libs/project-manager-0.0.1-SNAPSHOT.jar
start-dc:
	java -jar ./db-core/build/libs/db-core-0.0.1-SNAPSHOT.jar
start-sas:
	java -jar ./sas-tool/build/libs/sas-tool-0.0.1-SNAPSHOT.jar

load-sas:
	gradle build -b ./sas-tool/build.gradle
	docker image build -t sas-tool-image:0.0.1 ./sas-tool
	helm install sas deployment/tnps/charts/sas-tool/