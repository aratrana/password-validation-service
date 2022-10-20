package com.pass.validators.i18n;

import com.pass.criteria.PasswordCriteriaResultDetail;

public abstract class AbstractI18nMessageResolver implements I18nMessageResolver {

    /**
     * return the message of the key
     * @param key
     * @return
     */
    protected abstract String getMessage(final String key);

    @Override
    public String resolve(PasswordCriteriaResultDetail detail) {
        final String key = detail.getErrorCode();
        final String message = getMessage(key);
        String format;
        if (message != null) {
            format = String.format(message, detail.getInputParameterValues());
        } else {
            if (!detail.getInputParameters().isEmpty()) {
                format = String.format("%s:%s", key, detail.getInputParameters());
            } else {
                format = String.format("%s", key);
            }
        }
        return format;
    }
}
