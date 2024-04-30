package Tests;

import TestDatalari.TestDataDummyExample;
import baseUrl.baseUrlDummyExample;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import org.testng.Assert;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.junit.Assert.assertEquals;

public class Get_TestDataKullanimi extends baseUrlDummyExample {

    @Test
    public void test01(){


        //1 endpoint ve request body olustur


   specDummyExample.pathParams("pp1","employee","pp2","3");

   // 2 expected data olustur

        JSONObject expectedData = TestDataDummyExample.jsonResponseBodyolustur(3,
                "Ashton Cox",
                86000,
                66,
                "");


        // 3 request gonder ve donen response u kaydet

        Response response = given().
                spec(specDummyExample).
                when().
                get("{pp1}/{pp2}");

        // 4 assertion
        // expected data jsonobject
        // response jsonpath

        JsonPath responseJP = response.jsonPath();

        assertEquals(TestDataDummyExample.basariliSorguStatusCode,response.statusCode());
        assertEquals(TestDataDummyExample.contentType,response.contentType());



        assertEquals(expectedData.getJSONObject("data").getString("profile_image"),
                         responseJP.getString("data.profile_image") );




    }
}
