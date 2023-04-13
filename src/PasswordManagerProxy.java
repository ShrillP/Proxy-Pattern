import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PasswordManagerProxy implements PasswordManager {
    private boolean isPasswordUsed = false;
    private boolean doesUserExist = false;
    private String date1 = "";
    private String date2 = "";
    private Client currentClient;
    private FIM fim;

    public PasswordManagerProxy(Client currentClient) {
        this.currentClient = currentClient;
        this.fim = new FIM(this.currentClient.getUserID(), this.currentClient.getNewPassword());
    }

    public void updatePassword() {
        verifyPasswordUsed();
        if (!this.isPasswordUsed) {
            this.fim.updatePassword();
        }
        informClient(this.date1, this.date2);
    }

    private void verifyPasswordUsed() {
        File localRecords = new File("./records/localRecords.txt");
        try {
            Scanner scanner = new Scanner(localRecords);
            scanner.nextLine();
            while (scanner.hasNextLine()) {
                String[] line = scanner.nextLine().split(",");
                if (this.currentClient.getUserID().equals(line[0])) {
                    this.doesUserExist = true;
                    if (this.currentClient.getNewPassword().equals(line[1])) {
                        this.isPasswordUsed = true;
                        this.date1 = line[2];
                        this.date2 = line[3];
                    }
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void informClient(String date1, String date2) {
        if (!this.doesUserExist) {
            System.out.println("This user does not exist!");
        } else {
            if (this.isPasswordUsed) {
                System.out.println("This password has been used between " + date1 + " and " + date2);
            } else {
                System.out.println("Your password has been updated successfully!");
            }
        }
    }
}
