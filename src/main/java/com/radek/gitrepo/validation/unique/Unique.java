package com.radek.gitrepo.validation.unique;

import com.radek.gitrepo.FieldValueExists;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueValidator.class)
public @interface Unique {

    String message() default "{unique.value.violation}"; //wartość zmiennej zapisana jest w application.properties

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    Class<? extends FieldValueExists> service();

    String fieldName();
}
