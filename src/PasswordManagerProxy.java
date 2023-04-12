public class PasswordManagerProxy implements PasswordManager {
    private boolean isPasswordUsed;
    private Client currentClient;
    private FIM fim;

    public PasswordManagerProxy(Client currentClient) {
        this.currentClient = currentClient;
        this.fim = new FIM();
        this.isPasswordUsed = false;
    }

    public void updatePassword() {
    }

    private boolean verifyPasswordUsed() {
        return false;
    }

    private void informClient() {
    }
}
