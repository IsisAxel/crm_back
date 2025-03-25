package mg.app.crm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mg.app.crm.dto.api.ApiSuccessResult;
import mg.app.crm.dto.campaign.CampaignResultDto;
import mg.app.crm.dto.campaign.CampaignRevenueSummaryDto;
import mg.app.crm.dto.campaign.CampaignRevenueSummaryResult;
import mg.app.crm.dto.campaign.DeleteCampaignRequest;
import mg.app.crm.dto.campaign.DeleteCampaignResult;
import mg.app.crm.dto.campaign.UpdateCampaignRequest;
import mg.app.crm.dto.campaign.UpdateCampaignResult;
import mg.app.crm.service.CampaignService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/campaign")
public class CampaignController 
{
    @Autowired
    private CampaignService campaignService;  
    
    @GetMapping("/all")
    public ResponseEntity<CampaignResultDto> getCampaigns(@RequestHeader("Authorization") String token) throws Exception
    {
        token = token.replace("Bearer ", "");
        ApiSuccessResult<CampaignResultDto> result = campaignService.getCampaigns(token);
        return ResponseEntity.ok(result.getContent());
    }

    @PostMapping("/update")
    public ResponseEntity<UpdateCampaignResult> updateCampaign(@RequestBody UpdateCampaignRequest request ,@RequestHeader("Authorization") String token) throws Exception
    {        
        token = token.replace("Bearer ", "");
        ApiSuccessResult<UpdateCampaignResult> result = campaignService.update(request,token);
        return ResponseEntity.ok(result.getContent());
    }  
    
    @PostMapping("/delete")
    public ResponseEntity<DeleteCampaignResult> deleteCampaign(@RequestBody DeleteCampaignRequest request ,@RequestHeader("Authorization") String token) throws Exception
    {        
        token = token.replace("Bearer ", "");
        ApiSuccessResult<DeleteCampaignResult> result = campaignService.delete(request,token);
        return ResponseEntity.ok(result.getContent());
    }  

    @GetMapping("/revenueSummary")
    public ResponseEntity<CampaignRevenueSummaryResult> getCampaignsRevenueSummary(@RequestHeader("Authorization") String token) throws Exception
    {
        token = token.replace("Bearer ", "");
        ApiSuccessResult<CampaignRevenueSummaryResult> result = campaignService.getCampaignRevenueSummary(token);
        return ResponseEntity.ok(result.getContent());
    }
}
