package mg.app.crm.dto.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiErrorResult {
    private Integer code;
    private String message;
    private ErrorDetails error;
}
