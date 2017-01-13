package sbe.web1.mvc.interceptors;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class MyIntercept4 extends HandlerInterceptorAdapter {
    static final Logger LOG = LoggerFactory.getLogger(MyIntercept4.class);

    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler) throws Exception {
        LOG.info("#4######## preHandle(), handler = {}", handler);
        String i4div0 = req.getParameter("i4-div0");
        if (null != i4div0 && i4div0.length() > 0) {
            int div0 = Integer.parseInt(i4div0);
            String i4div1 = req.getParameter("i4-div1");
            if (null != i4div1 && i4div1.length() > 0) {
                int div1 = Integer.parseInt(i4div1);
                int divr = div1 / div0;
                LOG.info("#4######## preHandle(), div1 / div0 = {}", divr);
            }
        }
        String i4ioex = req.getParameter("ioex");
        if (null != i4ioex) {
            throw new IOException("from preHandler()");
        }
        return super.preHandle(req, res, handler);
    }
}
