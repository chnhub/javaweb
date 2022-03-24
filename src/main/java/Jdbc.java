import java.sql.*;

public class Jdbc {
    public static void main(String[] args) throws SQLException {
    //加载驱动程序
        /*
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
        */

        /*
     Connection conn = null;
     Statement stmt = null;
     ResultSet rs = null;
     try {
        conn = JDBCUtils.getConnection();
        stmt = conn.createStatement();
        String sql = "select * from test";
        rs = stmt.executeQuery(sql);
        while (rs.next()){
            System.out.println(rs.getString("test"));
        }

     }catch (Exception e){
        e.printStackTrace();
     }finally {
         JDBCUtils.release(rs, stmt, conn);
     }*/
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        MyDataSource myDataSource = null;
        try{
//            conn = JDBCUtils.getConnection();
            myDataSource = new MyDataSource();
            conn = myDataSource.getConnection();

            String sql = "select * from test";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()){
                System.out.println(rs.getString("a")+" "+rs.getString("b")+" "+rs.getString("c"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtils.release(rs, pstmt, conn);
//            if(rs != null){
//                try{
//                    rs.close();
//                }catch (SQLException e){
//                    e.printStackTrace();
//                }
//                rs = null;
//            }
//            if(pstmt != null){
//                try{
//                    pstmt.close();
//                }catch (SQLException e){
//                    e.printStackTrace();
//                }
//                pstmt = null;
//            }
//            myDataSource.addBack(conn);
        }

   }
}