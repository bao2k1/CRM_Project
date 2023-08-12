package controller;

import model.RoleModel;
import model.UserModel;
import service.LoginService;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.util.List;

@WebServlet(name="userController",urlPatterns = {"/user","/user/add","/user/edit","/user/delete","/user/detail/*"})
public class UserController extends HttpServlet {
    private UserService userService=new UserService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    //Lay duong dan servlet nguoi dung goi tren router
        String path = req.getServletPath();
        switch (path){
            case "/user":
                getAllUsers(req,resp);
                break;
            case "/user/add":
                addUser(req,resp);
                break;
            case "/user/delete":
                deleteUser(req,resp);
                break;
            case "/user/detail":
                detailUser(req,resp);
                break;
            case "/user/edit":
                updateUser(req,resp);
                break;
            default:
                break;
        }



    }



    private void deleteUser(HttpServletRequest req, HttpServletResponse resp){
        int id= Integer.parseInt(req.getParameter("id"));
            boolean isSuccess= userService.deleteUser(id);
    }
    private void getAllUsers(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<RoleModel> listRole=userService.getAllRoles();
        List<UserModel> isHave = userService.checkList();
        if(isHave.size()>0){
            for (UserModel user:isHave
            ) {
                System.out.println(user.getFullname());
            }

//            String contextPath= req.getContextPath();
//            resp.sendRedirect(contextPath );
        }
      /*  else{
            PrintWriter writer =resp.getWriter();
            writer.println("no user found");
            writer.close();
        }*/
//        System.out.println(isHave);
        req.setAttribute("listUser", isHave);
        req.setAttribute("listRole",listRole);
        req.getRequestDispatcher("user-table.jsp").forward(req,resp);
    }
    private void addUser(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
        String method= req.getMethod();
        List<RoleModel> listRole=userService.getAllRoles();
        if(method.equalsIgnoreCase("post")){
            String fullname = req.getParameter("fullname");
            String email = req.getParameter("email");
            String password = req.getParameter("password");
            int roleId= Integer.parseInt(req.getParameter("role"));
            userService.insertUser(email,fullname,password,roleId);

        }
        req.setAttribute("listRoles",listRole);
        req.getRequestDispatcher("/user-add.jsp").forward(req,resp);
    }
    private void detailUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getPathInfo().substring(1));

        List<UserModel> user = userService.getUserById(id);
        req.setAttribute("user", user);
//        System.out.println("ok detail"+id);
        req.getRequestDispatcher("/user-details.jsp").forward(req,resp);
    }
    private void updateUser(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{
        int id= Integer.parseInt(req.getParameter("id"));
        List<RoleModel> listRole=userService.getAllRoles();
        List<UserModel> user = userService.getUserById(id);

        String method= req.getMethod();
        if(method.equalsIgnoreCase("post")){
            String fullname = req.getParameter("fullname");
            String password = req.getParameter("password");
            String email = req.getParameter("email");
            int roleId= Integer.parseInt(req.getParameter("role"));
            userService.updateUser(email,fullname,roleId,password,id);
            resp.sendRedirect(req.getContextPath() + "/user");
            return;
        }
        req.setAttribute("listRoles",listRole);
        req.setAttribute("user", user);
        req.getRequestDispatcher("/user-edit.jsp").forward(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String requestURI = req.getRequestURI();
//        System.out.println(requestURI);
        if (requestURI != null && requestURI.equals("/demoservlet/user/add")) {
            addUser(req, resp);
        } else if (requestURI != null && requestURI.equals("/demoservlet/user/edit")) {
            updateUser(req, resp);

        }


//        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }

}
