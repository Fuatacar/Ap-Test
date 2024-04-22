import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class softAssertPost {
    @Test
    public void test01(){


        // 1- endpoint ve request body olustur

        String url = "https://dummy.restapiexample.com/api/v1/update/21";

        JSONObject requestBody = new JSONObject();
        JSONObject dataBilgileriJson = new JSONObject();

        dataBilgileriJson.put("name","Ahmet");
        dataBilgileriJson.put("salary","1240");
        dataBilgileriJson.put("age",44);
        dataBilgileriJson.put("id",40);

        requestBody.put("status","success");
        requestBody.put("data",dataBilgileriJson);




        // 2- expected data olustur

        JSONObject expectedData = new JSONObject();
        expectedData.put("status","success");
        expectedData.put("data",requestBody);
        expectedData.put("message","Successfully! Record has been updated.");


        // 3 - request gönder ve dönen response ı kaydet


        Response response = given().contentType(ContentType.JSON)
                .when().body(requestBody.toString())
                .post(url);

        response.prettyPrint();

        // 4. assertions

        JsonPath responsejsomPath = response.jsonPath();





        SoftAssert softAssert = new SoftAssert();
        softAssert.assertAll();




    }
}
