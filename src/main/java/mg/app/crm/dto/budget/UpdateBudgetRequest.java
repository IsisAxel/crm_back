package mg.app.crm.dto.budget;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateBudgetRequest 
{
    private String id;
    private String title;
    private String description;
    private String budgetDate;
    private String status;
    private Double amount;
    private String campaignId;
    private String updatedById;    
}
