package baseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class baseUrlDummyExample extends baseUrlJsonPlaceholder{

   protected RequestSpecification specDummyExample ;

   @Before

    public void setUp(){



       specDummyExample= new RequestSpecBuilder()
               .setBaseUri("https://dummy.restapiexample.com/api/v1")
               .build();



   }
}
