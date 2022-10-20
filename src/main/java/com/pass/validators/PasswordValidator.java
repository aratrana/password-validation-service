package com.pass.validators;

import com.pass.criteria.Criteria;
import com.pass.criteria.PasswordCriteriaResult;

public class PasswordValidator implements Criteria {
    @Override
    public PasswordCriteriaResult validate(String password) {
        PasswordCriteriaResult result = new PasswordCriteriaResult(true);
        if (password == null) {
            result.setValid(false);
            return result;
        }
        return result;
    }
}
