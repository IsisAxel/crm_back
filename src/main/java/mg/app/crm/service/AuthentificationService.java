package mg.app.crm.service;

import mg.app.crm.dto.api.ApiSuccessResult;
import mg.app.crm.dto.authentification.LoginRequest;
import mg.app.crm.dto.authentification.LoginResult;
import mg.app.crm.dto.authentification.LogoutRequest;
import mg.app.crm.dto.authentification.LogoutResult;

public interface AuthentificationService 
{
    public ApiSuccessResult<LoginResult> login(LoginRequest request) throws Exception;
    public ApiSuccessResult<LogoutResult> logout(LogoutRequest request) throws Exception;
}
