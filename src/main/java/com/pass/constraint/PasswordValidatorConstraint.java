package com.pass.constraint;

import com.pass.criteria.PasswordCriteriaResult;
import com.pass.criteria.PasswordDigitCriteria;
import com.pass.criteria.PasswordLengthCriteria;
import com.pass.criteria.PasswordLowerCaseCriteria;
import com.pass.criteria.PasswordUpperCaseCriteria;
import com.pass.enums.ErrorTypeEnum;
import com.pass.validators.PasswordValidator;

import java.util.Arrays;

public class PasswordValidatorConstraint {
    public PasswordCriteriaResult isValid(String password) {
        final PasswordValidator validator = new PasswordValidator(Arrays.asList(
                new PasswordLengthCriteria(8, 30),
                new PasswordUpperCaseCriteria(1),
                new PasswordLowerCaseCriteria(1),
                new PasswordDigitCriteria(1)
        ));
        PasswordCriteriaResult result = validator.validate(password);
        if (result.getCriteriaResultDetail() != null) {
            long count;
            // null check
            count = result.getCriteriaResultDetail().stream().filter(resDetail -> resDetail.getErrorCode().equals(ErrorTypeEnum.IS_NULL.toString())).count();
            if (count > 0) {
                System.out.println(validator.getMessage(result));
                return result;
            }
            // one lowercase
            count = result.getCriteriaResultDetail().stream().filter(resDetail -> resDetail.getErrorCode().equals(ErrorTypeEnum.INSUFFICIENT_LOWERCASE.toString())).count();
            if (count > 0) {
                System.out.println(validator.getMessage(result));
                return result;
            }
            if (result.getCriteriaResultDetail() != null && result.getCriteriaResultDetail().size() < 3) {
                return new PasswordCriteriaResult(true);
            } else {
                System.out.println(validator.getMessage(result));
                return result;
            }
        }
        return new PasswordCriteriaResult(false);
    }
}
