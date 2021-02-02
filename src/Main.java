import wallet.Wallet;
import wallet.models.MoneyOperation;

public class Main {
    public static void main(String[] args) {
        final Wallet wallet = new Wallet(1000, "zł");
        wallet.addOperation(new MoneyOperation(100));
        wallet.addOperation(new MoneyOperation(-200, "Fuel"));
        wallet.addOperation(new MoneyOperation(200, "Food and water"));
        wallet.displayHistoryOperations(5);
        wallet.displayControls();
    }
}
