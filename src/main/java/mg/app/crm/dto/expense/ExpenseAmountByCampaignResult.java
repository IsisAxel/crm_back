package mg.app.crm.dto.expense;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExpenseAmountByCampaignResult 
{
    private List<ExpenseAmountByCampaignDto> data;    
}
