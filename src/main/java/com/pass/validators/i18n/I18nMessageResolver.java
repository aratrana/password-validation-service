package com.pass.validators.i18n;

import com.pass.criteria.PasswordCriteriaResultDetail;

public interface I18nMessageResolver {

    /**
     *  Resolve the i18n message for the criteria result
     * @param resultDetail
     * @return
     */
    String resolve(PasswordCriteriaResultDetail resultDetail);
}
