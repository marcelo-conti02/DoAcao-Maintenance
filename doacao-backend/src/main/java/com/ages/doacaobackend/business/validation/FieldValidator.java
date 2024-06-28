package com.ages.doacaobackend.business.validation;

import com.ages.doacaobackend.business.exception.MalformedEntityException;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.List;
import java.util.stream.Collectors;

public abstract class FieldValidator {

    public static void validateFields(Object obj) throws MalformedEntityException {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        List<String> errors = validator.validate(obj).stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.toList());
        if(!errors.isEmpty())
            throw new MalformedEntityException(errors);
    }
}
