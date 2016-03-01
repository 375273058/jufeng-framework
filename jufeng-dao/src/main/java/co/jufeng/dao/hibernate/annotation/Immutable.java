package co.jufeng.dao.hibernate.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
@java.lang.annotation.Target({ElementType.TYPE, ElementType.METHOD, ElementType.FIELD})
@Retention( RetentionPolicy.RUNTIME )
public @interface Immutable {
}