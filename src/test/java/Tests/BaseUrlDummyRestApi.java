package Tests;

import baseUrl.baseUrlJsonPlaceholder;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class BaseUrlDummyRestApi extends baseUrlJsonPlaceholder {

    @Test
    public void test01(){

// 1 - https://jsonplaceholder.typicode.com/posts  buraya bir get istegi atip donen responsenin
        // status code nun 200 oldugunu ve responsta 100 kayit oldugunu kontrol edin

        specJsonPlaceholder.pathParam("pp1","posts");

        Response response = given()
                .when().spec(specJsonPlaceholder)
                .get("/{pp1}");




        response.then()
                .assertThat()
                .statusCode(200)
                .body("title",Matchers.hasSize(100));





    }
}
