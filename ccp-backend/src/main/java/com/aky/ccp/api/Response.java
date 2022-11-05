package com.aky.ccp.api;

import java.util.Map;

public class Response<T> {
    private String responseStatus;
    private Map<String, String> validationErrors;
    private T responseData;

    public Response(){}
    public Response(String responseStatus, Map<String, String> validationErrors, T responseData) {
        this.responseStatus = responseStatus;
        this.validationErrors = validationErrors;
        this.responseData = responseData;
    }

    public String getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(String responseStatus) {
        this.responseStatus = responseStatus;
    }

    public Map<String, String> getValidationErrors() {
        return validationErrors;
    }

    public void setValidationErrors(Map<String, String> validationErrors) {
        this.validationErrors = validationErrors;
    }

    public T getResponseData() {
        return responseData;
    }

    public void setResponseData(T responseData) {
        this.responseData = responseData;
    }
}
