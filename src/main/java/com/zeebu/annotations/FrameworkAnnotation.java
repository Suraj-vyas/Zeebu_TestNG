package com.zeebu.annotations;

import com.zeebu.enums.AuthorType;
import com.zeebu.enums.CategoryType;
import com.zeebu.enums.TestScenarioType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//This is an Custom Annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface FrameworkAnnotation {

    //Author Type
    public AuthorType[] author();

    //Category Type
    public CategoryType[] category();

    //Test Scenario Type
    public TestScenarioType[] scenario();

}
