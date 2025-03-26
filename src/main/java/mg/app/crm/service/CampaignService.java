package mg.app.crm.service;


import mg.app.crm.dto.api.ApiSuccessResult;
import mg.app.crm.dto.campaign.CampaignResultDto;
import mg.app.crm.dto.campaign.CampaignRevenueSummaryResult;
import mg.app.crm.dto.campaign.DeleteCampaignRequest;
import mg.app.crm.dto.campaign.DeleteCampaignResult;
import mg.app.crm.dto.campaign.UpdateCampaignRequest;
import mg.app.crm.dto.campaign.UpdateCampaignResult;

public interface CampaignService 
{
    public ApiSuccessResult<CampaignResultDto> getCampaigns(String token) throws Exception;
    public ApiSuccessResult<UpdateCampaignResult> update(UpdateCampaignRequest request, String token) throws Exception;
    public ApiSuccessResult<DeleteCampaignResult> delete(DeleteCampaignRequest request, String token) throws Exception;
    public ApiSuccessResult<CampaignRevenueSummaryResult> getCampaignRevenueSummary(String token) throws Exception;
    public ApiSuccessResult<String> sendFileName(String token , String fileName) throws Exception;
}
