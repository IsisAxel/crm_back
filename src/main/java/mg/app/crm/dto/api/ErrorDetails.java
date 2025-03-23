package mg.app.crm.dto.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDetails {
    private String ref;
    private String exceptionType;
    private String innerException;
    private String source;
    private String stackTrace;
}
