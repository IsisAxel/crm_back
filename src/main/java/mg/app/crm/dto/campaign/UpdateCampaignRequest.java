package mg.app.crm.dto.campaign;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCampaignRequest 
{ 
    private String id;
    private String title;
    private String description;
    private double targetRevenueAmount;
    private String campaignDateStart;
    private String campaignDateFinish;
    private String salesTeamId;
    private String status;
    private String updatedById;
}
