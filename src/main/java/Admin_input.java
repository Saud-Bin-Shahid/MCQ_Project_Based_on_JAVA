import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Admin_input {

    public static void AdminCreates() throws IOException, ParseException, IOException, ParseException {

        char ch='y';
        String fileName="./src/main/resources/questions.json";
        do {
            JSONParser jsonParser = new JSONParser();
            Object obj = jsonParser.parse(new FileReader(fileName));
            JSONObject questions = new JSONObject();

            Scanner input = new Scanner(System.in);
            System.out.println("Input Your Question");
            questions.put("Question", input.nextLine());
            System.out.println("Input option 1:");
            questions.put("Option 1", input.nextLine());
            System.out.println("Input option 2:");
            questions.put("Option 2", input.nextLine());
            System.out.println("Input option 3:");
            questions.put("Option 3", input.nextLine());
            System.out.println("Input option 4:");
            questions.put("Option 4", input.nextLine());
            System.out.println("What is the Answer Key?");
            questions.put("Answer Key", input.nextLine());

            JSONArray jsonArray = (JSONArray) obj;
            jsonArray.add(questions);
            FileWriter file = new FileWriter(fileName);
            file.write(jsonArray.toJSONString());

            file.flush();
            file.close();

            System.out.println("Saved Successfully!");
            System.out.println("\nDo you want to add more questions? [y/n]");
            ch=input.next().charAt(0);

        }
        while(ch!='n');

    }

}
