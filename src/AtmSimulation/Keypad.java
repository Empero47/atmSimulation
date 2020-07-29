package AtmSimulation;

import java.util.Scanner;

public class Keypad {
    private Scanner input;

    public Keypad() {
        input = new Scanner(System.in);
    }

    public int GetInput() {
        return input.nextInt();
    }
}
