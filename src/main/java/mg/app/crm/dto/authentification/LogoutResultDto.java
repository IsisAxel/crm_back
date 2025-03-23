package mg.app.crm.dto.authentification;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LogoutResultDto 
{
    private String accessToken;
    private String refreshToken;
    private String userId;
    private String email;
    private String firstName;
    private String lastName;
    private String companyName;
    private List<String> userClaims;
}
