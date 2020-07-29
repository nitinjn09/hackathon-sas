build-app-server:
	gradle build -b ./application-server/build.gradle
build-project-manager:
	gradle build -b ./project-manager/build.gradle
build-db-core:
	gradle build -b ./db-core/build.gradle
build-sas-tool:
	gradle build -b ./sas-tool/build.gradle

build: build-app-server build-project-manager build-db-core build-sas-tool
build-docker: build
	docker image build -t application-server-image ./application-server
	docker image build -t project-manager-image ./project-manager
	docker image build -t db-core-image ./db-core
	docker image build -t sas-tool-image ./sas-tool

start-as:
	java -jar ./application-server/build/libs/application-server-0.0.1-SNAPSHOT.jar
start-pm:
	java -jar ./project-manager/build/libs/project-manager-0.0.1-SNAPSHOT.jar
start-dc:
	java -jar ./db-core/build/libs/db-core-0.0.1-SNAPSHOT.jar
start-sas:
	java -jar ./sas-tool/build/libs/sas-tool-0.0.1-SNAPSHOT.jar
