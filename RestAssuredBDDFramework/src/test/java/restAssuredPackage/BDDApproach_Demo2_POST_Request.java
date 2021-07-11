package restAssuredPackage;

//import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import util.RandomGenerator;

import java.util.HashMap;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class BDDApproach_Demo2_POST_Request {

    public static HashMap map = new HashMap();


    @BeforeClass // so before testing, i need to post data
    public void postData(){
        map.put("FirstName", RandomGenerator.getFirstName());
        map.put("LastName",RandomGenerator.getLastName());
        map.put("UserName",RandomGenerator.getUserName());
        map.put("Password",RandomGenerator.getPassword());
        map.put("Email",RandomGenerator.getEmail());

        baseURI = "http://restapi.demoqa.com/customer";
        basePath = "/register"; //this is like the end point
    }

    @Test
    public void testPost(){// we want use the date from the post data to send our request in this method

        given()// in here we have to mention the type of data we r posting and the body of the data.. these are all prerequisites
                .contentType("application/json")
                .body(map)// map contains the data we want to post

                .when()
                .post()

                .then()
                .statusCode(201)
                .and()
                .body("SuccessCode",equalTo( "OPERATION_SUCCESS"))
                .and()
                .body("Message",equalTo( "Operation completed successfully"));

    }
}
