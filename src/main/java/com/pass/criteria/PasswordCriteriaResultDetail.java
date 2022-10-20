package com.pass.criteria;

import lombok.Getter;

import java.util.LinkedHashMap;
import java.util.Map;


@Getter
public class PasswordCriteriaResultDetail {
    protected final String errorCode;

    protected final Map<String, Object> inputParameters;

    public PasswordCriteriaResultDetail(final String errorCode, final Map<String, Object> iInputParameters) {
        if (errorCode == null || errorCode.length() == 0) {
            throw new IllegalArgumentException("Error code can not be null or empty");
        }
        this.errorCode = errorCode;
        if (iInputParameters == null) {
            inputParameters = new LinkedHashMap<>();
        } else {
            inputParameters = new LinkedHashMap<>(iInputParameters);
        }
    }

    public Object[] getInputParameterValues() {
        return inputParameters.values().toArray();
    }

    @Override
    public String toString() {
        return String.format("%s: %s", errorCode, inputParameters);
    }
}
