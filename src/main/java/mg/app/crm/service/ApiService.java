package mg.app.crm.service;


import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import mg.app.crm.dto.api.ApiErrorResult;
import mg.app.crm.dto.api.ApiSuccessResult;
import mg.app.crm.exception.ApiErrorException;

public class ApiService 
{
    public static <T> ApiSuccessResult<T> parseResponse(String jsonResponse, Class<T> contentClass) throws ApiErrorException {
        Gson gson = new Gson();
        JsonElement rootNode = JsonParser.parseString(jsonResponse);
    
        if (rootNode.getAsJsonObject().has("code")) {
            int code = rootNode.getAsJsonObject().get("code").getAsInt();
    
            if (code == 200) {
                ApiSuccessResult<T> successResult = gson.fromJson(rootNode, 
                    TypeToken.getParameterized(ApiSuccessResult.class, contentClass).getType());
    
                return successResult;
            } else {
                ApiErrorResult errorResult = gson.fromJson(rootNode, ApiErrorResult.class);
                throw new ApiErrorException(errorResult);
            }
        } else {
            throw new RuntimeException("Internal error!");
        }
    }
}
