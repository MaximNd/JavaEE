package xml;

import org.aspectj.lang.JoinPoint;

/**
 * Created by Макс on 25.02.2018.
 */
public class LoggingAspect {
//    @Pointcut("execution(* *annotations.Student2.endExam())")
    private void allLogEventMethods() {
    }

//    @Before("allLogEventMethods()")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("BEFORE: \"Classname\": " + joinPoint.getTarget().getClass().getSimpleName());
    }

//    @AfterReturning(pointcut = "allLogEventMethods()", returning = "retVal")
    public void logAfter(Object retVal) {
        System.out.println("Mark: " + retVal);
    }
}
