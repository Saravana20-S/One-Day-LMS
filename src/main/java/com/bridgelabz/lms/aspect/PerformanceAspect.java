package com.bridgelabz.lms.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/*
 * Measures execution time of service methods.
 */
@Slf4j
@Aspect
@Component
public class PerformanceAspect {

    /*
     * Intercepts all methods inside
     * the service package and sub-packages.
     */
    @Around(
            "execution(* com.bridgelabz.lms.service..*(..))"
    )
    public Object measureExecutionTime(
            ProceedingJoinPoint joinPoint
    ) throws Throwable {

        long startTime =
                System.currentTimeMillis();

        try {

            /*
             * Execute the actual service method.
             */
            return joinPoint.proceed();

        } finally {

            long endTime =
                    System.currentTimeMillis();

            long executionTime =
                    endTime - startTime;

            log.info(
                    "PERFORMANCE: {} executed in {} ms",
                    joinPoint.getSignature()
                            .toShortString(),
                    executionTime
            );
        }
    }
}