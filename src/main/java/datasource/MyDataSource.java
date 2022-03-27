package datasource;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class MyDataSource implements DataSource {
    public List<Connection> connList = new ArrayList<Connection>();

    public MyDataSource(){
        for (int i =1;i<=3;i++){
            // 向集合中存入连接
            connList.add(JDBCUtils.getConnection());
        }
    }
    @Override
    public Connection getConnection() throws SQLException {
        MyConnectionWrapper connectionWrapper = new MyConnectionWrapper( connList.remove(0), connList);
        return connectionWrapper;
    }
//    public void addBack(Connection conn){
//        connList.add(conn);
//    }
    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        return null;
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        return null;
    }

    @Override
    public void setLogWriter(PrintWriter out) throws SQLException {

    }

    @Override
    public void setLoginTimeout(int seconds) throws SQLException {

    }

    @Override
    public int getLoginTimeout() throws SQLException {
        return 0;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }
}
