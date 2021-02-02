package wallet.models;

import java.time.LocalDateTime;

public class MoneyOperation {
    private double value;
    private String description;
    private LocalDateTime date;

    public MoneyOperation(double value) {
        this.value = value;
        this.description = "No description";
        this.date = LocalDateTime.now();
    }

    public MoneyOperation(double value, String description) {
        this.value = value;
        this.description = description;
        this.date = LocalDateTime.now();
    }

    public MoneyOperation(double operationValue, String description, LocalDateTime operationDate) {
        this.value = operationValue;
        this.description = description;
        this.date = operationDate;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "value=" + value +
                ", description='" + description + '\'' +
                ", date=" + date +
                '}';
    }
}
