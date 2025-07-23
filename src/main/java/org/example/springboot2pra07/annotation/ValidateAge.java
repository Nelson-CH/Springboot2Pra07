package org.example.springboot2pra07.annotation;

import java.lang.annotation.*;

//元註解
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
@Inherited
public @interface ValidateAge {

    //雖然是方法但是在註解中被視為成員變數
    //只能用 public 或 default 修飾, 只能使用基本數據類型跟 String、Enum、Class、Annotation
    int min() default 10;

    int max() default 90;

    int value() default 20;

}
