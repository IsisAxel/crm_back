package mg.app.crm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import mg.app.crm.dto.api.ApiSuccessResult;
import mg.app.crm.dto.dashboard.CRMDashboardResult;
import mg.app.crm.service.DashboardService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/dashboard")
public class DashboardController 
{
    @Autowired
    private DashboardService dashboardService;    

    @GetMapping("/getCRMData")
    public ResponseEntity<CRMDashboardResult> getDashboardData(@RequestHeader("Authorization") String token) throws Exception{
        token = token.replace("Bearer ", "");
        ApiSuccessResult<CRMDashboardResult> result = dashboardService.getDashboardData(token);
        return ResponseEntity.ok(result.getContent());
    }
    
}
