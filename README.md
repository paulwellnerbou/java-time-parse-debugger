# JodaTime Parsing Debugger

This is the minimal source code for [joda-time-parse-debugger.herokuapp.com](https://joda-time-parse-debugger.herokuapp.com/), a web based debugger for parsing date and time formats with Java's [JodaTime](http://www.joda.org/joda-time/).
Inspired by [Grok Debugger](http://grokdebug.herokuapp.com/).

## Building

Java 8 is required.

	./gradlew clean build

## Running

### Running with Gradle and Spring Boot

	./gradlew bootRun

The application will be available on http://localhost:8080/.

To listen on a different port than 8080:

	./gradlew clean bootRun -Dserver.port=8082

### Running with Heroku locally

After building the application:

	heroku local web

Make sure the jar with the current project version is called in `Procfile`. The application will be available on http://localhost:5000/.
	
## Deploying

### Deploy to Heroku

Again, make sure the jar with the current project version is called in `Procfile`.

	git push heroku master

