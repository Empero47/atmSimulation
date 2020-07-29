package AtmSimulation;

public class Deposite extends Transaction {
    private double amount;
    private Keypad keypad;
    private DepositeSlut depositeSlut;
    private final static int CANCELED = 0;

    // Deposit constructor
    public Deposite(int userAccountNumber, Screen atmScreen,
                    BankDatabase database, Keypad atmKeypad, DepositeSlut slut) {
        super(userAccountNumber, atmScreen, database);

        keypad = atmKeypad;
        depositeSlut = slut;
    }

    // Perform transaction
    public void execute() {

    }

    public double promptForDepositAmount() {
        Screen screen = getScreen();

        // Display a prompt
        screen.displayMessage("\nPlease Enter the deposit amount Or 0 to cancel: ");
        int input = keypad.GetInput();

        // Check whether the user canceled or entered a valid amount
        if (input == CANCELED) {
            return CANCELED;
        } else {
            return (double) input / 100;
        }
    }

}
