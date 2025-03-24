package mg.app.crm.dto.expense;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateExpenseRequest 
{
    private String id;
    private String title;
    private String description;
    private String expenseDate;
    private String status;
    private Double amount;
    private String campaignId;
    private String updatedById;
}
