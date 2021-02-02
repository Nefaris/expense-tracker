import utils.UserInput;
import wallet.Wallet;
import wallet.enums.WalletAction;

public class Main {
    public static void main(String[] args) {
        final Wallet wallet = new Wallet(1000, "zł");
        while (true) {
            wallet.displayWalletInfo();
            wallet.displayHistoryOperations(5);
            wallet.displayWalletActions();

            WalletAction selectedAction = WalletAction.values()[UserInput.getScanner().nextInt() - 1];
            switch (selectedAction) {
                case ADD_SINGLE_EXPENSE: {
                    wallet.createSingleExpense();
                    break;
                }

                case ADD_SINGLE_INCOME: {
                    wallet.createSingleIncome();
                    break;
                }
            }

            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        }
    }
}
