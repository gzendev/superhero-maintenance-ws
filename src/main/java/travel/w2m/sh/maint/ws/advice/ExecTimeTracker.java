package travel.w2m.sh.maint.ws.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExecTimeTracker {

  private static final Logger LOGGER = LoggerFactory.getLogger(ExecTimeTracker.class);

  @Around("@annotation(travel.w2m.sh.maint.ws.advice.TimedExecution)")
  public Object trackingTime(final ProceedingJoinPoint p) throws Throwable {
    long start = System.currentTimeMillis();
    Object o = p.proceed();
    long end = System.currentTimeMillis();
    LOGGER.info("Method {} took {} ms to execute.", p.getSignature(), (end - start));
    return o;
  }

}