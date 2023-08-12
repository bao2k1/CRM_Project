package controller;

import config.MysqlConfig;
import model.Product;
import model.UserModel;
import service.LoginService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@WebServlet(name="loginController",urlPatterns = {"/login"})

public class LoginController extends HttpServlet {
    private LoginService loginService=new LoginService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        Cookie[] cookies=req.getCookies();
//        String username="";
//        String password="";
//        for (Cookie item:
//             cookies) {
//            if (item.getName().equals("username")){
//                username=item.getValue();
//            }
//            if (item.getName().equals("password")){
//                password=item.getValue();
//            }
//
//        }
//        req.setAttribute("username",username);
//        req.setAttribute("password",password);
        req.getRequestDispatcher("login.jsp").forward(req,resp);

    }
/*
* tao checkbox de luu mk
* khi load lai page login thi tu dong dien email,password\
*/
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {



        //Lay tham so post tu thao tac dang nhap
        String remember=req.getParameter("remember");
        String password=(String)req.getParameter("password");
        String email=(String)req.getParameter("username");

        boolean isSuccess = loginService.checkLogin(email,password);
        if(isSuccess){
            String contextPath= req.getContextPath();
//            Cookie cUserName = new Cookie("username",email);
            HttpSession session = req.getSession();

//            resp.addCookie(cUserName);


            session.setAttribute("email",email);
            session.setAttribute("password",password);
            System.out.println(session.getAttribute("email"));
            System.out.println(session.getAttribute("password"));
            resp.sendRedirect(contextPath +"/profile");
        }else{
            PrintWriter writer =resp.getWriter();
            writer.println("Login fail!");

            writer.close();
        }

//        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }
}
