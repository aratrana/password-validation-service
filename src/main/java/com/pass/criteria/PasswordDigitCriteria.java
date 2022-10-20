package com.pass.criteria;

import com.pass.util.PasswordUtil;

public class PasswordDigitCriteria extends AbstractCriteria {

    public static final String ERROR_CODE = "INSUFFICIENT_DIGIT";

    public static final String CHARS = "0123456789";

    public PasswordDigitCriteria() {

    }

    public PasswordDigitCriteria(final int num) {
        setNumberOfCharacters(num);
    }

    @Override
    public String getValidCharacters()
    {
        return CHARS;
    }


    @Override
    protected String getErrorCode()
    {
        return ERROR_CODE;
    }


    @Override
    protected String getCharacterTypes(final String password)
    {
        return PasswordUtil.getMatchingCharacters(CHARS, password);
    }

}
