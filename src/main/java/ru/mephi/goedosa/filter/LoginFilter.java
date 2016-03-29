package ru.mephi.goedosa.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.mephi.goedosa.bean.auth.LoginBean;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by artemsamsonov on 03.12.15.
 */
public class LoginFilter implements Filter {

    protected final static Logger logger = LoggerFactory.getLogger(LoginFilter.class);

    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        LoginBean loginBean = (LoginBean) ((HttpServletRequest) request).getSession().getAttribute("loginMB");

        if (loginBean == null || loginBean.getCurrentUser() == null) {
            String contextPath = ((HttpServletRequest) request).getContextPath();
            ((HttpServletResponse) response).sendRedirect(contextPath + "/pages/public/login.xhtml");
        } else {
            chain.doFilter(request, response);
        }
    }

    public void destroy() {

    }

}
