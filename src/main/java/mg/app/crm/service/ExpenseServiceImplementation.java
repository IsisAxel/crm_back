package mg.app.crm.service;

import java.lang.reflect.Type;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClient;

import com.google.gson.reflect.TypeToken;

import mg.app.crm.dto.api.ApiSuccessResult;
import mg.app.crm.dto.campaign.DeleteCampaignRequest;
import mg.app.crm.dto.campaign.DeleteCampaignResult;
import mg.app.crm.dto.campaign.UpdateCampaignRequest;
import mg.app.crm.dto.campaign.UpdateCampaignResult;
import mg.app.crm.dto.expense.BudgetAlertRateRequest;
import mg.app.crm.dto.expense.BudgetAlertRateResult;
import mg.app.crm.dto.expense.DeleteExpenseRequest;
import mg.app.crm.dto.expense.DeleteExpenseResult;
import mg.app.crm.dto.expense.ExpenseAmountByCampaignDto;
import mg.app.crm.dto.expense.ExpenseAmountByCampaignResult;
import mg.app.crm.dto.expense.ExpenseResultDto;
import mg.app.crm.dto.expense.UpdateExpenseRequest;
import mg.app.crm.dto.expense.UpdateExpenseResult;

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

    @Override
    public ApiSuccessResult<BudgetAlertRateResult> createBudgetAlert(BudgetAlertRateRequest request, String token) throws Exception 
    {
        Type type = TypeToken.getParameterized(ApiSuccessResult.class, BudgetAlertRateResult.class).getType();
        try {
            ResponseEntity<String> response = restClient.post()
                .uri("/BudgetAlertRate/CreateBudgetAlertRate")
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .body(request)
                .retrieve()
                .toEntity(new ParameterizedTypeReference<String>() {});
            
            ApiSuccessResult<BudgetAlertRateResult> result = ApiService.parseResponse(response.getBody(), type);
            return result;
        }catch(HttpClientErrorException ep) {
            String message = ep.getResponseBodyAsString();
            ApiSuccessResult<BudgetAlertRateResult> result = ApiService.parseResponse(message, type);
            return result;
        }
    }

    @Override
    public ApiSuccessResult<UpdateExpenseResult> update(UpdateExpenseRequest request, String token) throws Exception {
        Type type = TypeToken.getParameterized(ApiSuccessResult.class, UpdateExpenseResult.class).getType();
        try {
            ResponseEntity<String> response = restClient.post()
                .uri("/Expense/UpdateExpense")
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .body(request)
                .retrieve()
                .toEntity(new ParameterizedTypeReference<String>() {});
            ApiSuccessResult<UpdateExpenseResult> result = ApiService.parseResponse(response.getBody(), type);
            return result;
        }catch(HttpClientErrorException ep) {
            String message = ep.getResponseBodyAsString();
            ApiSuccessResult<UpdateExpenseResult> result = ApiService.parseResponse(message, type);
            return result;
        }
    }

    @Override
    public ApiSuccessResult<DeleteExpenseResult> delete(DeleteExpenseRequest request, String token) throws Exception {
        Type type = TypeToken.getParameterized(ApiSuccessResult.class, DeleteExpenseResult.class).getType();
        try {
            ResponseEntity<String> response = restClient.post()
                .uri("/Expense/DeleteExpense")
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .body(request)
                .retrieve()
                .toEntity(new ParameterizedTypeReference<String>() {});
            ApiSuccessResult<DeleteExpenseResult> result = ApiService.parseResponse(response.getBody(), type);
            return result;
        }catch(HttpClientErrorException ep) {
            String message = ep.getResponseBodyAsString();
            ApiSuccessResult<DeleteExpenseResult> result = ApiService.parseResponse(message, type);
            return result;
        }
    }

    @Override
    public ApiSuccessResult<ExpenseAmountByCampaignResult> getExpensesAmountByCampaign(String token) throws Exception 
    {
        Type type = TypeToken.getParameterized(ApiSuccessResult.class, ExpenseAmountByCampaignResult.class).getType();
        try {
            ResponseEntity<String> response = restClient.get()
                .uri("/Expense/GetExpenseAmountListByCampaign")
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .retrieve()
                .toEntity(new ParameterizedTypeReference<String>() {});
            
            ApiSuccessResult<ExpenseAmountByCampaignResult> result = ApiService.parseResponse(response.getBody(), type);
            return result;
        }catch(HttpClientErrorException ep) {
            String message = ep.getResponseBodyAsString();
            ApiSuccessResult<ExpenseAmountByCampaignResult> result = ApiService.parseResponse(message, type);
            return result;
        }
    }
    
}
