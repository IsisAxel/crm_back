package mg.app.crm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mg.app.crm.dto.api.ApiSuccessResult;
import mg.app.crm.dto.authentification.LoginRequest;
import mg.app.crm.dto.authentification.LoginResult;
import mg.app.crm.dto.authentification.LogoutRequest;
import mg.app.crm.dto.authentification.LogoutResult;
import mg.app.crm.service.AuthentificationService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/authentification")
public class AuthentificationController 
{
    @Autowired
    private AuthentificationService authentificationService;

    @PostMapping("/login")
    public ResponseEntity<LoginResult> login(@RequestBody LoginRequest request) throws Exception 
    {
        ApiSuccessResult<LoginResult> result = authentificationService.login(request);
        LoginResult loginResult = result.getContent();
        return ResponseEntity.ok(loginResult);
    }

    @PostMapping("/logout")
    public ResponseEntity<LogoutResult> logout(@RequestBody LogoutRequest request) throws Exception 
    {
        ApiSuccessResult<LogoutResult> result = authentificationService.logout(request);
        LogoutResult logoutResult = result.getContent();
        return ResponseEntity.ok(logoutResult);
    }
}