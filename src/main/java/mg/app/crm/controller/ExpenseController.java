package mg.app.crm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mg.app.crm.dto.api.ApiSuccessResult;
import mg.app.crm.dto.expense.ExpenseResultDto;
import mg.app.crm.service.ExpenseService;

@RestController
@RequestMapping("/expense")
public class ExpenseController 
{
    @Autowired
    private ExpenseService expenseService;

    @GetMapping("/all")
    public ResponseEntity<ExpenseResultDto> getExpenses(@RequestHeader("Authorization") String token) throws Exception
    {
        token = token.replace("Bearer ", "");
        ApiSuccessResult<ExpenseResultDto> result = expenseService.getExpenses(token);
        return ResponseEntity.ok(result.getContent());
    }
}
