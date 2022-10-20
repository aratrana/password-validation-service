package com.pass;

import com.pass.constraint.PasswordValidatorConstraint;
import com.pass.criteria.PasswordCriteriaResult;
import mockit.Tested;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class TestPasswordConstraint {
    @Tested
    private static PasswordValidatorConstraint passwordValidatorConstraint;

    @BeforeAll
    public static void setUp() {
        passwordValidatorConstraint = new PasswordValidatorConstraint();
    }

    @Test
    public void testPassword_Mandatory_Fail_No_LowerCase() {
        PasswordCriteriaResult result = passwordValidatorConstraint.isValid("TEST@123");
        Assertions.assertFalse(result.isValid());
    }

    @Test
    public void testPassword_Mandatory_Fail_No_LowerCase_Pass() {
        PasswordCriteriaResult result = passwordValidatorConstraint.isValid("TEST@123u");
        Assertions.assertTrue(result.isValid());
    }
}
