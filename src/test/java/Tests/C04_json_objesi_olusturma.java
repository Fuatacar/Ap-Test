package Tests;

import org.json.JSONObject;
import org.junit.Test;

public class C04_json_objesi_olusturma {

    @Test
    public void test01(){


        JSONObject obj1 = new JSONObject();
        obj1.put("title","Fuat");
        obj1.put("body","Merhaba");
        obj1.put("userId","1");

        System.out.println(obj1);


    }
}
