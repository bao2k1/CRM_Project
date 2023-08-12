import model.Users;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("login page");
//        int a=5;
//        int b=10;
//        int result= a+b;
//        req.setAttribute("kq",result);// truyen bien ra file jsp
        // SƯ dung giao dien ra client
//
//        String message=" ";
//        req.setAttribute("msg", message);// truyen bien ra file jsp
        req.getRequestDispatcher("login.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String defaultUsername = "nguyenvana@gmail.com";
        String password=(String)req.getParameter("password");
        String username=(String)req.getParameter("username");
        String message=" ";
        if (username.toLowerCase().equals(defaultUsername)) {
            message = "hello " + username;

        }
        else{
            message="";
        }
        Users user=new Users();
        user.setUsername(username);
        user.setPassword(password);

        List<String> list = Arrays.asList("CyberS","java 21","jsp");

        req.setAttribute("msg", message);// truyen bien ra file jsp
        req.setAttribute("user",user);
        req.setAttribute("list",list);
        req.getRequestDispatcher("login.jsp").forward(req,resp);
        System.out.println("Kiem tra"+ username);

    }
}
