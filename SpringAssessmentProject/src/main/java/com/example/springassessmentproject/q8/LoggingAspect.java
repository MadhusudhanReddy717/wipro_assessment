package com.example.springassessmentproject.q8;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class LoggingAspect {
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("Before: " + joinPoint.getSignature().getName());
    }

    public void logAfterReturning(JoinPoint joinPoint) {
        System.out.println("After Returning: " + joinPoint.getSignature().getName());
    }

    public void logAfterThrowing(JoinPoint joinPoint, Throwable error) {
        System.out.println("Exception in method: " + joinPoint.getSignature().getName() + " Error: " + error.getMessage());
    }

    public Object logAround(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = pjp.proceed();
        long duration = System.currentTimeMillis() - start;
        System.out.println("Execution time of " + pjp.getSignature().getName() + ": " + duration + "ms");
        return result;
    }
}
/*
Before: addToCart
Item added to cart: Tata Harrier
Execution time of addToCart: 85ms
After Returning: addToCart
Before: makePayment
Payment done of Rs: 2500000.0
Execution time of makePayment: 30ms
After Returning: makePayment
Before: placeOrder
Order placed successfully.
Execution time of placeOrder: 0ms
After Returning: placeOrder

*/