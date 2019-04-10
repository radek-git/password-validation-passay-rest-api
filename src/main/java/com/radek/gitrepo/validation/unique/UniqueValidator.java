package com.radek.gitrepo.validation.unique;

import com.radek.gitrepo.app.ApplicationContextProvider;
import com.radek.gitrepo.service.util.FieldValueExists;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueValidator implements ConstraintValidator<Unique, Object> {

    private FieldValueExists service;
    private String fieldName;

    @Override
    public void initialize(Unique unique) {
        fieldName = unique.fieldName();
        service = (FieldValueExists) ApplicationContextProvider.getBean(unique.service());
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        return !service.fieldValueExists(value, fieldName);
    }

}
