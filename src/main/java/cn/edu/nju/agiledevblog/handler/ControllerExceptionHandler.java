package cn.edu.nju.agiledevblog.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;


/**
 * @ClassName: ControllerExceptionHandler
 * @Description: 拦截异常控制
 */
@ControllerAdvice
public class ControllerExceptionHandler {

    //将异常记录到日志
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * @description 处理错误信息
     * @param request:访问的异常URL
     * @param e:异常参数
     * @return 返回错误信息页面
     */
    @ExceptionHandler(Exception.class)
    public ModelAndView exceptionHandler(HttpServletRequest request, Exception e) throws Exception {
        //记录异常信息
        logger.error("Request URL : {}, Exception : {}", request.getRequestURL(), e);

        //标识了状态码就不拦截
        if (AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class) != null) {
            throw e;
        }

        //将记录的异常信息返回到error页面
        ModelAndView mv = new ModelAndView();
        mv.addObject("url", request.getRequestURL());
        mv.addObject("exception", e);
        mv.setViewName("error/error");
        return mv;
    }

}

