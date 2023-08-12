package config;

import java.sql.Connection;
import java.sql.DriverManager;

public class MysqlConfig {

    public static final String url="jdbc:mysql://localhost:3306/crm_app";
    public static final String username="root";
    public static final String password="Baopro2001@";
    public static Connection getConnection(){
        Connection connection=null;
        try {
            //Chi dinh driver su dung
            Class.forName("com.mysql.cj.jdbc.Driver");
           //Tao ket noi CSDL
            connection=DriverManager.getConnection(url,username,password);
            System.out.println("connected DB");

        }catch (Exception e){
            System.out.println("Error connect to Database"+e.getMessage());
        }
        return connection;
    }
}
