package mg.app.crm.service;

import mg.app.crm.dto.api.ApiSuccessResult;
import mg.app.crm.dto.budget.BudgetByCampaignResult;
import mg.app.crm.dto.budget.BudgetResultDto;
import mg.app.crm.dto.budget.DeleteBudgetRequest;
import mg.app.crm.dto.budget.DeleteBudgetResult;
import mg.app.crm.dto.budget.UpdateBudgetRequest;
import mg.app.crm.dto.budget.UpdateBudgetResult;

public interface BudgetService 
{
    public ApiSuccessResult<BudgetResultDto> getBudgets(String token) throws Exception;
    public ApiSuccessResult<UpdateBudgetResult> update(UpdateBudgetRequest request, String token) throws Exception;
    public ApiSuccessResult<DeleteBudgetResult> delete(DeleteBudgetRequest request, String token) throws Exception;
    public ApiSuccessResult<BudgetByCampaignResult> getBudgetByCampaign(String token) throws Exception;
}
