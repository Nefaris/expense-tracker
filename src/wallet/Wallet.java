package wallet;

import utils.UserInput;
import wallet.models.MoneyOperation;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    public void createSingleExpense() {
        System.out.println("\n===== Add new expense =====");
        System.out.print("Expense value: ");
        double expenseValue = UserInput.getScanner().nextDouble();
        UserInput.getScanner().nextLine();

        System.out.print("Description (leave empty to skip): ");
        String description = UserInput.getScanner().nextLine();

        this.addOperation(new MoneyOperation(-expenseValue, description));
    }

    public void createSingleIncome() {
        System.out.println("\n===== Add new income =====");
        System.out.print("Income value: ");
        double expenseValue = UserInput.getScanner().nextDouble();
        UserInput.getScanner().nextLine();

        System.out.print("Description (leave empty to skip): ");
        String description = UserInput.getScanner().nextLine();

        this.addOperation(new MoneyOperation(expenseValue, description));
    }

    public void displayAllExpenses() {
        System.out.println("\n===== All your expenses =====");
        if (operations.size() > 0) {
            this.displayOperations(this.operations.stream().filter(this::isExpense).collect(Collectors.toList()));
        } else {
            System.out.println("You have no expenses, lucky you ;)");
        }
        System.out.println("===============================");
        System.out.println("Press enter to go back...");
        UserInput.waitForEnter();
    }

    public void displayAllIncomes() {
        System.out.println("\n===== All your incomes =====");
        if (operations.size() > 0) {
            this.displayOperations(this.operations.stream().filter(this::isIncome).collect(Collectors.toList()));
        } else {
            System.out.println("You have no incomes :(");
        }
        System.out.println("===============================");
        System.out.println("Press enter to go back...");
        UserInput.waitForEnter();
    }

    public void displayFullHistory() {
        System.out.println("\n===== Operations history =====");
        if (this.operations.size() > 0) {
            this.displayHistoryOperations(this.operations.size());
        } else {
            System.out.println("Operations history is empty");
        }
        System.out.println("==============================\n");
        System.out.println("Press enter to go back...");
        UserInput.waitForEnter();
    }

    public void displayWalletInfo() {
        System.out.println("===== Your wallet =====");
        System.out.printf("Balance: %.02f%s\n", this.balance, this.currency);
        System.out.printf("Expenses: %.02f%s\n", this.getExpensesValue(), this.currency);
        System.out.printf("Incomes: %.02f%s\n", this.getIncomesValue(), this.currency);
        System.out.println("=======================\n");
    }

    public void displayNewestOperations(int count) {
        System.out.println("===== Your last operations =====");
        if (this.operations.size() > 0) {
            this.displayHistoryOperations(count);
        } else {
            System.out.println("No operations");
        }
        System.out.println("================================\n");
    }

    public void displayHistoryOperations(int count) {
        this.displayOperations(this.operations.subList(0, Math.min(count, this.operations.size())));
    }

    public void displayMoneyOperation(MoneyOperation operation, int order) {
        System.out.printf("%d. %s%.02f%s %s %s\n",
                order,
                operation.getValue() > 0 ? "+" : "",
                operation.getValue(),
                this.currency,
                operation.getDate().format(DateTimeFormatter.ofPattern(this.dateFormat)),
                operation.getDescription()
        );
    }

    public void displayWalletActions() {
        System.out.println("===== Wallet operations ========");
        System.out.println("1. Add expense");
        System.out.println("2. Add income");
        System.out.println("3. Show history");
        System.out.println("4. Show expenses");
        System.out.println("5. Show incomes");
        System.out.println("6. Exit");
        System.out.print("\nChoice: ");
    }

    private void displayOperations(List<MoneyOperation> operations) {
        int i = 0;
        for (MoneyOperation operation : operations) {
            this.displayMoneyOperation(operation, ++i);
        }
    }

    private void addOperation(MoneyOperation moneyOperation) {
        this.operations.add(moneyOperation);
        this.balance += moneyOperation.getValue();
    }

    private boolean isIncome(MoneyOperation operation) {
        return operation.getValue() > 0;
    }

    private boolean isExpense(MoneyOperation operation) {
        return operation.getValue() < 0;
    }

    private double getExpensesValue() {
        return this.operations.stream().filter(this::isExpense).mapToDouble(MoneyOperation::getValue).sum();
    }

    private double getIncomesValue() {
        return this.operations.stream().filter(this::isIncome).mapToDouble(MoneyOperation::getValue).sum();
    }

    @Override
    public String toString() {
        return "Wallet{" +
                "operations=" + operations +
                '}';
    }
}
