package mg.app.crm.service;

import java.lang.reflect.Type;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClient;

import com.google.gson.reflect.TypeToken;

import mg.app.crm.dto.api.ApiSuccessResult;
import mg.app.crm.dto.campaign.CampaignResultDto;

@Service
public class CampaignServiceImplementation implements CampaignService 
{
    private final RestClient restClient;

    public CampaignServiceImplementation(RestClient.Builder restClientBuilder) {
        restClient = restClientBuilder.baseUrl("http://localhost:5000/api").build();
    }

    public ApiSuccessResult<CampaignResultDto> getCampaigns(String token) throws Exception
    {
        Type type = TypeToken.getParameterized(ApiSuccessResult.class, CampaignResultDto.class).getType();
        try {
            ResponseEntity<String> response = restClient.get()
                .uri("/Campaign/GetCampaignList")
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .retrieve()
                .toEntity(new ParameterizedTypeReference<String>() {});
            
            ApiSuccessResult<CampaignResultDto> result = ApiService.parseResponse(response.getBody(), type);
            return result;
        }catch(HttpClientErrorException ep) {
            String message = ep.getResponseBodyAsString();
            ApiSuccessResult<CampaignResultDto> result = ApiService.parseResponse(message, type);
            return result;
        }
    }
}
