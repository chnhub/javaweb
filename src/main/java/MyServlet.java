
import javax.servlet.*;
import java.io.IOException;

public class MyServlet implements Servlet{
    /***
     * Servlet
     * @param req
     * @param servletResponse
     * @throws resp
     * @throws IOException
     */
    @Override
    public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("hello world!");
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
