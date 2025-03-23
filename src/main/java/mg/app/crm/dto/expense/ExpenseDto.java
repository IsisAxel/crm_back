package mg.app.crm.dto.expense;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExpenseDto 
{
    private String id;
    private String number;
    private String title;
    private String description;
    private String expenseDate;
    private ExpenseStatus status;
    private String statusName;
    private Double amount;
    private String campaignId;
    private String campaignName;
    private String createdAtUtc;    
}
