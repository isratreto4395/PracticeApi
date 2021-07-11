package client;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import load.LoadBase;

import java.util.HashMap;

import static io.restassured.RestAssured.*;

public class JSONPlaceHolderClient {

    private final String RESOURCE_POSTS = "/posts";
    private final String RESOURCE_COMMENTS = "/comments";
    private final String RESOURCE_ALBUMS = "/albums";
    private final String RESOURCE_TODOS = "/todos";
    private final String RESOURCE_USERS = "/user";

    public String getRESOURCE_POSTS() {
        return RESOURCE_POSTS;
    }

    public String getRESOURCE_COMMENTS() {
        return RESOURCE_COMMENTS;
    }

    public String getRESOURCE_ALBUMS() {
        return RESOURCE_ALBUMS;
    }

    public String getRESOURCE_TODOS() {
        return RESOURCE_TODOS;
    }

    public String getRESOURCE_USERS() {
        return RESOURCE_USERS;
    }



    LoadBase loadBase;


    // one way

    public Response get(String url){
        RestAssured.defaultParser = Parser.JSON;// so we r saying is whatever we do in the validatable respose will be parsed in JSON

        return given().when().get(url).then().contentType(ContentType.JSON)
                                        .extract().response();
    }
    public Response get(){
        RestAssured.defaultParser = Parser.JSON;// so we r saying is whatever we do in the validatable respose will be parsed in JSON

        return given().when().get(loadBase.properties.getProperty("JSONPlaceholderURI")+RESOURCE_POSTS).then().contentType(ContentType.JSON)
                                        .extract().response();
    }

    //so we are posting, we have to send what we r positn g
    // json is stored in key value pair, so we r using hashmap to send the data in key value data structure

    public ValidatableResponse post(HashMap jsonBody, String url){
        RestAssured.defaultParser = Parser.JSON;
        return given().contentType(ContentType.JSON).with().body(jsonBody).when().post(url).then();
    }
}
