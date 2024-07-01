package com.mycompany.springframework.aspect;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)// 실행 할 때 
@Target(METHOD) // 메소드에
public @interface RuntimeCheck {

}
