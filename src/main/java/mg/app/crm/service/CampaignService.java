package mg.app.crm.service;


import mg.app.crm.dto.api.ApiSuccessResult;
import mg.app.crm.dto.campaign.CampaignResultDto;

public interface CampaignService 
{
    public ApiSuccessResult<CampaignResultDto> getCampaigns(String token) throws Exception;
}
