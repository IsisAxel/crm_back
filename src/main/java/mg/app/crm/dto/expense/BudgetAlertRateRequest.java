package mg.app.crm.dto.expense;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BudgetAlertRateRequest 
{
    private double rate;
    private String alertDate;
    private String createdById;  
}
