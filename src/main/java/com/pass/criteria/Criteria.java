package com.pass.criteria;

/**
 * Base criteria interface
 * @author Arat Rana
 */
public interface Criteria {
    PasswordCriteriaResult validate(final String password);
}
