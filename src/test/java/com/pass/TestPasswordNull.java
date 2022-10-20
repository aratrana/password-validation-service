package com.pass;

import com.pass.criteria.PasswordCriteriaResult;
import com.pass.validators.PasswordValidator;
import mockit.Tested;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestPasswordNull {

    @Tested
    PasswordValidator passwordValidator;

    @Test
    public void testPassword_NotNull() {
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
