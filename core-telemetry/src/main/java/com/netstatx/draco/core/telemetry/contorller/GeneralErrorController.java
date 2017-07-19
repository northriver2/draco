package com.netstatx.draco.core.telemetry.contorller;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.autoconfigure.web.BasicErrorController;
import org.springframework.boot.autoconfigure.web.DefaultErrorAttributes;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collections;
import java.util.Map;


/**
 * @author wangle<thisiswangle@gmail.com>
 */
@Log4j2
@Controller
public class GeneralErrorController extends BasicErrorController {
    private static final String ERROR_ATTRIBUTE = DefaultErrorAttributes.class.getName() + ".ERROR";
    public GeneralErrorController(ServerProperties serverProperties) {
        super(new DefaultErrorAttributes(), serverProperties.getError());
    }

    @Override
    public ModelAndView errorHtml(HttpServletRequest request, HttpServletResponse response) {
        HttpStatus status = this.getStatus(request);
        Map<String, Object> model = Collections.unmodifiableMap(this.getErrorAttributes(request, this.isIncludeStackTrace(request, MediaType.TEXT_HTML)));
        response.setStatus(status.value());
        ModelAndView modelAndView = this.resolveErrorView(request, response, status, model);

        String errorViewName = "400";
        if (status.value() == 403 || status.value() == 404)
            errorViewName = String.valueOf(status.value());
        else if (status.value() <= 599 && status.value() >= 500) {
            errorViewName = "500";
        }

        return modelAndView == null ? new ModelAndView("error/" + errorViewName, model) : modelAndView;
    }

    @Override
    public ResponseEntity error(HttpServletRequest request) {
        RequestAttributes requestAttributes = new ServletRequestAttributes(request);
        Throwable throwable = getError(requestAttributes);
        log.warn("Api error found: {}", request.getRequestURI(), throwable);
        return null;
    }

    private Throwable getError(RequestAttributes requestAttributes) {
        Throwable exception = (Throwable)this.getAttribute(requestAttributes, ERROR_ATTRIBUTE);
        if(exception == null) {
            exception = (Throwable)this.getAttribute(requestAttributes, "javax.servlet.error.exception");
        }

        return exception;
    }

    private Object getAttribute(RequestAttributes requestAttributes, String name) {
        return requestAttributes.getAttribute(name, 0);
    }
}
