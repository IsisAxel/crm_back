package mg.app.crm.service;

import mg.app.crm.dto.authentification.LoginRequest;
import mg.app.crm.dto.authentification.LoginResult;

public interface AuthentificationService 
{
    public LoginResult login(LoginRequest request) throws Exception;
}
