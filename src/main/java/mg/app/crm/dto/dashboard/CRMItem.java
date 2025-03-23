package mg.app.crm.dto.dashboard;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CRMItem {
    private double campaignTotalAmount;
    private double leadTotalAmount;
    private double budgetTotalAmount;
    private double expenseTotalAmount;
    private double closedTotalAmount;
}
