package mg.app.crm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mg.app.crm.dto.authentification.LoginRequest;
import mg.app.crm.dto.authentification.LoginResult;
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
    public ResponseEntity<LoginResult> postMethodName(@RequestBody LoginRequest request) throws Exception 
    {
        LoginResult result = authentificationService.login(request);
        return ResponseEntity.ok(result);
    }
}