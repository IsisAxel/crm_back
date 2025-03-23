package mg.app.crm.service;

import java.lang.reflect.Type;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClient;

import com.google.gson.reflect.TypeToken;

import mg.app.crm.dto.api.ApiSuccessResult;
import mg.app.crm.dto.expense.ExpenseResultDto;

@Service
public class ExpenseServiceImplementation implements ExpenseService
{
    private final RestClient restClient;

    public ExpenseServiceImplementation(RestClient.Builder restClientBuilder) {
        restClient = restClientBuilder.baseUrl("http://localhost:5000/api").build();
    }

    @Override
    public ApiSuccessResult<ExpenseResultDto> getExpenses(String token) throws Exception 
    {
        Type type = TypeToken.getParameterized(ApiSuccessResult.class, ExpenseResultDto.class).getType();
        try {
            ResponseEntity<String> response = restClient.get()
                .uri("/Expense/GetExpenseList")
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .retrieve()
                .toEntity(new ParameterizedTypeReference<String>() {});
            
            ApiSuccessResult<ExpenseResultDto> result = ApiService.parseResponse(response.getBody(), type);
            return result;
        }catch(HttpClientErrorException ep) {
            String message = ep.getResponseBodyAsString();
            ApiSuccessResult<ExpenseResultDto> result = ApiService.parseResponse(message, type);
            return result;
        }
    }
    
}
