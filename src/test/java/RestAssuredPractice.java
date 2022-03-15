import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

// given - all input
// when - submit api (http request + resource)
// then - validate response

public class RestAssuredPractice {
    public String employee_id = "1";
    @Test
    // POST request
    public void post() {
        RestAssured.baseURI = "http://dummy.restapiexample.com/";
        employee_id =
        //Response response =
        given().
                body("{\"name\": \"test name134\"," +
                        "\"salary\": \"134\"," +
                        "\"age\": \"134\"}").
        when().
                post("api/v1/create").
        then().log().all().
                statusCode(200).
        extract().
                //response();
               path("data.id").toString();
        //String employee_id = response.path("id");
        System.out.println("id = " + employee_id);
    }

    @Test
    // GET request
    public void get(){
        RestAssured.baseURI = "http://dummy.restapiexample.com/";
        when().
                get("api/v1/employee/13").
        then().log().all().
                statusCode(200);
    }

    @Test
    // PUT request
    public void put(){
        String employee_id_put = "1";
        RestAssured.baseURI = "http://dummy.restapiexample.com/";
        given().
                body("{\"name\": \"test name135\"}").
        when().
                put("api/v1/update/" + employee_id).
        then().log().all().
                statusCode(200);
        System.out.println("id = " + employee_id);
    }
}
