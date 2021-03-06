package com.bugjc.ea.member.core.aspect;

import brave.Tracer;
import com.bugjc.ea.member.config.ApplicationConfig;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * Web层日志切面
 * @author : aoki
 */
@Slf4j
@Aspect
@Order(5)
@Component
public class WebLogAspect {

    final Tracer tracer;
    final ApplicationConfig applicationConfig;

    @Autowired
    public WebLogAspect(Tracer tracer, ApplicationConfig applicationConfig) {
        this.tracer = tracer;
        this.applicationConfig = applicationConfig;
    }


    private ThreadLocal<Long> startTime = new ThreadLocal<>();


    @Pointcut("execution(public * com.bugjc.ea.member.web..*.*(..))")
    public void webLog(){}

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        //重新设置zipkin name,防止通过转发的请求name值不对。
        tracer.currentSpan().name(applicationConfig.applicationName);
        startTime.set(System.currentTimeMillis());

        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (attributes != null){
            HttpServletRequest request = attributes.getRequest();

            // 记录下请求内容
//            log.info("URL : " + request.getRequestURL().toString());
//            log.info("HTTP_METHOD : " + request.getMethod());
//            log.info("IP : " + request.getRemoteAddr());
//            log.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
//            log.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));
        }


    }

    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(Object ret) throws Throwable {
        // 处理完请求，返回内容
        //log.info("RESPONSE : " + ret);
        log.info("SPEND TIME : " + (System.currentTimeMillis() - startTime.get()));
        startTime.remove();
    }


}
