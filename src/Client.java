public class Client {
    private String userID;
    private String newPassword;

    public Client(String userID, String newPassword) {
        this.userID = userID;
        this.newPassword = newPassword;
    }

    public String getUserID() {
        return this.userID;
    }

    public String getNewPassword() {
        return this.newPassword;
    }
}
