package com.luo.demo.boot.aspect;

import com.luo.demo.boot.exception.ParamValidException;
import com.luo.demo.boot.model.BaseResult;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * param check aspect.
 *
 * @author xiangnan
 * date 2018/7/27 23:05
 */
@Slf4j
@Aspect
@Component
public class ParamValidAspect {
    private static final Logger logger = LoggerFactory.getLogger(ParamValidAspect.class);

    @Before("execution(* com.luo.demo.boot.web.*.*(..)) && args(.., bindingResult)")
    public void paramValid(JoinPoint point, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String msg = formatBindingResult(bindingResult);
            logger.warn("{} - paramValid error: {}", point.getSignature(), msg);
            throw new ParamValidException(msg);
        }
    }

    @Around("execution(* com.luo.demo.boot.web.*.*(..))")
    public Object invokeAround(ProceedingJoinPoint joinPoint) {
        try {
            // @Before
            Object val = joinPoint.proceed();
            return BaseResult.success(val);
        } catch (ParamValidException e) {
            return BaseResult.fail(e);
        }
        catch (Throwable ex) {
            logger.error("invoke error: ", ex);
            return BaseResult.fail(ex);
        }
    }

    @SuppressWarnings("all")
    private String formatBindingResult(BindingResult bindingResult) {
        FieldError fieldError = bindingResult.getFieldError();
        return fieldError.getField() + fieldError.getDefaultMessage();
    }

    /**
     * aop代理经过CustomAopMethod注解修饰的方法
     */
    @Pointcut("@annotation(com.luo.demo.boot.aspect.annotation.CustomAopMethod)")
    public void customAopMethod() {
    }

    @SuppressWarnings("all")
    @Around(value = "customAopMethod()")
    public Object customAopMethod(ProceedingJoinPoint joinPoint) {
        Object obj = null;

        try {
            // 获取该次请求的request信息
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                    .getRequest();
            HttpSession session = request.getSession();

            Assert.notNull(session, "not null");
            obj = joinPoint.proceed();
        } catch (Throwable throwable) {
            log.error("invoke error, e={}", throwable);
        } finally {
            log.debug("info finish");
        }

        return obj;
    }
}
