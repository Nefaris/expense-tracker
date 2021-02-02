import utils.UserInput;
import wallet.Wallet;
import wallet.enums.WalletAction;

public class Main {
    public static void main(String[] args) {
        final Wallet wallet = new Wallet(1000, "zł");
        boolean isRunning = true;
        while (isRunning) {
            wallet.displayWalletInfo();
            wallet.displayNewestOperations(5);
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

                case SHOW_OPERATIONS_HISTORY: {
                    wallet.displayFullHistory();
                    break;
                }

                case SHOW_EXPENSES: {
                    wallet.displayAllExpenses();
                    break;
                }

                case SHOW_INCOMES: {
                    wallet.displayAllIncomes();
                    break;
                }

                case EXIT: {
                    isRunning = false;
                    break;
                }

                default: {
                    System.out.println("No such option");
                }
            }

            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        }

        System.out.println("Bye!");
    }
}
