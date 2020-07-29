package AtmSimulation;

public class AtmSimulation {
    private boolean userAuthenticated; // Whether user is Authenticated
    private int currentAccountNumber; // current user's account number
    // Create the objects of the other classes
    private Screen screen; // ATM SCREEN
    private CashDispenser dispenser; //Atm cash dispenser
    private DepositeSlut depositeSlut;
    private BankDatabase bankDatabase;

    // Constants corresponding to main menu options
    private static final int BALANCE_INQUIRY = 1;
    private static final int WITHDRAWAL = 2;
    private static final int DEPOSIT = 3;
    private static final int EXIT = 4;

    public static void main(String[] args) {

    }
}
