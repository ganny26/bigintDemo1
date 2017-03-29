package demo;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class App 
{

    public static void main( String[] args )
    {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("fname","Steve");
        jsonObject.put("lname","Jobs");
        JSONObject jsonObject1 = new JSONObject();
        jsonObject1.put("fname","Mark");
        jsonObject1.put("lname","Zuck");


        JSONArray jsonArray = new JSONArray();
        jsonArray.add(jsonObject);
        jsonArray.add(jsonObject1);
        System.out.print(jsonArray);

        ArrayList<String> employees = new ArrayList<String>();

        for(int i=0;i<jsonArray.size();i++){
            employees.add(jsonArray.get(i));
        }


    }
}
