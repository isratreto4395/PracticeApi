package restAssuredPackage;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import util.RandomGenerator;

import java.util.HashMap;

public class BDDApproach_Demo1_PUT_Request {

    public static HashMap map = new HashMap();
    String empName = RandomGenerator.empName();
    String empSalary = RandomGenerator.empSal();
    String empAge = RandomGenerator.empAge();
    int emp_id = 11254;

    @BeforeClass
    public void putData(){
        map.put("name", empName);
        map.put("salary", empSalary);
        map.put("age", empAge);

        RestAssured.baseURI= "http://dummy.restapiexample.com/api/v1";
        RestAssured.basePath = "/update/"+emp_id;
    }


}
