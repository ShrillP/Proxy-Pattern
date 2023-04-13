import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class FIM {
    private String userID;
    private String newPassword;

    public FIM(String userID, String newPassword) {
        this.userID = userID;
        this.newPassword = newPassword;
    }

    public void updatePassword() {
        File FIMRecords = new File("./records/FIMRecords.txt");
        ArrayList<String[]> records = new ArrayList<String[]>();
        try {
            Scanner scanner = new Scanner(FIMRecords);
            scanner.nextLine();
            while (scanner.hasNextLine()) {
                String[] line = scanner.nextLine().split(",");
                records.add(line);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            PrintWriter writer = new PrintWriter(FIMRecords);
            writer.println("ID,Password");
            for (String[] record : records) {
                if (this.userID.equals(record[0])) {
                    record[1] = this.newPassword;
                }
                writer.println(record[0] + "," + record[1]);
            }
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
