package wallet;

import wallet.models.MoneyOperation;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Wallet {
    private final ArrayList<MoneyOperation> operations;
    private final String currency;
    private final String dateFormat;
    private double balance;

    public Wallet(double balance, String currency) {
        this.operations = new ArrayList<>();
        this.currency = currency;
        this.balance = balance;
        this.dateFormat = "dd.MM.yyyy HH:mm:ss";
    }

    public void addOperation(MoneyOperation moneyOperation) {
        this.operations.add(moneyOperation);
        this.balance += moneyOperation.getValue();
    }

    public double getExpensesValue() {
        double value = 0;
        for (MoneyOperation operation : this.operations) {
            if (operation.getValue() < 0) {
                value -= operation.getValue();
            }
        }

        return value;
    }

    public double getIncomesValue() {
        double value = 0;
        for (MoneyOperation operation : this.operations) {
            if (operation.getValue() > 0) {
                value += operation.getValue();
            }
        }

        return value;
    }

    public void displayWalletInfo() {
        System.out.println("===== Your wallet =====");
        System.out.printf("Balance: %.02f%s\n", this.balance, this.currency);
        System.out.printf("Expenses: %.02f%s\n", this.getExpensesValue(), this.currency);
        System.out.printf("Incomes: %.02f%s\n", this.getIncomesValue(), this.currency);
        System.out.println("=======================\n");
    }

    public void displayHistoryOperations(int count) {
        this.displayWalletInfo();

        System.out.println("===== Your last expenses =======");

        if (this.operations.size() > 0) {
            for (int i = 0; i < Math.min(count, this.operations.size()); i++) {
                this.displayOperation(operations.get(i), i + 1);
            }
        } else {
            System.out.println("No operations");
        }

        System.out.println("================================\n");
    }

    public void displayOperation(MoneyOperation operation, int order) {
        System.out.printf("%d. %s%.02f%s %s %s\n",
                order,
                operation.getValue() > 0 ? "+" : "",
                operation.getValue(),
                this.currency,
                operation.getDate().format(DateTimeFormatter.ofPattern(this.dateFormat)),
                operation.getDescription()
        );
    }

    public void displayControls() {
        System.out.println("===== Wallet operations ========");
        System.out.println("1. Add expense");
        System.out.println("2. Add income");
        System.out.println("3. Show history");
        System.out.println("4. Show expenses");
        System.out.println("5. Show incomes");
        System.out.println("6. Exit");
        System.out.print("\nChoice: ");
    }

    @Override
    public String toString() {
        return "Wallet{" +
                "operations=" + operations +
                '}';
    }
}
