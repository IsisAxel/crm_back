package mg.app.crm.dto.budget;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeleteBudgetRequest 
{
    private String id;
    private String deletedById;    
}
