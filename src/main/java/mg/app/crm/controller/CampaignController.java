package mg.app.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mg.app.crm.dto.api.ApiSuccessResult;
import mg.app.crm.dto.campaign.CampaignResultDto;
import mg.app.crm.service.CampaignService;

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
}
