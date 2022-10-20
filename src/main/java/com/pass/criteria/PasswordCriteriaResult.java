package com.pass.criteria;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class PasswordCriteriaResult {
    protected boolean valid;
    protected List<PasswordCriteriaResultDetail> criteriaResultDetail= new ArrayList<>();

    public PasswordCriteriaResult(final boolean valid, final PasswordCriteriaResultDetail detail) {
        setValid(valid);
        criteriaResultDetail.add(detail);
    }

    public PasswordCriteriaResult(final boolean valid) {
        setValid(valid);
    }

}
