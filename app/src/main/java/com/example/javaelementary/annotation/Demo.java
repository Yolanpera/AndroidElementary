package com.example.javaelementary.annotation;

/**
 * Created by ypp on 2021/5/13
 */
@MyAnnotation(getValue = "annotation on class")
public class Demo {

    @MyAnnotation(getValue = "annotation on field")
    public String name;

    @MyAnnotation(getValue = "annotation on method")
    public void fun(){}
}
