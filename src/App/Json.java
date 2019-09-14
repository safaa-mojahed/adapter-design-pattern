package App;

import org.json.simple.parser.JSONParser;
import org.json.*;



import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.JSONException;
import org.json.simple.parser.ParseException;

public class Json {
    Json json = new Json();
    Adapter adapter = new Adapter(json);

    public void fun() throws JSONException, ParseException, IOException {
        adapter.convertXmlTOJson();

        JSONParser parser = new JSONParser();
        try {
            Object object = parser
                    .parse(new FileReader("data.xml"));
            JSONObject jsonObject = (JSONObject)object;
            //convert Object to JSONObject
             jsonObject = (JSONObject) object;

            //Reading the String
            String name = (String) jsonObject.get("Name");
            Long age = (Long) jsonObject.get("Age");


            //Printing all the values
            System.out.println("Name: " + name);
            System.out.println("Age: " + age);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}