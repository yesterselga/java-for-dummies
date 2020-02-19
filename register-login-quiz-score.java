package midlabexa1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MidlabExA1 {

    public static void main(String[] args) {

        List<User> users = new ArrayList<User>();

        String username;
        String password;

        Scanner scanner = new Scanner(System.in);

        while(true){
            String option = selectOption(scanner);

            // -------LOGIN------
            if("1".equals(option)){

                System.out.println("Enter Username : ");
                String inputUsername = scanner.next();
                System.out.println("Enter Password : ");
                String inputPassword = scanner.next();
                User user = new User();
                user.username = inputUsername;
                user.password = inputPassword;

                if(authenticate(users, inputUsername, inputPassword)){
                    System.out.println("\n--------------------\nSuccessfully logged in!--------------------\n");
                    System.out.println("Welcome, " + inputUsername);
                }else{
                    System.out.println("\n--------------------\nInvalid username or password!\n--------------------\n");
                }

                // -------REGISTER------
            } else if("2".equals(option)){

                System.out.println("Enter Username : ");
                String inputUsername = scanner.next();

                System.out.println("Enter Password : ");
                String inputPassword = scanner.next();

                System.out.println("Re-type Password : ");
                String inputConfirmPassword = scanner.next();

                User user = new User();
                user.username = inputUsername;
                user.password = inputPassword;

                users.add(new User(inputUsername, inputPassword, 0));
                System.out.println("Successfully registered!");
            }
            // -------TAKE QUIZ------
            else if("2".equals(option)){

                System.out.println("Enter Username : ");
                String inputUsername = scanner.next();

                System.out.println("Enter Password : ");
                String inputPassword = scanner.next();

                System.out.println("Re-type Password : ");
                String inputConfirmPassword = scanner.next();

                User user = new User();
                user.username = inputUsername;
                user.password = inputPassword;

                users.add(new User(inputUsername, inputPassword, 0));
                System.out.println("Successfully registered!");
            }
        }




    }

    private static String selectOption(Scanner scanner){
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.println("3. Quiz");
        System.out.println("4. Exit");
        String option = scanner.next();
        return option;
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
    }
}