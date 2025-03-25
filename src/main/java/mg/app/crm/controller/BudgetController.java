package mg.app.crm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mg.app.crm.dto.api.ApiSuccessResult;
import mg.app.crm.dto.budget.BudgetByCampaignResult;
import mg.app.crm.dto.budget.BudgetResultDto;
import mg.app.crm.dto.budget.DeleteBudgetRequest;
import mg.app.crm.dto.budget.DeleteBudgetResult;
import mg.app.crm.dto.budget.UpdateBudgetRequest;
import mg.app.crm.dto.budget.UpdateBudgetResult;
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

    @GetMapping("/budgetByCampaign")
    public ResponseEntity<BudgetByCampaignResult> getBudgetByCampaign(@RequestHeader("Authorization") String token) throws Exception
    {
        token = token.replace("Bearer ", "");
        ApiSuccessResult<BudgetByCampaignResult> result = budgetService.getBudgetByCampaign(token);
        return ResponseEntity.ok(result.getContent());
    }

    @PostMapping("/update")
    public ResponseEntity<UpdateBudgetResult> updateBudget(@RequestBody UpdateBudgetRequest request ,@RequestHeader("Authorization") String token) throws Exception
    {        
        token = token.replace("Bearer ", "");
        ApiSuccessResult<UpdateBudgetResult> result = budgetService.update(request,token);
        return ResponseEntity.ok(result.getContent());
    }  
    
    @PostMapping("/delete")
    public ResponseEntity<DeleteBudgetResult> deleteBudget(@RequestBody DeleteBudgetRequest request ,@RequestHeader("Authorization") String token) throws Exception
    {        
        token = token.replace("Bearer ", "");
        ApiSuccessResult<DeleteBudgetResult> result = budgetService.delete(request,token);
        return ResponseEntity.ok(result.getContent());
    } 
}
