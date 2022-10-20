package com.pass;

import com.pass.constraint.PasswordValidatorConstraint;
import com.pass.criteria.PasswordCriteriaResult;
import mockit.Tested;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class TestPasswordOkAtleastThreePrevConditionTrue {
    @Tested
    private static PasswordValidatorConstraint passwordValidatorConstraint;

    @BeforeAll
    public static void setUp() {
        passwordValidatorConstraint = new PasswordValidatorConstraint();
    }

    @Test
    public void testPasswordPrevThreeCondition_True() {
        PasswordCriteriaResult result = passwordValidatorConstraint.isValid("test@123i");
        Assertions.assertTrue(result.isValid());
    }
}
