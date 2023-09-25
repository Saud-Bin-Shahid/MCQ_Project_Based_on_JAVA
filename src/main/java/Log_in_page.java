import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.Scanner;
public class Log_in_page {
    public static void main(String[] args) {

        try{
            JSONParser parser = new JSONParser();
            String fileLocation ="./src/main/resources/users.json";
            JSONArray usersArray = (JSONArray) parser.parse(new FileReader(fileLocation));
            Scanner scanner =new Scanner(System.in);

            System.out.println("Enter your username:");
            String username = scanner.next();
            System.out.println("Enter password:");
            String password = scanner.next();

            for (int i=0; i<usersArray.size();i++){

                JSONObject userObject = (JSONObject) usersArray.get(i);

                String user_name = userObject.get("username").toString();
                String pass_word = userObject.get("password").toString();
                String role = userObject.get("role").toString();

                if(username.equals(user_name) && password.equals(pass_word)){

                    if(role.equals("admin")){
                        System.out.println("Welcome admin! Please create new questions in the question bank.");
                        Admin_input.AdminCreates();
                        break;
                    }
                    else if(role.equals("student")){
                        System.out.println("Welcome " + user_name + " to the quiz! We will throw you 10 questions. Each MCQ mark is 1 and no negative marking.Are you ready? Press 's' to start.");
                        char permission = scanner.next().charAt(0);
                        if(permission=='s'){
                            Student_Taking_Test.Test();
                        }
                        break;
                    }
                }

            }
            System.out.println("Login Failed!, INVALID User_Name/Password");
        }
        catch (Exception exception) {
            System.out.println("System Error");
        }

    }
}
