package controller;

import model.JobModel;
import model.RoleModel;
import model.TaskModel;
import model.UserModel;
import service.JobService;
import service.TaskService;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name="taskController",urlPatterns = {"/task","/task/add","/task/delete"})
public class TaskController extends HttpServlet {
    private UserService userService = new UserService();
    private JobService jobService = new JobService();
    private TaskService taskService=new TaskService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Lay duong dan servlet nguoi dung goi tren router
        String path = req.getServletPath();
        switch (path){
            case "/task":
                getAllTasks(req,resp);
                break;
            case "/task/add":
                addTask(req,resp);
                break;
            case "/task/delete":
                deleteTask(req,resp);
                break;
            default:
                break;
        }



    }
    private void getAllTasks(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<UserModel> listUser=userService.checkList();
        List<JobModel> listJob=jobService.getAllJobs();
        List<TaskModel> tasks = taskService.getAllTasks();

        req.setAttribute("listTask", tasks);
        req.setAttribute("listJob",listJob);
        req.setAttribute("listUser",listUser);
        req.getRequestDispatcher("task.jsp").forward(req,resp);

    }
    private void addTask(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
        String method= req.getMethod();
        List<JobModel> listJob=jobService.getAllJobs();
        List<UserModel> listUser=userService.checkList();
        if(method.equalsIgnoreCase("post")){
            int jobId = Integer.parseInt(req.getParameter("job"));
            String taskname = req.getParameter("taskname");
            int userId = Integer.parseInt(req.getParameter("user"));
            String startdate = req.getParameter("startdate");
            String enddate = req.getParameter("enddate");
            int statusId=1;

            taskService.insertTask(taskname,startdate,enddate,userId,jobId,statusId);

        }
        req.setAttribute("listUser",listUser);
        req.setAttribute("listJob",listJob);

        req.getRequestDispatcher("/task-add.jsp").forward(req,resp);
    }
    private void deleteTask(HttpServletRequest req, HttpServletResponse resp){
        int id= Integer.parseInt(req.getParameter("id"));
        boolean isSuccess= taskService.deleteTask(id);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        addTask(req,resp);



//        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }
}
