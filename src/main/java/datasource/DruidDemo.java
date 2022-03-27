package datasource;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.jupiter.api.Test;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class DruidDemo {
    @Test
    public void testServlet(){

    }

    @Test
    public void test2() throws Exception {

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

//        DruidDataSource dataSource = new DruidDataSource();
//        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
//        dataSource.setUrl("jdbc:mysql://121.41.226.246:3306/java_web");
//        dataSource.setUsername("dfo");
//        dataSource.setPassword("wellcom");
        Properties properties = new Properties();
        properties.load(new FileInputStream("src/druid.properties"));
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
        conn =dataSource.getConnection();
        String sql = "select * from test";
        pstmt = conn.prepareStatement(sql);

        rs = pstmt.executeQuery();
        while (rs.next()){
            System.out.println(rs.getString("a")+" "+rs.getString("b")+" "+rs.getString("c"));
        }

    }
    @Test
    public void test1() throws SQLException {

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        System.out.println("hello world");
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://121.41.226.246:3306/java_web");
        dataSource.setUsername("dfo");
        dataSource.setPassword("wellcom");

        conn =dataSource.getConnection();
        String sql = "select * from test";
        pstmt = conn.prepareStatement(sql);

        rs = pstmt.executeQuery();
        while (rs.next()){
            System.out.println(rs.getString("a")+" "+rs.getString("b")+" "+rs.getString("c"));
        }

    }
}
