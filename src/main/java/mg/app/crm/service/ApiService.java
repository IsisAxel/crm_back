package mg.app.crm.service;


import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import mg.app.crm.dto.api.ApiErrorResult;
import mg.app.crm.dto.api.ApiSuccessResult;
import mg.app.crm.exception.ApiErrorException;

public class ApiService 
{
    public static <T> ApiSuccessResult<T> parseResponse(String jsonResponse, Type type) throws ApiErrorException {
        Gson gson = new Gson();
        JsonElement rootNode = JsonParser.parseString(jsonResponse);
    
        if (rootNode.getAsJsonObject().has("code")) {
            int code = rootNode.getAsJsonObject().get("code").getAsInt();
    
            if (code == 200) {
                return gson.fromJson(rootNode, type);
            } else {
                ApiErrorResult errorResult = gson.fromJson(rootNode, ApiErrorResult.class);
                throw new ApiErrorException(errorResult);
            }
        } else {
            throw new RuntimeException("Internal error!");
        }
    }
    
}
