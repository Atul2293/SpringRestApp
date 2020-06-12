package com.springboot.features.application.config;

import org.aspectj.lang.annotation.Pointcut;

public class PointCutLibrary {

    @Pointcut("execution(* com.springboot.features.application.service.*.*(..))")
    public void allMethodsOfServiceLayer(){ }
}
