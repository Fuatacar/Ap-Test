package Tests;

import baseUrl.baseUrlHerokuapp;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class baseUrlHerokuappQueryParam extends baseUrlHerokuapp {


    @Test
    public void test01(){

        specHerokuapp.
                pathParam("pp1","booking")
                .queryParam("firstname","Susan");


        Response response = given()
        .when().spec(specHerokuapp)
        .get("/{pp1}");

        //response.prettyPrint();


        response.then()
                .assertThat()
                .statusCode(200)
                .body("bookingid", Matchers.hasSize(2));




    }
}
