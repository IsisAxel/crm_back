package mg.app.crm.dto.expense;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mg.app.crm.dto.GeneralModifResultDto;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeleteExpenseResult 
{
    private GeneralModifResultDto data;    
}
