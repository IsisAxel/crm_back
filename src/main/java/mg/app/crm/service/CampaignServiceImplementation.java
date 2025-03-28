package mg.app.crm.service;

import java.lang.reflect.Type;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClient;

import com.google.gson.reflect.TypeToken;

import mg.app.crm.dto.api.ApiSuccessResult;
import mg.app.crm.dto.campaign.CampaignFileDto;
import mg.app.crm.dto.campaign.CampaignResultDto;
import mg.app.crm.dto.campaign.CampaignRevenueSummaryResult;
import mg.app.crm.dto.campaign.DeleteCampaignRequest;
import mg.app.crm.dto.campaign.DeleteCampaignResult;
import mg.app.crm.dto.campaign.UpdateCampaignRequest;
import mg.app.crm.dto.campaign.UpdateCampaignResult;

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

    @Override
    public ApiSuccessResult<UpdateCampaignResult> update(UpdateCampaignRequest request, String token) throws Exception {
        Type type = TypeToken.getParameterized(ApiSuccessResult.class, UpdateCampaignResult.class).getType();
        try {
            ResponseEntity<String> response = restClient.post()
                .uri("/Campaign/UpdateCampaign")
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .body(request)
                .retrieve()
                .toEntity(new ParameterizedTypeReference<String>() {});
            ApiSuccessResult<UpdateCampaignResult> result = ApiService.parseResponse(response.getBody(), type);
            return result;
        }catch(HttpClientErrorException ep) {
            String message = ep.getResponseBodyAsString();
            ApiSuccessResult<UpdateCampaignResult> result = ApiService.parseResponse(message, type);
            return result;
        }
    }

    @Override
    public ApiSuccessResult<DeleteCampaignResult> delete(DeleteCampaignRequest request, String token) throws Exception {
        Type type = TypeToken.getParameterized(ApiSuccessResult.class, DeleteCampaignResult.class).getType();
        try {
            ResponseEntity<String> response = restClient.post()
                .uri("/Campaign/DeleteCampaign")
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .body(request)
                .retrieve()
                .toEntity(new ParameterizedTypeReference<String>() {});
            ApiSuccessResult<DeleteCampaignResult> result = ApiService.parseResponse(response.getBody(), type);
            return result;
        }catch(HttpClientErrorException ep) {
            String message = ep.getResponseBodyAsString();
            ApiSuccessResult<DeleteCampaignResult> result = ApiService.parseResponse(message, type);
            return result;
        }
    }

    @Override
    public ApiSuccessResult<CampaignRevenueSummaryResult> getCampaignRevenueSummary(String token) throws Exception {
        Type type = TypeToken.getParameterized(ApiSuccessResult.class, CampaignRevenueSummaryResult.class).getType();
        try {
            ResponseEntity<String> response = restClient.get()
                .uri("/Campaign/GetCampaignRevenueSummary")
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .retrieve()
                .toEntity(new ParameterizedTypeReference<String>() {});
            ApiSuccessResult<CampaignRevenueSummaryResult> result = ApiService.parseResponse(response.getBody(), type);
            return result;
        }catch(HttpClientErrorException ep) {
            String message = ep.getResponseBodyAsString();
            ApiSuccessResult<CampaignRevenueSummaryResult> result = ApiService.parseResponse(message, type);
            return result;
        }
    }

    @Override
    public ApiSuccessResult<String> sendFileName(String token , String fileName) throws Exception {
        try {
            System.out.println(fileName);
            ResponseEntity<String> response = restClient.post()
                .uri("/Campaign/SendFileName")
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .body(new CampaignFileDto(fileName))
                .retrieve()
                .toEntity(new ParameterizedTypeReference<String>() {});
            ApiSuccessResult<String> result = new ApiSuccessResult<String>(200, "Reussi", null);
            return result;
        }catch(HttpClientErrorException ep) {
            String message = ep.getResponseBodyAsString();
            // ApiSuccessResult<String> result = new ApiSuccessResult<String>(ep.getStatusCode(), message, null);
            return null;
            // return result;
        }
    }
}
