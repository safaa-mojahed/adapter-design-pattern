package App;


import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;
import java.io.FileWriter;
import java.io.FileWriter;
import java.io.IOException;


public class Adapter extends xml {
    private Json json;

    public Adapter(Json json1) {
        this.json = json1;
    }

    public void convertXmlTOJson () throws JSONException {

        String xml_data = "data.xml>";

        //converting xml to json
        JSONObject jsonObject = XML.toJSONObject(xml_data);


        try{
            FileWriter fileWriter=new FileWriter("data.json");
            fileWriter.write(jsonObject.toString());
            fileWriter.close();
        }catch(Exception e){System.out.println(e);}
        System.out.println("Success...");
    }
}



