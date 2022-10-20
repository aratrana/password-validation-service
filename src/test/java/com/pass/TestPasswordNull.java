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

public class TestPasswordNull {

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
    public void testPassword_NotNull() {
        passwordValidator = new PasswordValidator(null);
        PasswordCriteriaResult result = passwordValidator.validate("pass@123");
        Assertions.assertTrue(result.isValid());
    }

    @Test
    public void testPassword_Null() {
        PasswordCriteriaResult result = passwordValidator.validate(null);
        Assertions.assertFalse(result.isValid());
    }

    @Test
    public void testPassword_Null_Error_Message() {
        PasswordCriteriaResult result = passwordValidator.validate(null);
        Assertions.assertNotNull(passwordValidator.getMessage(result));
    }
}
