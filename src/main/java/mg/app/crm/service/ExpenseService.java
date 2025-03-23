package mg.app.crm.service;

import mg.app.crm.dto.api.ApiSuccessResult;
import mg.app.crm.dto.expense.ExpenseResultDto;

public interface ExpenseService 
{
    public ApiSuccessResult<ExpenseResultDto> getExpenses(String token) throws Exception;
}
