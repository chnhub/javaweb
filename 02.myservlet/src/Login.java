import com.alibaba.fastjson.JSONObject;
import vo.LoginVo;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.BufferedReader;
import java.io.IOException;

public class Login extends HttpServlet {
    private LoginVo loginVo;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        loginVo = new LoginVo();
        BufferedReader reader = req.getReader();
        StringBuilder sb = new StringBuilder();
        String line = null;
        while ((line = reader.readLine())!=null){
            sb.append(line);
        }
        JSONObject jsonObject = JSONObject.parseObject(sb.toString());
        loginVo.setUsername(jsonObject.get("username").toString());
        loginVo.setPassword(jsonObject.get("password").toString());
        resp.setContentType("application/json;charset=utf-8");

        System.out.println("test-----------"+loginVo.toString());
        if ("test".equals(loginVo.username)&&"test".equals(loginVo.password)){
            HttpSession session = req.getSession();
            session.setAttribute("token",loginVo.username);
            resp.getWriter().println("{\"code\":200, \"msg\":\"登录成功\", \"success\":true}");
        }else{
            resp.getWriter().println("{\"code\":24001, \"msg\":\"登录失败\", \"success\":false}");

        }

    }
}
