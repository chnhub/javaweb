import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class VisitServlet extends HttpServlet {
    public boolean ifFirst(Cookie[] cookies) {
        if (cookies == null || (cookies.length <= 0)) {
            return true;
        }
        for (Cookie cookie : cookies) {
            if (!"time".equals(cookie.getName())) {
                return true;
            }
        }
        return false;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        resp.setContentType("text/html;charset=UTF-8");
        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd.HH:mm:ss");
        System.out.println(date.format(new Date()));
        Cookie cookie = new Cookie("time",date.format(new Date()));
        resp.addCookie(cookie);
        if(ifFirst(cookies)){
//        Cookie cookie = new Cookie("time",String.valueOf(new Date().getTime()));
            resp.getWriter().println("<h2>欢迎第一次访问<h2>");
        }else{

//            SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd.HH:mm:ss");
//            System.out.println(date.format(new Date()));
//            Cookie cookie = new Cookie("time",date.format(new Date()));
////        Cookie cookie = new Cookie("time",String.valueOf(new Date().getTime()));
//            resp.addCookie(cookie);
            String lastTime = null;
            for (Cookie cookieReq: req.getCookies()) {
                if(cookieReq!=null&&"time".equals(cookieReq.getName())){
                    lastTime = cookieReq.getValue();
                }
            }
            resp.getWriter().println(lastTime);
        }

    }
}
