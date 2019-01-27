package ru.wlservice.aspect.logging;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Slf4j
@Aspect
@Component
public class LoggingAspectAround {

    @Around("execution(* ru.wlservice.dao..*(..))")
    public Object logAroundDao(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("AspectAround - DAO - The method {}() begins with {}", joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs()));
        try {
            Object result = joinPoint.proceed();
            log.info("AspectAround - DAO - The method {}() ends with ", joinPoint.getSignature().getName(), result);
            return result;
        } catch (IllegalArgumentException e) {
            log.error("AspectAround - DAO - Illegal argument {} in {}()", Arrays.toString(joinPoint.getArgs()), joinPoint.getSignature().getName());
            throw e;
        }
    }

    @Around("execution(* ru.wlservice.service..*(..))")
    public Object logAroundService(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("AspectAround - Service - The method {}() begins with {}", joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs()));
        try {
            Object result = joinPoint.proceed();
            log.info("AspectAround - Service - The method {}() ends with ", joinPoint.getSignature().getName(), result);
            return result;
        } catch (IllegalArgumentException e) {
            log.error("AspectAround - Service - Illegal argument {} in {}()", Arrays.toString(joinPoint.getArgs()), joinPoint.getSignature().getName());
            throw e;
        }
    }



  /*@Pointcut("execution(* ru.wlservice.service.WorkLogService.insert(..))")
    public final void pointcut() {}

    @Before("pointcut()")
    public void logAroundService(ProceedingJoinPoint joinPoint) throws Throwable {
//        log.info("AspectAround - Service - The method {}() begins with {}", joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs()));
        System.out.println("Good Bye!");
    }*/


//    @Pointcut("within(@org.springframework.stereotype.Service *)")
//    public void serviceClassMethods() {
//    }
//
//    @Around("serviceClassMethods()")
//    public Object serviceClassMethodsHandler(ProceedingJoinPoint pjp) throws Throwable {
//        try {
//            Object result = pjp.proceed();
//            log.info("AspectAround - Service - The method {}() ends with ", pjp.getSignature().getName(), result);
//            return result;
//        } catch (IllegalArgumentException e) {
//
//            throw e;
//        }
//    }


//    @Pointcut(value = "within(@org.springframework.stereotype.Controller *)")
//    public void controllerClassMethods() {
//    }
//
//    @Around(value = "controllerClassMethods()")
//    public Object controllerClassMethodsHandler(ProceedingJoinPoint pjp) throws Throwable {
//        try {
//            Object result = pjp.proceed();
//            log.info("AspectAround - Controller - The method {}() ends with ", pjp.getSignature().getName(), result);
//            return result;
//        } catch (IllegalArgumentException e) {
//
//            throw e;
//        }
//    }


//    @Around("execution(* ru.wlservice.controller.*(*))")
//    public Object logAroundController(ProceedingJoinPoint joinPoint) throws Throwable {
//        log.info("AspectAround - logAroundController - The method {}() begins with {}", joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs()));
//        try {
//            Object result = joinPoint.proceed();
//            log.info("AspectAround - logAroundController - The method {}() ends with ", joinPoint.getSignature().getName(), result);
//            return result;
//        } catch (IllegalArgumentException e) {
//            log.error("AspectAround - logAroundController - Illegal argument {} in {}()", Arrays.toString(joinPoint.getArgs()), joinPoint.getSignature().getName());
//            throw e;
//        }
//    }

}
