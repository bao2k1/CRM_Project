package repository;

import config.MysqlConfig;
import model.TaskModel;
import model.UserModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TaskRepository {
    public List<TaskModel> findAllTasks(){
        Connection conn=null;
        List<TaskModel> taskModelList=new ArrayList<>();

        try{
            String sql="select * from tasks t ";
            PreparedStatement statement= MysqlConfig.getConnection().prepareStatement(sql);


            ResultSet resultSet=statement.executeQuery();
            //duyet tung dong du lieu resultset va luu vao list user
            while (resultSet.next()){
                TaskModel taskModel=new TaskModel();
                taskModel.setId(resultSet.getInt("id"));
                taskModel.setTaskName(resultSet.getString("name"));
                taskModel.setStartDate(resultSet.getString("start_date"));
                taskModel.setEndDate(resultSet.getString("end_date"));
                taskModel.setUserId(resultSet.getInt("user_id"));
                taskModel.setJobId(resultSet.getInt("job_id"));
                taskModel.setJobId(resultSet.getInt("status_id"));
                taskModelList.add(taskModel);
            }
        }catch(Exception e){
            System.out.println("Error findAllTasks: "+e.getMessage());
        }finally {
            if(conn!=null){
                try{
                    conn.close();
                }catch(Exception e)
                {
                    System.out.println("Loi dong ket noi findAllTasks:"+e.getMessage());
                }
            }
        }
        return taskModelList;
    }
    public boolean insertTask(String name,String startDate,String endDate,int user_id,int job_id,int status_id){
        Connection conn=null;
        boolean isSuccess = false;
        try{
            conn=MysqlConfig.getConnection();
            String sql="insert into tasks(name, start_date, end_date,user_id,job_id,status_id) values(?,STR_TO_DATE(?, '%d/%m/%Y'),STR_TO_DATE(?, '%d/%m/%Y'),?,?,?) ";

            PreparedStatement statement= conn.prepareStatement(sql);
            statement.setString(1,name);
            statement.setString(2,startDate);
            statement.setString(3,endDate);
            statement.setInt(4, user_id);
            statement.setInt(5, job_id);
            statement.setInt(6, status_id);

            isSuccess= statement.executeUpdate()>0;


        }catch (Exception e){
            System.out.println("Loi addTask:"+e.getMessage());
        }finally {
            if(conn!=null){
                try{
                    conn.close();
                }catch(Exception e)
                {
                    System.out.println("Loi dong ket noi addTask:"+e.getMessage());
                }
            }
        }
        return isSuccess;
    }

    public boolean deleteTaskById(int id){
        Connection conn=null;
        boolean isSuccess=false;
        try{
            conn = MysqlConfig.getConnection();
            String sql="delete from tasks t where t.id=?";
            PreparedStatement statement=conn.prepareStatement(sql);
            statement.setInt(1,id);
            isSuccess= statement.executeUpdate()>0;
        }catch(Exception e){
            System.out.println("Loi deleteTaskById:"+e.getMessage());
        }finally {
            if(conn!=null){
                try{
                    conn.close();
                }catch(Exception e)
                {
                    System.out.println("Loi dong ket noi deleteTaskById:"+e.getMessage());
                }
            }
        }
        return isSuccess;
    }
}
