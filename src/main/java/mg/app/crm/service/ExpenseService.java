package mg.app.crm.service;

import mg.app.crm.dto.api.ApiSuccessResult;
import mg.app.crm.dto.expense.BudgetAlertRateRequest;
import mg.app.crm.dto.expense.BudgetAlertRateResult;
import mg.app.crm.dto.expense.DeleteExpenseRequest;
import mg.app.crm.dto.expense.DeleteExpenseResult;
import mg.app.crm.dto.expense.ExpenseAmountByCampaignDto;
import mg.app.crm.dto.expense.ExpenseAmountByCampaignResult;
import mg.app.crm.dto.expense.ExpenseResultDto;
import mg.app.crm.dto.expense.UpdateExpenseRequest;
import mg.app.crm.dto.expense.UpdateExpenseResult;

public interface ExpenseService 
{
    public ApiSuccessResult<ExpenseResultDto> getExpenses(String token) throws Exception;
    public ApiSuccessResult<BudgetAlertRateResult> createBudgetAlert(BudgetAlertRateRequest request, String token) throws Exception;
    public ApiSuccessResult<UpdateExpenseResult> update(UpdateExpenseRequest request, String token) throws Exception;
    public ApiSuccessResult<DeleteExpenseResult> delete(DeleteExpenseRequest request, String token) throws Exception;
    public ApiSuccessResult<ExpenseAmountByCampaignResult> getExpensesAmountByCampaign(String token) throws Exception;
}
