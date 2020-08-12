package com.github.config;

import com.github.common.CustomException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;


/**
 * @Aspect:作用是把当前类标识为一个切面供容器读取
 *
 * @Pointcut：Pointcut是植入Advice的触发条件。每个Pointcut的定义包括2部分，一是表达式，二是方法签名。方法签名必须是 public及void型。可以将Pointcut中的方法看作是一个被Advice引用的助记符，因为表达式不直观，因此我们可以通过方法签名的方式为 此表达式命名。因此Pointcut中的方法只需要方法签名，而不需要在方法体内编写实际代码。
 * @Around：环绕增强，相当于MethodInterceptor
 * @AfterReturning：后置增强，相当于AfterReturningAdvice，方法正常退出时执行
 * @Before：标识一个前置增强方法，相当于BeforeAdvice的功能，相似功能的还有
 * @AfterThrowing：异常抛出增强，相当于ThrowsAdvice
 * @After: final增强，不管是抛出异常或者正常退出都会执行
 */
@Slf4j
@Aspect
@Component
public class MutexAspect {
    
    @Resource
    RedisDistributedLocker locker;

    // 匹配带有指定注解mutex的方法
    @Around(value = "@annotation(mutex)", argNames = "joinPoint,mutex")
    public Object doAround(ProceedingJoinPoint joinPoint, Mutex mutex) throws Throwable {
        final String[] parameterNames = ((MethodSignature) joinPoint.getSignature()).getParameterNames();
        final String[] argNames = mutex.argNames();
        Object[] args = new Object[argNames.length];
        final Object[] allArgs = joinPoint.getArgs();
        for (int i = 0; i < argNames.length; i++) {
            args[i] = allArgs[ArrayUtils.indexOf(parameterNames, argNames[i])];
        }
        final String key = String.format(mutex.keyTemplate(), args);
        final String lockId = locker.retryLock(key, mutex.expireSeconds(), mutex.trySeconds());
        if (StringUtils.isBlank(lockId)) {
            if (mutex.throwIfLockFail()) {
                throw new CustomException("获取锁失败");
            }
            return null;
        }
        
        Object object;
        try {
            object = joinPoint.proceed();
        } finally {
            locker.unlock(key, lockId);
        }
        return object;
    }
}
