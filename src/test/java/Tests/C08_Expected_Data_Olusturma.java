package Tests;

import org.json.JSONObject;
import org.junit.Test;

public class C08_Expected_Data_Olusturma {

    @Test
    public void test01(){



        // 1 - endpoint ve request hazırlama
        String url = "https://jsonplaceholder.typicode.com/posts/22";


        // 2 - expected data olustur

        JSONObject expectedData = new JSONObject();

        expectedData.put("userId",3);
        expectedData.put("Id",22);
        expectedData.put("title","dolor sint quo a velit explicabo quia nam");
        expectedData.put("body","eos qui et ipsum ipsam suscipit aut\\nsed omnis non odio\\nexpedita earum mollitia molestiae aut atque rem suscipit\\nnam impedit esse");

        System.out.println(expectedData.toString());


    }
}
