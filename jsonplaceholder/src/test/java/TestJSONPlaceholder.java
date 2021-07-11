import client.JSONPlaceHolderClient;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import load.LoadBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

public class TestJSONPlaceholder extends JSONPlaceHolderClient {

    LoadBase loadBase;
    private String URI;
    private String endpoint;
    private  String complete_URI;
    Response response;
    ValidatableResponse validatableResponse;

    @BeforeMethod
    public void setUp(){
        loadBase = new LoadBase();
        this.URI= loadBase.properties.getProperty("JSONPlaceholderURI");
    }

//    @Test
//    public void testGetPosts(){
//        String api_uri = URI + RESOURCE_POSTS;
//
//        Response response = get(api_uri);
//        System.out.println("STATUS CODE: "+ response.statusCode());
//        response.then().assertThat().statusCode(200);
//        response.body().prettyPeek();
//        //System.out.println(response.then().extract().body().asPrettyString());
    //}

      @Test
    public void testGetPosts(){
        response = this.get();
        System.out.println("STATUS CODE: "+ response.statusCode());
        response.then().assertThat().statusCode(200);
        response.body().prettyPeek();
        //System.out.println(response.then().extract().body().asPrettyString());
    }




    @Test
    public void testGetComments(){
        endpoint = getRESOURCE_COMMENTS();
        complete_URI = URI + endpoint;

       response = get(complete_URI);
        System.out.println("STATUS CODE: "+ response.statusCode());
        response.then().assertThat().statusCode(200);
        response.body().prettyPeek();
        //System.out.println(response.then().extract().body().asPrettyString());
        response.then().assertThat().statusCode(200).body("id",hasSize(500));
    }

    @Test
    public void testPostPosts(){
        endpoint = getRESOURCE_POSTS();
        complete_URI = URI + endpoint;

        HashMap<String, String> jsonBody = new HashMap<>();
        jsonBody.put("name", "Reto");
        jsonBody.put("id", "8439WI");
        jsonBody.put("address", "Wisconsin");

        validatableResponse = post(jsonBody,complete_URI);
        validatableResponse.assertThat().statusCode(200);
        validatableResponse.statusCode(200).assertThat().body("name",hasToString("Reto"));
        System.out.println(validatableResponse.extract().response().body().asPrettyString());
    }




}
