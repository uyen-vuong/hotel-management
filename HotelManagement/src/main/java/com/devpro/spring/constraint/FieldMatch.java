package com.devpro.spring.constraint;

// ràng buộc
import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ TYPE, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = FieldMatchValidator.class)
@Documented
public @interface FieldMatch {
	
	String message() default "{constraints.field-match}";
	Class<?>[] group() default {};
	Class<? extends Payload>[] payload() default{};
	String first();
	String second();
	
	@interface List{
		FieldMatch[] value();
	}
}
