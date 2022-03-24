import java.sql.*;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

public class MyConnectionWrapper extends ConnectionWrapper {
    //装饰器
    private  Connection conn;
    private  List<Connection> connList;
    public MyConnectionWrapper(Connection conn, List<Connection> connList){
        super(conn);
        this.conn = conn;
        this.connList = connList;
    }
    @Override
    public void close() throws SQLException{
        connList.add(conn);
    }
}
