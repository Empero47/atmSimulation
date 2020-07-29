package AtmSimulation;

import sun.awt.geom.AreaOp;

public class AtmSimulation {
    private boolean userAuthenticated; // Whether user is Authenticated
    private int currentAccountNumber; // current user's account number
    // Create the objects of the other classes
    private Screen screen; // ATM SCREEN
    private Keypad keypad;
    private CashDispenser dispenser; //Atm cash dispenser
    private DepositeSlut depositeSlut;
    private BankDatabase bankDatabase;

    // Constants corresponding to main menu options
    private static final int BALANCE_INQUIRY = 1;
    private static final int WITHDRAWAL = 2;
    private static final int DEPOSIT = 3;
    private static final int EXIT = 4;

    public AtmSimulation() {
        userAuthenticated = false;
        currentAccountNumber = 0;
        screen = new Screen();
        keypad = new Keypad();
        dispenser = new CashDispenser();
        depositeSlut = new DepositeSlut();
        bankDatabase = new BankDatabase();
    }

    // Start ATM
    public void run() {
        // Welcome and authenticate user: perform transaction
        while (true) {
            // Loop while user is not yet authenticated
            while (!userAuthenticated) {
                screen.displayMessageLine("\nWelcome");
                authenticate();
            }

            performTransaction();
            userAuthenticated = false;
            currentAccountNumber = 0;
            screen.displayMessageLine("\nThank you! GoodBye");
        }
    }

    public void authenticate() {
        screen.displayMessage("\nPlease enter your account number: ");
        int accountNumber = keypad.GetInput();
        screen.displayMessage("\nPlease enter your pin");
        int pin = keypad.GetInput();

        // Set userauthenticated to boolean value returned by database
        userAuthenticated = bankDatabase.authenticateUser(accountNumber, pin);

        // Check whether authentication succeeded
        if (userAuthenticated) {
            currentAccountNumber = accountNumber;
        } else screen.displayMessageLine("\nInvalid account number or pin. Please try again");
    }

    public void performTransaction() {
        Transaction currentTransaction = null;

        boolean userExited = false;

        // Loop while user has not chosen option to exit system
        while (!userExited) {
            // Show main menu and get user selection
            int mainMenuSelection = displayMainMenu();

            // Decide how to proceed based on user menu selection
            switch (mainMenuSelection) {
                // User chose to perform one of three transaction types
                case BALANCE_INQUIRY:
                case WITHDRAWAL:
                case DEPOSIT:
                    // Initialize as new object of chosen type
                    currentTransaction = createTransaction(mainMenuSelection);
                    currentTransaction.execute();
                    break;
                case EXIT:
                    screen.displayMessageLine("\nExiting the system...");
                    userExited = true;
                    break;
                default:
                    screen.displayMessageLine("you did not enter a valid selection. Try again ");
                    break;
            }
        }
    }

    private int displayMainMenu() {}

    private Transaction createTransaction(int type) {}

}
