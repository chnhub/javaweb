package datasource;

import java.sql.*;

public class JDBCUtils {
    private  static final String driverClassName;
    private  static final String url;
    private  static final String username;
    private  static final String password;

    static {
        driverClassName="com.mysql.cj.jdbc.Driver";
        url="jdbc:mysql://121.41.226.246:3306/java_web";
        username="dfo";
        password="wellcom";
    }
    // 注册驱动的方法
    public static void loadDriver(){
        try {
            Class.forName(driverClassName);
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    //获的连接的方法
    public  static Connection getConnection(){
        Connection conn = null;
        try{
            loadDriver();;
            conn = DriverManager.getConnection(url,username,password);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return conn;
    }
    //释放资源
    public  static void release(Statement stmt, Connection conn){
        if(stmt != null){
            try{
                stmt.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
            stmt = null;
        }
        if(conn != null){
            try{
                conn.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
            conn = null;
        }
    }
    public  static void release(ResultSet rs, Statement stmt, Connection conn){
        if(rs != null){
            try{
                rs.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
            rs = null;
        }
        if(stmt != null){
            try{
                stmt.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
            stmt = null;
        }
        if(conn != null){
            try{
                conn.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
            conn = null;
        }
    }
}
