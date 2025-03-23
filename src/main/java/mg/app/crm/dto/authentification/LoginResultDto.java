package mg.app.crm.dto.authentification;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mg.app.crm.dto.api.MenuNavigationTreeNodeDto;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginResultDto 
{
    private String accessToken;
    private String refreshToken;
    private String userId;
    private String email;
    private String firstName;
    private String lastName;
    private String companyName;
    private String avatar;
    // private List<MenuNavigationTreeNodeDto> menuNavigation;
    private List<String> roles;
}
