package mg.app.crm.dto.budget;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BudgetDto 
{
    private String id;
    private String number;
    private String title;
    private String description;
    private String budgetDate;
    private BudgetStatus status;
    private String statusName;
    private Double amount;
    private String campaignId;
    private String campaignName;
    private String createdAtUtc;
}