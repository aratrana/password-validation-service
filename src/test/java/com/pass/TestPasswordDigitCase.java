package com.pass;

import com.pass.criteria.Criteria;
import com.pass.criteria.PasswordCriteriaResult;
import com.pass.criteria.PasswordUpperCaseCriteria;
import com.pass.validators.PasswordValidator;
import com.pass.validators.i18n.I18nMessageResolver;
import mockit.Injectable;
import mockit.Tested;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class TestPasswordDigitCase {
    @Tested
    private static PasswordValidator passwordValidator;

    @Injectable
    I18nMessageResolver messageResolver;

    List<Criteria> criteriaList = new ArrayList<>();

    @BeforeAll
    public static void setUp() {
        passwordValidator = new PasswordValidator(null);
    }

    @Test
    public void testPasswordHasDigit_Fail() {
        criteriaList = new ArrayList<>();
        criteriaList.add(new PasswordDigitCriteria(1));
        passwordValidator = new PasswordValidator(criteriaList);
        PasswordCriteriaResult result = passwordValidator.validate("Testq");
        Assertions.assertFalse(result.isValid());
    }

    @Test
    public void testPasswordHasDigit_Pass() {
        criteriaList = new ArrayList<>();
        criteriaList.add(new PasswordUpperCaseCriteria(1));
        passwordValidator = new PasswordValidator(criteriaList);
        PasswordCriteriaResult result = passwordValidator.validate("Tes@1tq");
        Assertions.assertTrue(result.isValid());
    }
}
