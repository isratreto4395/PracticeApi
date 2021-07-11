package restAssuredPackage;

import org.testng.annotations.*;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class BDDApproach_Demo1_GET_Request {

    //        given().
    // set cookies, add authorization, add parameters, set header information, etc
//        when(). --> its like a condition---> any request we are sending to the server
    //get, post, put, dele
//        then(). ---> validation
    // validating status code. extracting response from API, extracting response from headers, extract the cookies that were created from the response
    //we can also capture response body


    // get request --> weatherAPI

    //It uses Hamcrest Matchers for comparing actual response with the expected response.


    @Test
    public void getWeatherDetails() {
        given()
                .when()
                .get("http://restapi.demoqa.com/utilities/weather/city/Hyderabad")
                .then()
                .statusCode(200)
                .statusLine("HTTp/1.1 200 OK")
                .assertThat().body("City", equalTo("Hyderabad"))
                .header("Content-Type", "application/json");
    }


}
