# Java Time Parsing Debugger

This is the minimal source code for [java-time-parse-debugger.herokuapp.com](https://java-time-parse-debugger.herokuapp.com/), a web based debugger for parsing date and time formats with Java 8.
Inspired by [Grok Debugger](http://grokdebug.herokuapp.com/).

This app was formerly called "JodaTime Parsing Debugger" and was reachable under https://joda-time-parse-debugger.herokuapp.com/. As Java 8's new DateTime API is inspired by JodaTime and
users are encouraged to migrate to Java 8's API, I migrated this application as well.

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

	heroku login
	git push heroku master

