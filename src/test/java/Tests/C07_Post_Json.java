package Tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class C07_Post_Json {

    @Test
    public void test10(){

  String url = "https://restful-booker.herokuapp.com/booking";

        JSONObject requestBody = new JSONObject();
        JSONObject rezervasyonTarihleriJson = new JSONObject();

        rezervasyonTarihleriJson.put("checkin","2023-01-10");
        rezervasyonTarihleriJson.put("checkout","2023-01-20");

        requestBody.put("firstname","Fuat");
        requestBody.put("lastname","Acar");
        requestBody.put("totalprice",500);
        requestBody.put("depositpaid",false);
        requestBody.put("bookingdates",rezervasyonTarihleriJson);
        requestBody.put("additionalneeds","wi-fi");


        Response response = given().contentType(ContentType.JSON)
                .when().body(requestBody.toString())
                .post(url);

//response.prettyPrint();



   response.then().assertThat().statusCode(200)
           .contentType(ContentType.JSON)
           .body("booking.firstname",equalTo("Fuat"),
                   "booking.lastname",equalTo("Acar"),
                   "booking.totalprice",equalTo(500),
                   "booking.depositpaid",equalTo(false),
                   "booking.bookingdates.checkin",equalTo("2023-01-10"),
                   "booking.bookingdates.checkout",equalTo("2023-01-20"));






    }
}
