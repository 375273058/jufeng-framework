package co.jufeng.core.factory.action.inject;

import static co.jufeng.core.factory.action.inject.Container.DEFAULT_NAME;

import static java.lang.annotation.ElementType.*;
import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Target;

@Target({METHOD, CONSTRUCTOR, FIELD, PARAMETER})
@Retention(RUNTIME)
public @interface Inject {

	public String value() default DEFAULT_NAME;

	public boolean required() default true;
}
