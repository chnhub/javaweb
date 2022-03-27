import javax.servlet.*;
import java.io.IOException;

public class LifeServlet implements Servlet {
    /***
     * servlet对象被实例化时init方法就会被执行，且只执行一次
     * @param servletConfig
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("servlet初始化了");

    }
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("servlet执行了");
    }
    @Override
    public void destroy() {
        System.out.println("servlet销毁了");
    }
    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public String getServletInfo() {
        return null;
    }


}
