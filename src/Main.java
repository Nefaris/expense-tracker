import wallet.Wallet;
import wallet.enums.WalletOperation;
import wallet.models.MoneyOperation;

import java.util.Scanner;

public class Main {
    private final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        final Wallet wallet = new Wallet(1000, "zł");
        while (true) {
            wallet.displayWalletInfo();
            wallet.displayControls();
            WalletOperation value = WalletOperation.values()[scanner.nextInt() - 1];
            System.out.println(value);


            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        }

//        wallet.addOperation(new MoneyOperation(100));
//        wallet.addOperation(new MoneyOperation(-200, "Fuel"));
//        wallet.addOperation(new MoneyOperation(200, "Food and water"));
//        wallet.displayHistoryOperations(5);
//        wallet.displayControls();
    }
}
