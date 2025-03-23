package mg.app.crm.dto.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MenuNavigationTreeNodeDto 
{
    private String id;
    private String name;
    private String pid;
    private String navURL;
    private boolean hasChild;
    private boolean expanded;
    private boolean isSelected;
}