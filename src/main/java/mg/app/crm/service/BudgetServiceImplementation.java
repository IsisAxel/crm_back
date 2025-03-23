package mg.app.crm.service;

import java.lang.reflect.Type;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClient;

import com.google.gson.reflect.TypeToken;

import mg.app.crm.dto.api.ApiSuccessResult;
import mg.app.crm.dto.budget.BudgetResultDto;

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
}
