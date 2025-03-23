package mg.app.crm.dto.expense;

public enum ExpenseStatus {
    DRAFT("Draft"),
    CANCELLED("Cancelled"),
    CONFIRMED("Confirmed"),
    ARCHIVED("Archived");

    private final String description;

    ExpenseStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}