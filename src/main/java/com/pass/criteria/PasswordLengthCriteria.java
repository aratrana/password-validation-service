package com.pass.criteria;

import lombok.NoArgsConstructor;

import java.util.LinkedHashMap;
import java.util.Map;

@NoArgsConstructor
public class PasswordLengthCriteria implements Criteria {
    public static final String ERROR_CODE_MIN_LENGTH = "PASSWORD_TOO_SHORT";
    public static final String ERROR_CODE_MAX_LENGTH = "PASSWORD_TOO_LONG";

    /**
     * Store minimum length of password
     **/
    private int minimumLength;

    /**
     * Store maximimum length of password
     **/
    private int maximumLength = Integer.MAX_VALUE;

    public PasswordLengthCriteria(final int length) {
        minimumLength = length;
        maximumLength = length;
    }

    public PasswordLengthCriteria(final int minLength, final int maxLength) {
        minimumLength = minLength;
        maximumLength = maxLength;
    }

    public int getMinimumLength() {
        return minimumLength;
    }

    public void setMinimumLength(int minimumLength) {
        this.minimumLength = minimumLength;
    }

    public int getMaximumLength() {
        return maximumLength;
    }

    public void setMaximumLength(int maximumLength) {
        this.maximumLength = maximumLength;
    }

    @Override
    public PasswordCriteriaResult validate(String password) {
        PasswordCriteriaResult result = new PasswordCriteriaResult();
        final int length = password.length();
        if (length >= minimumLength && length <= maximumLength) {
            result.setValid(true);
        } else {
            result.setValid(false);
            if (length < minimumLength) {
                result.getCriteriaResultDetail().add(
                        new PasswordCriteriaResultDetail(
                                ERROR_CODE_MIN_LENGTH,
                                createRuleResultDetailParameters()));
            } else {
                result.getCriteriaResultDetail().add(
                        new PasswordCriteriaResultDetail(
                                ERROR_CODE_MAX_LENGTH,
                                createRuleResultDetailParameters()));
            }
        }
        return result;
    }

    protected Map<String, Object> createRuleResultDetailParameters()
    {
        final Map<String, Object> m = new LinkedHashMap<>();
        m.put("minimumLength", minimumLength);
        m.put("maximumLength", maximumLength);
        return m;
    }
}
