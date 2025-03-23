package mg.app.crm.service;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClient;

import mg.app.crm.dto.api.ApiErrorResult;
import mg.app.crm.dto.api.ApiSuccessResult;
import mg.app.crm.dto.authentification.LoginRequest;
import mg.app.crm.dto.authentification.LoginResult;
import mg.app.crm.exception.ApiErrorException;

@Service
public class AuthentificationServiceImplementation implements AuthentificationService
{
    private final RestClient restClient;

    public AuthentificationServiceImplementation(RestClient.Builder restClientBuilder) {
        restClient = restClientBuilder.baseUrl("http://localhost:5000/api").build();
    }

    @Override
    public LoginResult login(LoginRequest request) throws Exception {
        try {
            ResponseEntity<ApiSuccessResult<LoginResult>> successResponse = restClient.post()
                    .uri("/Security/Login")
                    .header("Content-Type", "application/json")
                    .body(request)
                    .retrieve()
                    .toEntity(new ParameterizedTypeReference<ApiSuccessResult<LoginResult>>() {});

            if (successResponse.getStatusCode().is2xxSuccessful() && successResponse.getBody() != null) {
                return successResponse.getBody().getContent();
            }
        } catch (HttpClientErrorException e) {
            // Si une erreur HTTP est renvoyée, désérialiser la réponse en ApiErrorResult
            if (e.getStatusCode().is4xxClientError() || e.getStatusCode().is5xxServerError()) {
                ApiErrorResult errorResult = e.getResponseBodyAs(ApiErrorResult.class);
                throw new ApiErrorException(errorResult);
            }
        }

        throw new RuntimeException("Internal error!");
    }
}