package repository;

import config.MysqlConfig;
import model.JobModel;
import model.UserModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class JobRepository {
    public List<JobModel> findAllJobs(){
        Connection conn = null;
        List<JobModel> jobModelList=new ArrayList<>();

        try{
            String sql="select * from jobs j ";
            PreparedStatement statement= MysqlConfig.getConnection().prepareStatement(sql);


            ResultSet resultSet = statement.executeQuery();
            //duyet tung dong du lieu resultset va luu vao list user
            while (resultSet.next()){
                JobModel jobModel=new JobModel();
                jobModel.setId(resultSet.getInt("id"));
                jobModel.setJobName(resultSet.getString("name"));
                jobModel.setNgaybatdau(resultSet.getString("start_date"));
                jobModel.setNgayketthuc(resultSet.getString("end_date"));
                jobModelList.add(jobModel);
            }
        }catch(Exception e){
            System.out.println("Error findAllJobs: "+e.getMessage());
        }finally {
            if(conn!=null){
                try{
                    conn.close();
                }catch(Exception e)
                {
                    System.out.println("Loi dong ket noi findAllJobs:"+e.getMessage());
                }
            }
        }
        return jobModelList;
    }

    public boolean insertJob(String name, String startDate, String endDate) {
        Connection conn=null;
        boolean isSuccess = false;
        try{
            conn=MysqlConfig.getConnection();
            String sql="insert into jobs(name,start_date,end_date) values(?,STR_TO_DATE(?,'%d/%m/%Y'),STR_TO_DATE(?,'%d/%m/%Y')) ";

            PreparedStatement statement= conn.prepareStatement(sql);
            statement.setString(1,name);
            statement.setString(2,startDate);
            statement.setString(3,endDate);

            isSuccess= statement.executeUpdate()>0;


        }catch (Exception e){
            System.out.println("Loi addJob:"+e.getMessage());
        }finally {
            if(conn!=null){
                try{
                    conn.close();
                }catch(Exception e)
                {
                    System.out.println("Loi dong ket noi addJob:"+e.getMessage());
                }
            }
        }
        return isSuccess;
    }
    public boolean deleteJobById(int id){
        Connection conn=null;
        boolean isSuccess=false;
        try{
            conn = MysqlConfig.getConnection();
            String sql="delete from jobs j where j.id=?";
            PreparedStatement statement=conn.prepareStatement(sql);
            statement.setInt(1,id);
            isSuccess= statement.executeUpdate()>0;
        }catch(Exception e){
            System.out.println("Loi deleteJobById:"+e.getMessage());
        }finally {
            if(conn!=null){
                try{
                    conn.close();
                }catch(Exception e)
                {
                    System.out.println("Loi dong ket noi deleteJobById:"+e.getMessage());
                }
            }
        }
        return isSuccess;
    }


}

