package annotations;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * Created by Макс on 24.02.2018.
 */
@Aspect
public class LoggingAspect {
    @Pointcut("execution(* *annotations.Student.endExam())")
    private void allLogEventMethods() {
    }

    @Before("allLogEventMethods()")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("BEFORE: \"Classname\": " + joinPoint.getTarget().getClass().getSimpleName());
    }

    @AfterReturning(pointcut = "allLogEventMethods()", returning = "retVal")
    public void logAfter(Object retVal) {
        System.out.println("Mark: " + retVal);
    }
}
