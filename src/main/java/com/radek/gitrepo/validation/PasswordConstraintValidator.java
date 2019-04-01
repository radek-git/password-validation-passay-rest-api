package com.radek.gitrepo.validation;

import org.passay.*;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class PasswordConstraintValidator implements ConstraintValidator<ValidPassword, String> {


    @Override //kod napisany w tym miejscu sprawdza hasło
    public boolean isValid(String password, ConstraintValidatorContext context) {
        context.disableDefaultConstraintViolation(); // wyłącza błąd domyślny

        if (password == null) {
            context.buildConstraintViolationWithTemplate("Password cannot be null")
                    .addConstraintViolation();
            return false;
        }

        PasswordValidator passwordValidator = new PasswordValidator(
                List.of(
                        new LengthRule(8, 30),
                        new LowercaseCharacterRule(1),
                        new UppercaseCharacterRule(1),
                        new DigitCharacterRule(1),
                        new SpecialCharacterRule(1),
                        new WhitespaceRule()
                )
        );

        RuleResult ruleResult = passwordValidator.validate(new PasswordData(password));
        if (ruleResult.isValid()) {
            return true;
        }

        passwordValidator.getMessages(ruleResult).forEach(s ->
                context.buildConstraintViolationWithTemplate(s).addConstraintViolation());

        return false;
    }


}
