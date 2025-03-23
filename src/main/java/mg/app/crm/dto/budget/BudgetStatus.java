package mg.app.crm.dto.budget;

public enum BudgetStatus {
    DRAFT("Draft"),
    CANCELLED("Cancelled"),
    CONFIRMED("Confirmed"),
    ARCHIVED("Archived");

    private final String description;

    BudgetStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}