package mg.app.crm.service;

import mg.app.crm.dto.api.ApiSuccessResult;
import mg.app.crm.dto.budget.BudgetResultDto;

public interface BudgetService 
{
    public ApiSuccessResult<BudgetResultDto> getBudgets(String token) throws Exception;
}
