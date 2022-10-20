package com.pass.criteria;

import java.util.LinkedHashMap;
import java.util.Map;

public abstract class AbstractCriteria implements CharacterCriteria {
    protected int numCharacters = 1;

    @Override
    public void setNumberOfCharacters(final int n)
    {
        if (n > 0) {
            numCharacters = n;
        } else {
            throw new IllegalArgumentException("argument must be greater than zero");
        }
    }

    @Override
    public int getNumberOfCharacters()
    {
        return numCharacters;
    }

    protected abstract String getCharacterTypes(final String password);

    protected abstract String getErrorCode();

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
}
