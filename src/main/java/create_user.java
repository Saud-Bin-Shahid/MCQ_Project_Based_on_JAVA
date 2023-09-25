import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
public class create_user {
    public static void main(String[] args) throws IOException, ParseException {

        JSONParser jsonParser = new JSONParser();
        String fileName ="./src/main/resources/users.json";
        JSONArray users = (JSONArray) jsonParser.parse(new FileReader(fileName));

        JSONObject admin = new JSONObject();
        JSONObject student = new JSONObject();

        admin.put("username","admin");
        admin.put("password","1234");
        admin.put("role","admin");

        student.put("username","salman");
        student.put("password","1234");
        student.put("role","student");

        users.add(admin);
        users.add(student);


        FileWriter fileWriter =new FileWriter(fileName);
        fileWriter.write(users.toJSONString());
        fileWriter.flush();
        fileWriter.close();
    }
}
