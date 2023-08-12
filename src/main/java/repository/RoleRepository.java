package repository;

import config.MysqlConfig;
import model.RoleModel;
import model.UserModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RoleRepository {
   public List<RoleModel> findAll(){
       Connection conn=null;
       List<RoleModel> roleModelList=new ArrayList<>();

       try{
           String sql="select * from roles r ";
           PreparedStatement statement= MysqlConfig.getConnection().prepareStatement(sql);


           ResultSet resultSet=statement.executeQuery();
           //duyet tung dong du lieu resultset va luu vao list user
           while (resultSet.next()){
               RoleModel roleModel=new RoleModel();
               roleModel.setId(resultSet.getInt("id"));
               roleModel.setName(resultSet.getString("name"));
               roleModel.setDesc(resultSet.getString("description"));

               roleModelList.add(roleModel);

           }
       }catch(Exception e){
           System.out.println("Error findAllRoles: "+e.getMessage());
       }finally {
           if(conn!=null){
               try{
                   conn.close();
               }catch(Exception e)
               {
                   System.out.println("Loi dong ket noi findAllRoles:"+e.getMessage());
               }
           }
       }
       return roleModelList;
   }

    public boolean insertRole(String name,String  desc){
        Connection conn=null;
        boolean isSuccess = false;
        try{
            conn=MysqlConfig.getConnection();
            String sql="insert into roles(name,description) values(?,?) ";
            PreparedStatement statement= conn.prepareStatement(sql);
            statement.setString(1,name);
            statement.setString(2,desc);


            isSuccess= statement.executeUpdate()>0;


        }catch (Exception e){
            System.out.println("Loi addRole:"+e.getMessage());
        }finally {
            if(conn!=null){
                try{
                    conn.close();
                }catch(Exception e)
                {
                    System.out.println("Loi dong ket noi addRole:"+e.getMessage());
                }
            }
        }
        return isSuccess;
    }

    public boolean deleteRoleById(int id) {
        Connection conn=null;
        boolean isSuccess=false;
        try{
            conn = MysqlConfig.getConnection();
            String sql="delete from roles r where r.id=?";
            PreparedStatement statement=conn.prepareStatement(sql);
            statement.setInt(1,id);
            isSuccess= statement.executeUpdate()>0;
        }catch(Exception e){
            System.out.println("Loi deleteRoleById:"+e.getMessage());
        }finally {
            if(conn!=null){
                try{
                    conn.close();
                }catch(Exception e)
                {
                    System.out.println("Loi dong ket noi deleteRoleById:"+e.getMessage());
                }
            }
        }
        return isSuccess;
    }
}
