package controller;

import model.UserModel;
import service.LoginService;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name="profileController",urlPatterns = {"/profile"})
public class ProfileController extends HttpServlet {
    private LoginService loginService=new LoginService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String password=(String) session.getAttribute("password");
        String email=(String)session.getAttribute("email");
        if (session!=null&&session.getAttribute("email")!=null)
        {
            //Test huy session
//            session.removeAttribute("email");

            List<UserModel> user = loginService.profileLogin(email,password);


            req.setAttribute("listUser",user );
            System.out.println(user.get(0).getFullname());
        }



        req.getRequestDispatcher("profile.jsp").forward(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {






//        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }
}
