package com.pass.criteria;

import com.pass.util.PasswordUtil;

import java.util.LinkedHashMap;
import java.util.Map;

public class PasswordUpperCaseCriteria implements Criteria {
    public static final String CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static final String ERROR_CODE = "INSUFFICIENT_UPPERCASE";

    protected int numCharacters = 1;

    public PasswordUpperCaseCriteria(final int num) {
        setNumberOfCharacters(num);
    }

    @Override
    public PasswordCriteriaResult validate(String passwordData)
    {
        final String matchingChars = getCharacterTypes(passwordData);
        if (matchingChars.length() >= numCharacters) {
            return new PasswordCriteriaResult(true);
        } else {
            return
                    new PasswordCriteriaResult(
                            false,
                            new PasswordCriteriaResultDetail(
                                    getErrorCode(),
                                    createRuleResultDetailParameters(
                                            passwordData,
                                            matchingChars)));
        }
    }

    protected Map<String, Object> createRuleResultDetailParameters(
            final String password,
            final String matchingChars)
    {
        final Map<String, Object> m = new LinkedHashMap<>();
        m.put("minimumRequired", numCharacters);
        m.put("matchingCharacterCount", matchingChars.length());
        m.put("validCharacters", getValidCharacters());
        m.put("matchingCharacters", matchingChars);
        return m;
    }

    protected String getCharacterTypes(final String password)
    {
        return PasswordUtil.getMatchingCharacters(CHARS, password);
    }

    protected String getErrorCode()
    {
        return ERROR_CODE;
    }

    public String getValidCharacters()
    {
        return CHARS;
    }

    public void setNumberOfCharacters(final int n)
    {
        if (n > 0) {
            numCharacters = n;
        } else {
            throw new IllegalArgumentException("argument must be greater than zero");
        }
    }
}
