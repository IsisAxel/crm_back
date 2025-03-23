package mg.app.crm.service;

import java.lang.reflect.Type;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.google.gson.reflect.TypeToken;

import mg.app.crm.dto.api.ApiSuccessResult;
import mg.app.crm.dto.authentification.LoginRequest;
import mg.app.crm.dto.authentification.LoginResult;
import mg.app.crm.dto.authentification.LogoutRequest;
import mg.app.crm.dto.authentification.LogoutResult;

@Service
public class AuthentificationServiceImplementation implements AuthentificationService
{
    private final RestClient restClient;

    public AuthentificationServiceImplementation(RestClient.Builder restClientBuilder) {
        restClient = restClientBuilder.baseUrl("http://localhost:5000/api").build();
    }

    @Override
    public ApiSuccessResult<LoginResult> login(LoginRequest request) throws Exception {
        ResponseEntity<String> response = restClient.post()
                .uri("/Security/Login")
                .header("Content-Type", "application/json")
                .body(request)
                .retrieve()
                .toEntity(new ParameterizedTypeReference<String>() {});
        
        Type type = TypeToken.getParameterized(ApiSuccessResult.class, LoginResult.class).getType();
        ApiSuccessResult<LoginResult> successResult = ApiService.parseResponse(response.getBody(), type);
        return successResult;
    }

    @Override
    public ApiSuccessResult<LogoutResult> logout(LogoutRequest request) throws Exception {
        ResponseEntity<String> response = restClient.post()
                .uri("/Security/Logout")
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + request.getToken())
                .body(request)
                .retrieve()
                .toEntity(new ParameterizedTypeReference<String>() {});
                
        Type type = TypeToken.getParameterized(ApiSuccessResult.class, LogoutResult.class).getType();
        ApiSuccessResult<LogoutResult> successResult = ApiService.parseResponse(response.getBody(), type);
        return successResult;
    }
}