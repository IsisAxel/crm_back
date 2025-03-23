package mg.app.crm.service;

import java.lang.reflect.Type;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClient;

import com.google.gson.reflect.TypeToken;

import mg.app.crm.dto.api.ApiSuccessResult;
import mg.app.crm.dto.dashboard.CRMDashboardResult;

@Service
public class DashboardServiceImplementation implements DashboardService 
{
    private final RestClient restClient;

    public DashboardServiceImplementation(RestClient.Builder restClientBuilder) {
        restClient = restClientBuilder.baseUrl("http://localhost:5000/api").build();
    }

    @Override
    public ApiSuccessResult<CRMDashboardResult> getDashboardData(String token) throws Exception {
        try {
            ResponseEntity<String> response = restClient.get()
                .uri("/Dashboard/GetCRMDashboard")
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .retrieve()
                .toEntity(new ParameterizedTypeReference<String>() {});
            Type type = TypeToken.getParameterized(ApiSuccessResult.class, CRMDashboardResult.class).getType();            
            ApiSuccessResult<CRMDashboardResult> result = ApiService.parseResponse(response.getBody(), type);
            return result;
        }catch(HttpClientErrorException ep) {
            String message = ep.getResponseBodyAsString();
            ApiSuccessResult<CRMDashboardResult> result = ApiService.parseResponse(message, CRMDashboardResult.class);
            return result;
        }
    }
}
