package cn.edu.nju.agiledevblog.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @ClassName: LogAspect
 * @Description: 日志切面处理
 */
@Aspect
@Component
public class LogAspect {

    //获取日志信息
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    //定义切面，申明log()是一个切面
    @Pointcut("execution(* cn.edu.nju.agiledevblog.controller.*.*(..))")
    public void log(){}

    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        assert attributes != null;
        HttpServletRequest request = attributes.getRequest();
        //获取URL、IP
        String url = request.getRequestURL().toString();
        String ip = request.getRemoteAddr();
        //获取请求方法
        String classMethod = joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName();
        //获取请求参数
        Object[] args = joinPoint.getArgs();
        RequestLog requestLog = new RequestLog(url, ip, classMethod, args);
        logger.info("Request : {}", requestLog);
    }

    //在切面之后进行
    @After("log()")
    public void doAfter() {
        logger.info("------------doAfter-------------");
    }

    //返回之后拦截
    @AfterReturning(returning = "result", pointcut = "log()")
    public void doAfterReturn(Object result){
        logger.info("Result : {}", result);
    }

    //封装请求参数
    private static class RequestLog {
        private final String url;
        private final String ip;
        private final String classMethod;
        private final Object[] args;

        public RequestLog(String url, String ip, String classMethod, Object[] args) {
            this.url = url;
            this.ip = ip;
            this.classMethod = classMethod;
            this.args = args;
        }

        @Override
        public String toString() {
            return "{" +
                    "url='" + url + '\'' +
                    ", ip='" + ip + '\'' +
                    ", classMethod='" + classMethod + '\'' +
                    ", args=" + Arrays.toString(args) +
                    '}';
        }
    }

}

