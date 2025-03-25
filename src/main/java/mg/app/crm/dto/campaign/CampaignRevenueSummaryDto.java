package mg.app.crm.dto.campaign;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CampaignRevenueSummaryDto 
{ 
    private String campaignStatus;
    private String totalRevenueTarget;    
}
