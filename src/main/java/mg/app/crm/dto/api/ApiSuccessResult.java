package mg.app.crm.dto.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiSuccessResult<T> {
    private int code;
    private String message;
    private T content;
}
