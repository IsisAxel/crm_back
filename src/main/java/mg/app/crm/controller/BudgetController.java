package mg.app.crm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mg.app.crm.dto.api.ApiSuccessResult;
import mg.app.crm.dto.budget.BudgetResultDto;
import mg.app.crm.service.BudgetService;

@RestController
@RequestMapping("/budget")
public class BudgetController 
{
    @Autowired
    private BudgetService budgetService;  
    
    @GetMapping("/all")
    public ResponseEntity<BudgetResultDto> getBudgets(@RequestHeader("Authorization") String token) throws Exception
    {
        token = token.replace("Bearer ", "");
        ApiSuccessResult<BudgetResultDto> result = budgetService.getBudgets(token);
        return ResponseEntity.ok(result.getContent());
    }
}
