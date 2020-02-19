package login_register_quiz;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LoginRegisterQuiz {

    public static String userLoggedIn = "";
    public static boolean isLoggedIn = false;
    public static List<User> users = new ArrayList<User>();
    public static List<User> scores = new ArrayList<User>();

    public static void main(String[] args) {

        System.out.println("Welcome!\n");
        Scanner scanner = new Scanner(System.in);
        while(true){
            String option = selectOption(scanner);

            // -------LOGIN------
            if("1".equals(option)){

                System.out.print("Enter Username : ");
                String inputUsername = scanner.next();
                System.out.print("Enter Password : ");
                String inputPassword = scanner.next();
                User user = new User();
                user.username = inputUsername;
                user.password = inputPassword;

                if(authenticate(users, inputUsername, inputPassword)){
                    isLoggedIn = true;
                    userLoggedIn = inputUsername;
                    System.out.println("\n--------------------\nSuccessfully logged in!");
                    System.out.println("--------------------\n");
                }else{
                    System.err.println("\n--------------------\nInvalid username or password!\n--------------------\n");
                }

                // -------REGISTER------
            } else if("2".equals(option)){

                System.out.print("Enter Username : ");
                String inputUsername = scanner.next();

                System.out.print("Enter Password : ");
                String inputPassword = scanner.next();

                System.out.print("Re-type Password : ");
                String inputConfirmPassword = scanner.next();

                if(inputPassword.equals(inputConfirmPassword)){
                    User user = new User();
                    user.username = inputUsername;
                    user.password = inputPassword;

                    users.add(new User(inputUsername, inputPassword, 0));
                    System.out.println("\n--------------------\nSuccessfully registered!\n--------------------\n");
                } else {
                    System.err.println("\nPassword don't match!\n");
                }

            }
            // -------TAKE QUIZ------
            else if("3".equals(option)){

                if(isLoggedIn) {
                    int score = 0;

                    // QUESTION #1
                    System.out.println("1.) 1 + 1 = ?");
                    String q1 = scanner.next();
                    String q1answer = "2";
                    if (q1.equals(q1answer)) {
                        score = score + 1;
                    }

                    // QUESTION #2
                    System.out.println("2.) How many months in 3 years?");
                    String q2 = scanner.next();
                    String q2answer = "36";
                    if (q2.toLowerCase().equals(q2answer.toLowerCase())) {
                        score = score + 1;
                    }

                    // QUESTION #3
                    System.out.println("3.) How many stars on Philippine Flag?");
                    String q3 = scanner.next();
                    String q3answer = "3";
                    if (q3.equals(q3answer)) {
                        score = score + 1;
                    }

                    User userScore = new User();
                    userScore.username = userLoggedIn;
                    userScore.score = score;

                    scores.add(userScore);
                    System.out.println("\nYour score is: " + score + "\n");
                } else{
                    System.err.println("\nLogin to take quiz!\n");
                }
            }

            // ------VIEW HIGH SCORE-------
            else if("4".equals(option)){
                if(scores.size() > 0){
                    getHigestScore();
                }else{
                    System.err.println("\nTake quiz to generate highest score!\n");
                }
            }

            // ------EXIT-------
            else if("5".equals(option)){
                System.exit(1);
            }
        }

    }

    private static String selectOption(Scanner scanner){
        if(isLoggedIn){
            System.out.println("Hello, " + userLoggedIn);
        }
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.println("3. Quiz");
        System.out.println("4. High Score");
        System.out.println("5. Exit");
        System.out.print("Select option:");
        String option = scanner.next();
        return option;
    }

    public static void getHigestScore(){
        User highestScore = new User();
        int currentHighest = 0;
        for (User userScore : scores) {
            int score = userScore.getScore();
            if (score > currentHighest) {
                highestScore.score = score;
                highestScore.username = userScore.username;
                currentHighest = score;
            }
        }
        System.out.println("\nHighest Score is: " + highestScore.getScore() + " - " + highestScore.getUsername() + "\n");
    }
    private static boolean authenticate(List<User> users, String username, String password){
        boolean valid = false;
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                valid = true;
            }
        }
        return valid;
    }
    private boolean validateInput(String value){
        if(value.isEmpty()){
            return false;
        }
        return true;
    }


    public static class User{
       
        private String username;
        private String password;
        private int score;
        public User(){
            
        }
        public User(String username, String password, int score) {
            this.username = username;
            this.password = password;
            this.score = score;
        }

        public String getUsername(){
            return username;
        }
        public String getPassword(){
            return password;
        }
        public int getScore(){
            return score;
        }
    }
}
