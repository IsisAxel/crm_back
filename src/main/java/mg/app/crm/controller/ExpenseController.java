package mg.app.crm.controller;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mg.app.crm.dto.api.ApiSuccessResult;
import mg.app.crm.dto.expense.BudgetAlertRateRequest;
import mg.app.crm.dto.expense.BudgetAlertRateResult;
import mg.app.crm.dto.expense.DeleteExpenseRequest;
import mg.app.crm.dto.expense.DeleteExpenseResult;
import mg.app.crm.dto.expense.ExpenseResultDto;
import mg.app.crm.dto.expense.UpdateExpenseRequest;
import mg.app.crm.dto.expense.UpdateExpenseResult;
import mg.app.crm.service.ExpenseService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


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

    @PostMapping("/createBudgetAlert")
    public ResponseEntity<BudgetAlertRateResult> createBudgetAlertRate(@RequestHeader("Authorization") String token , @RequestBody BudgetAlertRateRequest request) throws Exception
    {
        token = token.replace("Bearer ", "");

        String inputDate = request.getAlertDate();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.parse(inputDate, formatter);
        OffsetDateTime offsetDateTime = localDateTime.atOffset(ZoneOffset.UTC);
        String formattedDate = offsetDateTime.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME);
        request.setAlertDate(formattedDate);

        ApiSuccessResult<BudgetAlertRateResult> result = expenseService.createBudgetAlert(request, token);
        return ResponseEntity.ok(result.getContent());
    }
    
    @PostMapping("/update")
    public ResponseEntity<UpdateExpenseResult> updateExpense(@RequestBody UpdateExpenseRequest request ,@RequestHeader("Authorization") String token) throws Exception
    {        
        token = token.replace("Bearer ", "");
        ApiSuccessResult<UpdateExpenseResult> result = expenseService.update(request,token);
        return ResponseEntity.ok(result.getContent());
    }  
    
    @PostMapping("/delete")
    public ResponseEntity<DeleteExpenseResult> deleteExpense(@RequestBody DeleteExpenseRequest request ,@RequestHeader("Authorization") String token) throws Exception
    {        
        token = token.replace("Bearer ", "");
        ApiSuccessResult<DeleteExpenseResult> result = expenseService.delete(request,token);
        return ResponseEntity.ok(result.getContent());
    }  
}
