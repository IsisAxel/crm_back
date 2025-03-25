package mg.app.crm.dto.budget;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BudgetByCampaignResult 
{
    private List<BudgetByCampaignDto> data;    
}
