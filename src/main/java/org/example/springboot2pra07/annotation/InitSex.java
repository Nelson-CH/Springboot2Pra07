package org.example.springboot2pra07.annotation;

import java.lang.annotation.*;

//元註解
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
@Inherited
public @interface InitSex {

    enum SEX_TYPE {MAN, WOMAN}

    SEX_TYPE sex() default SEX_TYPE.MAN;
}
