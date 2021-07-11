package com.qa.rest.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
//import static org.hamcrest.Matchers.*;

public class GetCallBDD {

    @Test
    public void test_numberOfCircuitsFor2017_Season() {
//        given().
//        when().
//        then().
//        assert()

        given().
                when().
                get("http://ergast.com/api/f1/2017/circuits.json").
                then().
                statusCode(200).and().
                assertThat().body("MRData.CircuitTable.Circuits.circuitId", hasSize(20));
//                    Assert.
    }

}
