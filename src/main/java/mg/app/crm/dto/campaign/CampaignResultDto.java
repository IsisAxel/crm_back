package mg.app.crm.dto.campaign;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CampaignResultDto 
{
    private List<CampaignDto> data;    
}
