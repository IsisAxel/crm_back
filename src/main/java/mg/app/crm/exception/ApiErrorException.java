package mg.app.crm.exception;

import mg.app.crm.dto.api.ApiErrorResult;

public class ApiErrorException extends Exception {
    private final ApiErrorResult errorResult;

    public ApiErrorException(ApiErrorResult errorResult) {
        super(errorResult.getMessage());
        this.errorResult = errorResult;
    }

    public ApiErrorResult getErrorResult() {
        return errorResult;
    }
}
