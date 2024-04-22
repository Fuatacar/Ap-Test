import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;


public class C02_Get_Request_Response_Bilgileri_Manuel {


    @Test
    public void test1(){
        String url ="https://restful-booker.herokuapp.com/booking/10";

        Response response = given().when().get(url);


        System.out.println(response.getStatusCode());
        System.out.println(response.getContentType());
        System.out.println(response.getHeader("server"));
        System.out.println(response.getStatusLine());
        System.out.println(response.getTime());


    }
}
