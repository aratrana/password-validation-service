package com.pass.criteria;

import com.pass.util.PasswordUtil;

public class PasswordLowerCaseCriteria extends AbstractCriteria {
    public static final String CHARS = "abcdefghijklmnopqrstuvwxyz";
    public static final String ERROR_CODE = "INSUFFICIENT_LOWERCASE";

    public PasswordLowerCaseCriteria() {

    }

    public PasswordLowerCaseCriteria(final int num) {
        setNumberOfCharacters(num);
    }

    @Override
    public String getValidCharacters() {
        return CHARS;
    }


    @Override
    protected String getErrorCode() {
        return ERROR_CODE;
    }


    @Override
    protected String getCharacterTypes(final String password) {
        return PasswordUtil.getMatchingCharacters(CHARS, password);
    }

}
