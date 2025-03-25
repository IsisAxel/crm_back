package mg.app.crm.service;

import java.lang.reflect.Type;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClient;

import com.google.gson.reflect.TypeToken;

import mg.app.crm.dto.api.ApiSuccessResult;
import mg.app.crm.dto.budget.BudgetByCampaignResult;
import mg.app.crm.dto.budget.BudgetResultDto;
import mg.app.crm.dto.budget.DeleteBudgetRequest;
import mg.app.crm.dto.budget.DeleteBudgetResult;
import mg.app.crm.dto.budget.UpdateBudgetRequest;
import mg.app.crm.dto.budget.UpdateBudgetResult;
import mg.app.crm.dto.campaign.DeleteCampaignRequest;
import mg.app.crm.dto.campaign.DeleteCampaignResult;
import mg.app.crm.dto.campaign.UpdateCampaignRequest;
import mg.app.crm.dto.campaign.UpdateCampaignResult;

@Service
public class BudgetServiceImplementation implements BudgetService
{
    private final RestClient restClient;

    public BudgetServiceImplementation(RestClient.Builder restClientBuilder) {
        restClient = restClientBuilder.baseUrl("http://localhost:5000/api").build();
    }

    @Override
    public ApiSuccessResult<BudgetResultDto> getBudgets(String token) throws Exception 
    {
        Type type = TypeToken.getParameterized(ApiSuccessResult.class, BudgetResultDto.class).getType();
        try {
            ResponseEntity<String> response = restClient.get()
                .uri("/Budget/GetBudgetList")
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .retrieve()
                .toEntity(new ParameterizedTypeReference<String>() {});
            
            ApiSuccessResult<BudgetResultDto> result = ApiService.parseResponse(response.getBody(), type);
            return result;
        }catch(HttpClientErrorException ep) {
            String message = ep.getResponseBodyAsString();
            ApiSuccessResult<BudgetResultDto> result = ApiService.parseResponse(message, type);
            return result;
        }
    }

        @Override
    public ApiSuccessResult<UpdateBudgetResult> update(UpdateBudgetRequest request, String token) throws Exception {
        Type type = TypeToken.getParameterized(ApiSuccessResult.class, UpdateBudgetResult.class).getType();
        try {
            ResponseEntity<String> response = restClient.post()
                .uri("/Budget/UpdateBudget")
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .body(request)
                .retrieve()
                .toEntity(new ParameterizedTypeReference<String>() {});
            ApiSuccessResult<UpdateBudgetResult> result = ApiService.parseResponse(response.getBody(), type);
            return result;
        }catch(HttpClientErrorException ep) {
            String message = ep.getResponseBodyAsString();
            ApiSuccessResult<UpdateBudgetResult> result = ApiService.parseResponse(message, type);
            return result;
        }
    }

    @Override
    public ApiSuccessResult<DeleteBudgetResult> delete(DeleteBudgetRequest request, String token) throws Exception {
        Type type = TypeToken.getParameterized(ApiSuccessResult.class, DeleteBudgetResult.class).getType();
        try {
            ResponseEntity<String> response = restClient.post()
                .uri("/Budget/DeleteBudget")
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .body(request)
                .retrieve()
                .toEntity(new ParameterizedTypeReference<String>() {});
            ApiSuccessResult<DeleteBudgetResult> result = ApiService.parseResponse(response.getBody(), type);
            return result;
        }catch(HttpClientErrorException ep) {
            String message = ep.getResponseBodyAsString();
            ApiSuccessResult<DeleteBudgetResult> result = ApiService.parseResponse(message, type);
            return result;
        }
    }

    @Override
    public ApiSuccessResult<BudgetByCampaignResult> getBudgetByCampaign(String token) throws Exception 
    {
        Type type = TypeToken.getParameterized(ApiSuccessResult.class, BudgetByCampaignResult.class).getType();
        try {
            ResponseEntity<String> response = restClient.get()
                .uri("/Budget/GetBudgetByCampaign")
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .retrieve()
                .toEntity(new ParameterizedTypeReference<String>() {});
            
            ApiSuccessResult<BudgetByCampaignResult> result = ApiService.parseResponse(response.getBody(), type);
            return result;
        }catch(HttpClientErrorException ep) {
            String message = ep.getResponseBodyAsString();
            ApiSuccessResult<BudgetByCampaignResult> result = ApiService.parseResponse(message, type);
            return result;
        }
    }
}
