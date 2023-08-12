package repository;

import config.MysqlConfig;
import model.JobModel;
import model.UserModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    public List<UserModel> findByEmailAndPassword(String email, String password){
        Connection conn=null;
        List<UserModel> userModelList=new ArrayList<>();

        try{
            String sql="select * from users u where u.email =? and u.password =?";
            PreparedStatement statement= MysqlConfig.getConnection().prepareStatement(sql);
            statement.setString(1,email);
            statement.setString(2,password);

            ResultSet resultSet=statement.executeQuery();
            //duyet tung dong du lieu resultset va luu vao list user
            while (resultSet.next()){
                UserModel userModel=new UserModel();
                userModel.setId(resultSet.getInt("id"));
                userModel.setEmail(resultSet.getString("email"));
                userModel.setFullname(resultSet.getString("fullname"));
                userModel.setRoleId(resultSet.getInt("role_id"));
                userModelList.add(userModel);
            }
        }catch(Exception e){
            System.out.println("Error findByEmailAndPassword: "+e.getMessage());
        }finally {
            if(conn!=null){
                try{
                    conn.close();
                }catch(Exception e)
                {
                    System.out.println("Loi dong ket noi findByEmailAndPassword:"+e.getMessage());
                }
            }
        }
    return userModelList;
    }
    public List<UserModel> findAllUsers(){
        Connection conn=null;
        List<UserModel> userModelList=new ArrayList<>();

        try{
            String sql="select * from users u ";
            PreparedStatement statement= MysqlConfig.getConnection().prepareStatement(sql);


            ResultSet resultSet=statement.executeQuery();
            //duyet tung dong du lieu resultset va luu vao list user
            while (resultSet.next()){
                UserModel userModel=new UserModel();
                userModel.setId(resultSet.getInt("id"));
                userModel.setEmail(resultSet.getString("email"));
                userModel.setFullname(resultSet.getString("fullname"));
                userModel.setRoleId(resultSet.getInt("role_id"));

                userModelList.add(userModel);
            }
        }catch(Exception e){
            System.out.println("Error findAllUsers: "+e.getMessage());
        }finally {
            if(conn!=null){
                try{
                    conn.close();
                }catch(Exception e)
                {
                    System.out.println("Loi dong ket noi findAllUsers:"+e.getMessage());
                }
            }
        }
        return userModelList;
    }
    public boolean insertUser(String fullname,String email,String password,int roleId){
        Connection conn=null;
        boolean isSuccess = false;
        try{
            conn=MysqlConfig.getConnection();
            String sql="insert into users(email,password,fullname,role_id) values(?,?,?,?) ";
            PreparedStatement statement= conn.prepareStatement(sql);
            statement.setString(1,email);
            statement.setString(2,password);
            statement.setString(3,fullname);
            statement.setInt(4, roleId);

            isSuccess= statement.executeUpdate()>0;


        }catch (Exception e){
            System.out.println("Loi addUser:"+e.getMessage());
        }finally {
            if(conn!=null){
                try{
                    conn.close();
                }catch(Exception e)
                {
                    System.out.println("Loi dong ket noi addUser:"+e.getMessage());
                }
            }
        }
        return isSuccess;
    }

    public boolean deleteUserById(int id){
         Connection conn=null;
         boolean isSuccess=false;
         try{
             conn = MysqlConfig.getConnection();
             String sql="delete from users u where u.id=?";
            PreparedStatement statement=conn.prepareStatement(sql);
            statement.setInt(1,id);
            isSuccess= statement.executeUpdate()>0;
         }catch(Exception e){
             System.out.println("Loi deleteUserById:"+e.getMessage());
         }finally {
             if(conn!=null){
                 try{
                     conn.close();
                 }catch(Exception e)
                 {
                     System.out.println("Loi dong ket noi deleteUserById:"+e.getMessage());
                 }
             }
         }
        return isSuccess;
    }
    public boolean updateUser(String fullname, String email, int roleId, String password, int id) {
        Connection conn = null;
        boolean isSuccess = false;

        try {
            conn = MysqlConfig.getConnection();
            String sql = "UPDATE users SET email=?, fullname=?,password=?, role_id=? WHERE id=?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, email);
            statement.setString(2, fullname);

            statement.setString(3, password);
            statement.setInt(4, roleId);
            statement.setInt(5,id);

            isSuccess = statement.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("Loi updateUser: " + e.getMessage());
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (Exception e) {
                    System.out.println("Loi dong ket noi updateUser: " + e.getMessage());
                }
            }
        }

        return isSuccess;
    }


    public List<UserModel> getUserById(int id){
        Connection conn=null;
        List<UserModel> userModelList=new ArrayList<>();
        try{
            conn = MysqlConfig.getConnection();
            String sql="select * from users u where u.id=?";
            PreparedStatement statement=conn.prepareStatement(sql);
            statement.setInt(1,id);
            ResultSet resultSet= statement.executeQuery();
            while (resultSet.next()){
                UserModel userModel=new UserModel();
                userModel.setId(resultSet.getInt("id"));
                userModel.setEmail(resultSet.getString("email"));
                userModel.setFullname(resultSet.getString("fullname"));
                userModel.setRoleId(resultSet.getInt("role_id"));
                userModelList.add(userModel);
            }
        }catch(Exception e){
            System.out.println("Loi getUserById:"+e.getMessage());
        }finally {
            if(conn!=null){
                try{
                    conn.close();
                }catch(Exception e)
                {
                    System.out.println("Loi dong ket noi getUserById:"+e.getMessage());
                }
            }
        }
        return userModelList;
    }
    public List<JobModel> getJobsById(int id) {
        Connection conn = null;
        List<JobModel> jobsById = new ArrayList<>();

        try {
            conn = MysqlConfig.getConnection();
            String sql = "SELECT j.id, j.name, j.start_date, j.end_date " +
                    "FROM jobs j " +
                    "INNER JOIN tasks t ON j.id = t.job_id " +
                    "WHERE t.user_id = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                JobModel jobModel = new JobModel();
                jobModel.setId(resultSet.getInt("id"));
                jobModel.setJobName(resultSet.getString("name"));
                jobModel.setNgaybatdau(resultSet.getString("start_date"));
                jobModel.setNgayketthuc(resultSet.getString("end_date"));
                jobsById.add(jobModel);
            }
        } catch (Exception e) {
            System.out.println("Error getUserJobs: " + e.getMessage());
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (Exception e) {
                    System.out.println("Loi dong ket noi getUserJobs: " + e.getMessage());
                }
            }
        }

        return jobsById;
    }
}
