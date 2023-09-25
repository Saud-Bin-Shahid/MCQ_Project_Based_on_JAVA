import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
public class Student_Taking_Test {
    public static void Test() throws IOException, ParseException {

        Scanner scanner =new Scanner(System.in);
        char response;
        do{
            int marks = 0;
            String fileName ="./src/main/resources/questions.json";
            JSONParser jsonParser = new JSONParser();
            JSONArray questions = (JSONArray) jsonParser.parse(new FileReader(fileName));


            for(int i=0; i<10; i++) {
                Random random = new Random();
                int que = random.nextInt(questions.size()-1);
                JSONObject queObject = (JSONObject) questions.get(que);

                String Question = queObject.get("Question").toString();
                String Option_1 =queObject.get("Option 1").toString();
                String Option_2 =queObject.get("Option 2").toString();
                String Option_3 =queObject.get("Option 3").toString();
                String Option_4 =queObject.get("Option 4").toString();
                String Answer_key =queObject.get("Answer Key").toString();

                System.out.println("Question-"+(i+1)+": "+ Question);
                System.out.println("1. "+Option_1);
                System.out.println("2. "+Option_2);
                System.out.println("3. "+Option_3);
                System.out.println("4. "+Option_4);
                System.out.println("Enter your Answer:");
                String answer=scanner.next();

                if(Answer_key.equals(answer)){
                    marks++;
                }

            }

            if(marks>=8){
                System.out.println("Excellent! You have got "+ marks + " out of 10");
            }
            else if (marks>=5 && marks<8) {
                System.out.println("Good. You have got "+ marks + " out of 10");
            }
            else if (marks>=2 && marks<5) {
                System.out.println("Very poor! You have got "+ marks + " out of 10");
            }
            else {
                System.out.println("Very sorry you are failed. You have got " + marks + " out of 10");
            }
            System.out.println("Would you like to start again? Press 's' for start or q for quit.");
            response =scanner.next().charAt(0);

            if(response=='q'){
                break;
            }
        }
        while ('q' != response);

    }
}
