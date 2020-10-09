# Country City Locator

### Requirements
A spring boot application that has a GET endpoint which will return Country for the provided city.

### Starting Application
To start the application run the following commands 

./gradlew clean bootRun


You can import the project in any IDE and use the CountryLocatorApplication class to run the application.

The Application will start on `8080` port which you can access via browser at "http://localhost:8080/country?city={cityName}".

Providing the city name will return the country associated with it.

You can open the swagger-ui at http://localhost:8080/swagger-ui.html and this the API.
