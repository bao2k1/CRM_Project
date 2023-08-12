package controller;

import model.RoleModel;
import model.UserModel;
import service.RoleService;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name="roleController",urlPatterns = {"/role","/role/add","/role/delete"})
public class RoleController extends HttpServlet {
    private RoleService roleService=new RoleService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Lay duong dan servlet nguoi dung goi tren router
        String path = req.getServletPath();
        switch (path){
            case "/role":
                getAllRoles(req,resp);
                break;
            case "/role/add":
                addRole(req,resp);
                break;
            case "/role/delete":
                deleteRole(req,resp);
                break;
            default:
                break;
        }



    }
    private void deleteRole(HttpServletRequest req, HttpServletResponse resp){
        int id= Integer.parseInt(req.getParameter("id"));
        boolean isSuccess= roleService.deleteRole(id);
    }
    private void getAllRoles(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<RoleModel> roles = roleService.getAllRoles();

        req.setAttribute("listRole", roles);
        req.getRequestDispatcher("role-table.jsp").forward(req,resp);
    }
    private void addRole(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
        String method= req.getMethod();
        List<RoleModel> listRole=roleService.getAllRoles();
        if(method.equalsIgnoreCase("post")){
            String name = req.getParameter("name");
            String desc = req.getParameter("desc");
            roleService.insertRole(name,desc);

        }
        req.setAttribute("listRoles",listRole);
        req.getRequestDispatcher("/role-add.jsp").forward(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        addRole(req,resp);



//        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }
}
