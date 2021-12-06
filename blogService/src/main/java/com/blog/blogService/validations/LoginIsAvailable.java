package com.blog.blogService.validations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = LoginIsAvailableValidator.class)
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface LoginIsAvailable {
	String message() default "Użytkownik o podanym loginie już istnieje ";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
