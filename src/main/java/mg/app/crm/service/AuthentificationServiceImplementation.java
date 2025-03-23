package mg.app.crm.service;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

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

        ApiSuccessResult<LoginResult> successResult = ApiService.parseResponse(response.getBody(), LoginResult.class);
        return successResult;
    }

    @Override
    public ApiSuccessResult<LogoutResult> logout(LogoutRequest request) throws Exception {
        ResponseEntity<String> response = restClient.post()
                .uri("/Security/Logout")
                .header("Content-Type", "application/json" , "Authorization", "Bearer " + request.getToken())
                .body(request)
                .retrieve()
                .toEntity(new ParameterizedTypeReference<String>() {});

        ApiSuccessResult<LogoutResult> successResult = ApiService.parseResponse(response.getBody(), LogoutResult.class);
        return successResult;
    }
}