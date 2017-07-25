# JodaTime Parsing Debugger

## Building

	./gradlew clean build

## Running

	./gradlew bootRun

The application will be available on http://localhost:8080/. Java 8 is required.

To listen on a different port than 8080:

	./gradlew clean bootRun -Dserver.port=8082

## Deploying to Heroku

Make sure the jar with the current project version is called in `Procfile`.
