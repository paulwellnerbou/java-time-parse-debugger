# JodaTime Parsing Debugger

## Building

	./gradlew clean build

## Running

### Running with Gradle and Spring Boot

	./gradlew bootRun

The application will be available on http://localhost:8080/. Java 8 is required.

To listen on a different port than 8080:

	./gradlew clean bootRun -Dserver.port=8082

### Running with Heroku locally

After building the application:

	heroku local web

Make sure the jar with the current project version is called in `Procfile`.
	
## Deploying

### Deploy to Heroku

Again, make sure the jar with the current project version is called in `Procfile`.

	git push heroku master

