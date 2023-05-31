package com.woniuxy.canteen.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.woniuxy.canteen.vo.ResponseResult;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@Slf4j
public class SessionFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        String path = req.getRequestURI();
        log.debug("访问的Path：{}", path);
        if (path.equals("/logins.html") || path.equals("/staff/login") || path.equals("/loginc.html") || path.equals("/customer/login") ||
                path.endsWith(".css") || path.endsWith(".js") || path.endsWith(".jpg")) {
            chain.doFilter(request, response);
        } else {
            HttpSession session = req.getSession();
            if (session.getAttribute("staff") == null && session.getAttribute("customer") == null) {
                if (req.getHeader("X-Requested-With") != null) {
                    ResponseResult<Void> responseResult = new ResponseResult<>();
                    responseResult.setCode(403);
                    responseResult.setMsg("未登录");
                    ObjectMapper objectMapper = new ObjectMapper();
                    String result = objectMapper.writeValueAsString(responseResult);
                    log.debug("JSON：{}", result);
                    PrintWriter writer = resp.getWriter();
                    writer.write(result);
                    writer.close();
                } else {
                    resp.sendRedirect("/logins.html");
                }
            } else {
                chain.doFilter(request, response);
            }
        }
    }
}
