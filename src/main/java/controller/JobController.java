package controller;

import model.JobModel;
import model.RoleModel;
import model.UserModel;
import service.JobService;
import service.LoginService;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

import java.util.List;

@WebServlet(name="jobController",urlPatterns = {"/groupwork","/groupwork/add","/groupwork/delete"})
public class JobController extends HttpServlet {
    private JobService jobService=new JobService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Lay duong dan servlet nguoi dung goi tren router
        String path = req.getServletPath();
        switch (path){
            case "/groupwork":
                getAllJobs(req,resp);
                break;
            case "/groupwork/add":
                addJob(req,resp);
                break;
            case "/groupwork/delete":
                deleteJob(req,resp);
                break;
            default:
                break;
        }
    }
    private void deleteJob(HttpServletRequest req, HttpServletResponse resp){
        int id= Integer.parseInt(req.getParameter("id"));
        boolean isSuccess= jobService.deleteJob(id);
    }
    private void getAllJobs(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<JobModel> jobs = jobService.getAllJobs();


        req.setAttribute("listJob", jobs);
        req.getRequestDispatcher("groupwork.jsp").forward(req,resp);
    }
    private void addJob(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
        String method= req.getMethod();
        List<JobModel> listJob=jobService.getAllJobs();
        if(method.equalsIgnoreCase("post")){
            String name = req.getParameter("name");
            String start_date = req.getParameter("start_date");
            String end_date = req.getParameter("end_date");

            jobService.insertJob(name,start_date,end_date);

        }
        req.setAttribute("listJob",listJob);
        req.getRequestDispatcher("/groupwork-add.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        addJob(req,resp);




//        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }
}
