package mg.app.crm.dto.budget;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BudgetByCampaignDto 
{
    private double totalAmount;
    private String campaignId;
    private String campaignName;
}
