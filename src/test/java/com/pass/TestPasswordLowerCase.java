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

public class TestPasswordLowerCase {
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
    public void testPasswordLowerCase_Fail() {
        criteriaList = new ArrayList<>();
        criteriaList.add(new PasswordLowerCaseCriteria(1));
        passwordValidator = new PasswordValidator(criteriaList);
        PasswordCriteriaResult result = passwordValidator.validate("1Q");
        Assertions.assertFalse(result.isValid());
    }

    @Test
    public void testPasswordLowerCase_Pass() {
        criteriaList = new ArrayList<>();
        criteriaList.add(new PasswordLowerCaseCriteria(1));
        passwordValidator = new PasswordValidator(criteriaList);
        PasswordCriteriaResult result = passwordValidator.validate("1q");
        Assertions.assertTrue(result.isValid());
    }
}
