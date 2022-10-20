package com.pass;

import com.pass.criteria.Criteria;
import com.pass.criteria.PasswordCriteriaResult;
import com.pass.validators.PasswordValidator;
import com.pass.validators.i18n.I18nMessageResolver;
import mockit.Injectable;
import mockit.Tested;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class TestPasswordLength {
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
    public  void testPasswordLength_Fail() {
        PasswordCriteriaResult result = passwordValidator.validate("12345");
        Assertions.assertFalse(result.isValid());
    }
}