import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        outerloop:
        while (true) {
            System.out.println("Please enter your user ID:");
            Scanner scanner = new Scanner(System.in);
            String userID = scanner.nextLine();
            System.out.println("Please enter your new password:");
            String newPassword = scanner.nextLine();
            Client client = new Client(userID, newPassword);
            PasswordManagerProxy proxy = new PasswordManagerProxy(client);
            proxy.updatePassword();
            boolean continueLoop = true;
            while (continueLoop) {
                System.out.println("Would you like to try again? (y/n)");
                String answer = scanner.nextLine();
                if (answer.equals("y")) {
                    continueLoop = false;
                } else if (answer.equals("n")) {
                    continueLoop = false;
                    break outerloop;
                } else {
                    System.out.println("Invalid input!");
                }
            }
        }
    }
}
