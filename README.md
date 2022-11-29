# Library

Notes:
1. Using flapdoodle embedded mongo, not thru docker
2. Switching between book api providers is transparent and done with app.properties and restart of app, no modifications in the code needed
3. Added swagger for simple testing of api
4. Issue with flapdoodle causes mongo instance to stay alive after killing app, so either go to task manager and kill extractmongo process or change mongo port in app.properties to restart 

Things which took me time:
1. Configuration of embedded mongo took me a bit
2. Consideration on how to make sure switching between bookproviders seamless and if it should be also possible during run time of application

Things which I would improve on:
1. Exception handling
2. Add logging to the service
3. Add Testing coverage

Links:
http://localhost:8080/swagger-ui/index.html

