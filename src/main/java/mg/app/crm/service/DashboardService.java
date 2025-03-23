package mg.app.crm.service;

import mg.app.crm.dto.api.ApiSuccessResult;
import mg.app.crm.dto.dashboard.CRMDashboardResult;

public interface DashboardService 
{
    public ApiSuccessResult<CRMDashboardResult> getDashboardData(String token) throws Exception;    
}
