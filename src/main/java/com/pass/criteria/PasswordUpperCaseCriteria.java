package com.pass.criteria;

import com.pass.util.PasswordUtil;

import java.util.LinkedHashMap;
import java.util.Map;

public class PasswordUpperCaseCriteria extends AbstractCriteria {
    public static final String CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static final String ERROR_CODE = "INSUFFICIENT_UPPERCASE";


    public PasswordUpperCaseCriteria(final int num) {
        setNumberOfCharacters(num);
    }

    @Override
    protected String getCharacterTypes(final String password)
    {
        return PasswordUtil.getMatchingCharacters(CHARS, password);
    }
    @Override
    protected String getErrorCode()
    {
        return ERROR_CODE;
    }

    @Override
    public String getValidCharacters()
    {
        return CHARS;
    }

    @Override
    public void setNumberOfCharacters(final int n)
    {
        if (n > 0) {
            numCharacters = n;
        } else {
            throw new IllegalArgumentException("argument must be greater than zero");
        }
    }
}
