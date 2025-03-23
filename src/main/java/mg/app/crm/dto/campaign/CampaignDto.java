package mg.app.crm.dto.campaign;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CampaignDto {
    private String id;
    private String number;
    private String title;
    private String description;
    private double targetRevenueAmount;
    private String campaignDateStart;
    private String campaignDateFinish;
    private CampaignStatus status;
    private String statusName;
    private String salesTeamId;
    private String salesTeamName;
    private String createdAtUtc;
}
