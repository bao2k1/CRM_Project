package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

//khi goi link trong urlPatttern filter se dc kich hoat
@WebFilter(urlPatterns = {"/profile"})
public class AuthFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
//        Filter.super.init(filterConfig);
    }

    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        //quy dinh rule
//        System.out.println("filter run...");
//        //cho phep nguoi dung vao trang
////        filterChain.doFilter(servletRequest,servletResponse);
//
//    }
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
FilterChain ftchanin= (FilterChain) chain;
        // Kiểm tra xem người dùng đã đăng nhập hay chưa bằng cách kiểm tra session
//        Cookie[] cookies = request.getCookies();
        HttpSession session = request.getSession(false);

        if (session!=null&&session.getAttribute("email")!=null)
        {
            //Test huy session
            /*session.removeAttribute("email");
            session.removeAttribute("password");*/
            ftchanin.doFilter(request,response);
            System.out.println("auth ok");
        }
//        boolean found = false;
//        if (cookies != null) {
//            for (Cookie cookie : cookies) {
//                if (cookie.getName().equals("username")) {
//                    // Tìm thấy cookie cần tìm
//                    // Xử lý tại đây
//                    found = true;
//
//                    break;
//                }
//            }
//
//        }
        else  {

//            System.out.println(session.getAttribute("email"));
            // Không tìm thấy cookie cần tìm, chuyển hướng về trang đăng nhập
            String contextPath= request.getContextPath();
            response.sendRedirect(contextPath+"/login");
            System.out.println("pls login");
            return;
        }



//        ftchanin.doFilter(request,response);

    }
    public void destroy() {
        // Hủy filter
    }

}
