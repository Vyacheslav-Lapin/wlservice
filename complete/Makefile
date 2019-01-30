.DEFAULT_GOAL := build-run

build-run: run

build:
	./mvnw clean package

run:
	./mvnw spring-boot:run

test:
	./mvnw test
#	java -jar ~/.m2/repository/org/junit/platform/junit-platform-console-standalone/1.4.0-M1/junit-platform-console-standalone-1.4.0-M1.jar [Options]

update:
	./mvnw versions:update-properties versions:display-plugin-updates
