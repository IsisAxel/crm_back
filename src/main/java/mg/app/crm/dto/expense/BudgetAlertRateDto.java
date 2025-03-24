package mg.app.crm.dto.expense;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BudgetAlertRateDto 
{
    private String number;
    private double rate;
    private String date;
}