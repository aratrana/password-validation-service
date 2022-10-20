package com.pass.validators;

import com.pass.criteria.Criteria;
import com.pass.criteria.PasswordCriteriaResult;
import com.pass.criteria.PasswordCriteriaResultDetail;
import com.pass.validators.i18n.I18nMessageResolver;
import com.pass.validators.i18n.PropertiesMessageResolver;

import java.util.ArrayList;
import java.util.List;

public class PasswordValidator implements Criteria {

    private static final String ERROR_CODE_NULL = "NULL";

    private final List<Criteria> criteriaList;

    private final I18nMessageResolver messageResolver;

    public PasswordValidator(final List<Criteria> criteriaList) {
        this(criteriaList, new PropertiesMessageResolver());
    }

    public PasswordValidator(List<Criteria> criteriaList, I18nMessageResolver messageResolver) {
        this.criteriaList = criteriaList;
        this.messageResolver = messageResolver;
    }


    public List<String> getMessage(final PasswordCriteriaResult result) {
        final List<String> messages = new ArrayList<>();
        for (PasswordCriteriaResultDetail detail : result.getCriteriaResultDetail()) {
            messages.add(messageResolver.resolve(detail));
        }
        return messages;
    }

    @Override
    public PasswordCriteriaResult validate(String password) {
        PasswordCriteriaResult result = new PasswordCriteriaResult(true);
        if (password == null) {
            result.setValid(false);
            result.getCriteriaResultDetail().add(new PasswordCriteriaResultDetail(ERROR_CODE_NULL, null));
            return result;
        }
        for (Criteria rule : criteriaList) {
            // do not want to change the original result so one more object declared
            final PasswordCriteriaResult criteriaResult = rule.validate(password);
            if (!criteriaResult.isValid()) {
                result.setValid(false);
                result.getCriteriaResultDetail().addAll(criteriaResult.getCriteriaResultDetail());
            }
        }
        return result;
    }
}
