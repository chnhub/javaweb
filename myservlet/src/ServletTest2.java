import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

public class ServletTest2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        ServletConfig config = this.getServletConfig();
        String username = config.getInitParameter("username");
        String password = config.getInitParameter("password");
        System.out.println(username + "测试 " + password);
        Enumeration<String> names = config.getInitParameterNames();
        List<Map> result = new ArrayList<Map>();
        while (names.hasMoreElements()){
            String name = names.nextElement();
            String value = config.getInitParameter(name);
            Map<String, String> map = new HashMap<>();
            map.put(name, value);
            result.add(map);
        }

//        resp.getWriter().println(username + "" + password);
        resp.getWriter().println(result.toString());
    }
}
