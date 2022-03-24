import java.sql.*;

public class Jdbc {
    public static void main(String[] args) throws SQLException {
    //加载驱动程序
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //创建连接
            //java10为数据库名
            String url="jdbc:mysql://121.41.226.246:3306/test?useSSL=false&serverTimezone=UTC";
            String username="test";
            String userpwd="wellcom";
            Connection conn = DriverManager.getConnection(url,username,userpwd);

            //创建Statement，执行sql
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery("select name,age,sex from student");
        }catch (Exception e){
            System.out.println(e);
        }


   }
}