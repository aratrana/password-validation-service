package com.pass.criteria;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class PasswordCriteriaResult {
    protected boolean valid;

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public PasswordCriteriaResult(final boolean valid) {
        setValid(valid);
    }
}
