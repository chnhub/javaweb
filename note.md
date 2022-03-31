##一、技术有关
###1.数据库操作DDL等
```
DDL 数据库定义语言 create、alter、drop
DML 数据库操作语言 insert、update、delete
DQL 数据库查询语言 select
DCL 数据库控制语言 grant
DPL 数据库事务处理语言
```
###2.装饰器
对类进行扩展，直接继承接口类时需要实现所有的方法，为了避免实现所有方法中间可加一层实现类，并实现所有方法，然后再继承该实现类
###3.连接池
1.DruidDataSource连接池    
2.C3P0连接池   
###4.Servlet
基于javax.servlet.Servlet     
- **基本的实现关系**  
```
Servlet 接口
    |
GenericServlet类     通用的Servlet，是一个与协议无关的Servlet
    |
HttpServlet类        http专用的Servlet
一般编写一个Servlet继承HttpServlet重写service方法
继承了HttpServlet之后就不需要重写service方法，秩序重写doGet和doPost方法即可
doGet和doPost相互调用，可简化代码 doPost(req,resp)
```
- **生命周期**
``` 
servlet冲创建到销毁的过程
servlet中有init,service,destory方法，生命周期相关方法
    servlet是在第一次被访问的时候会被实例化，只要servlet一被实例化那么servlet中的serice方法就会执行（init指挥执行一次）
    任何客户端发送来的请求，那么servlet中的service 方法就会执行。
    当servlet从服务器中移除或者服务器关闭的时候servlet对象被销毁，里面的destory方法就会执行，然后垃圾回收就会将其回收掉

```
- **启动时加载**
``` 
第一次访问时初始化耗时较长，需启动时加载
    <servlet>
        <servlet-name>LifeServlet</servlet-name>
        <servlet-class>LifeServlet</servlet-class>
        <!--        启动时加载-->
        <load-on-startup>2</load-on-startup>
    </servlet>
```
- **url-pattern 路径匹配**
``` 
完全路径： /ServletDemo
目录匹配： /aaa/*
扩展名：   *.abc
优先级：完全路径匹配 > 目录匹配 > 扩展名匹配
```
- **servletconfig配置参数**
``` 
1.获得servletconfig对象
ServletConfig config = this.getServletConfig();
String username = config.getInitParameter("username");
String password = config.getInitParameter("password");
2.获得所有参数的名称
Enumeration<String> names = config.getInitParameterNames();
3.获得servlet名称
config.getServletName();
```

###5.HTTP
http协议：规定了浏览器和服务端的数据交互的方式   
特性：  
基于请求和响应模型   
1. 必须要先请求，后响应
2. 请求和响应必须承兑出现

简单快捷
因为请求时仅需要发送请求方式和请求路径     
>版本：     
- http1.0     
- http2.0
###6.web.xml配置
```
    <servlet>
            <servlet-name>MyServlet</servlet-name>
            <servlet-class>MyServlet</servlet-class>
    </servlet>
    <servlet-mapping>
        <servlet-name>MyServlet</servlet-name>
        <url-pattern>/servlet</url-pattern>
    </servlet-mapping>
```
###7.Response
``` 
1. 设置状态码 setState
    1xx 信息状态码
    2xx 成功状态码
    3xx 重定向状态码
    4xx 客户端错误
    5xx 服务器错误
2. 设置响应头 setHeader、addHeader
    setHeader("content-Type","text/plain")赋值
    addHeader("content-Type","text/plain")追加
3. 设置响应体 getOutputStream()字节流、getWriter()字符流
    重定向 sendRedirect
    浏览器字符集  setContentType
    字符流缓存区字符集 setCharacterEncoding
4. 字节流和字符流返回中文
    字符流 getOutputStream().write() 可能乱码
        与中文转成字节数组及浏览器打开方式（打开采用的默认字符集）有关
            中文转字节数据时与浏览器打开时一致
    字节流 getWriter().println() 一定乱码
        response设计默认缓冲区编码为ISO-8859-1，这个字符集是不支持中文的
            设置缓冲区的编码
```
###8.Request
``` 
1. 获得请求方式 getMethod()
2. 获得路径参数 getQueryString()
3. 客户机IP地址 getRemoteAddr()
4. URL和URI getRequestURL() getRequestURI()
5. 浏览器类型 getHeader("User-Agent")
6. 表单参数 getParameter("username") getParameterValues("");
post请求乱码 request会把数据放入缓存区，缓存区默认编码不支持中文
get请求url乱码，url中中文被转码（ISO-8859-1）存入缓存区
    先转iso-8895再转utf-8
...
```
###9.会话
``` 
什么是会话：
    用户打开浏览器，点击超链接访问服务器web资源，然后关闭浏览器，整个过程为一次会话

Cookie：
    客户端技术
！！！cookie中不允许存在空格
    Cookie的分类：
        默认级别：关闭浏览器cookie销毁，保存再浏览器内存中
        持久级别：有效时间的cookie，保存到硬盘上
    API:
        获取cookie: new Cookie(key, value)
        获得名称：getname()
        获得值：getvalue()
        设置域名：setDomain()
        设置路径：setpath()
        设置有效期：setMaxAge()
    细节：
        cookie大小和个数是有限制的，浏览器一般存放300个，每个站点20个，每个cookie4kb
        默认为会话级别cookie，退出浏览器删除
        手动删除cookie，有效时长设为0即可
Session:
    服务端技术，服务器为每个用户创建独享的session对象，
    将数据保存到服务器端，一个浏览器独占一个session对象
    为什么用session :  
        session没有大小和个数限制
        数据是保存到服务器上
    API:
        获得session：getSession()
        设置数据：setAttribute(name, value)
        获取数据：getAttribute(name)
    原理：
        基于cookie
    作用范围:
        一次会话（浏览器从打开到关闭的过程）
    请求范围：
        创建：客户端发送一次请求，服务端创建一个request对象
        销毁：服务端响应客户端请求后
        存取：setAttribute() getAttribute()
        范围：一次请求（转发一次请求，重定向两次）
    会话范围：
        创建：服务器端第一次调用getSeesion()
        销毁：1.session过期（默认30min）2.非正常关闭服务器 3.手动调用invalidate()
        存取：setAttribute() getAttribute()
        范围：一次会话的范围
    应用范围：
        创建：服务器创建的时候
        销毁：服务器关闭的时，或移除时
        存取：同上
        范围：整个应用的范围
```

##二、工具有关
###1. 解决IDEA 2020.1.1 找不到程序包和符号
```
解决方案：https://www.cnblogs.com/slankka/p/12964971.html
./m2下创建链接
cd %USERPROFILE%/.m2
mklink /D repository D:\.m2\repository
```
###2. IDEA启动tomcat jsp程序报错”“
Cannot start compilation: the output path is not specified for module "Test". Specify the out   
设置project complie out的文件夹一般为项目\out
###3.IDEA配置JSP web项目
``` 
多模块时：
Project Structure:
1.配置Project complier output，一般为project\out
2.配置Modules，添加modul，moule下添加freamwork - web
3.配置Artifacts，添加Web Application Archive(A)后，再添加Web Application Artifacts from A。配置后才可jsp文件中右键run
4.配置Tomcat，注意Deployment下的application context的访问路径配置
```
###4.jsp项目报错“java: Compilation failed: internal java compiler error”
```
idea - setting - java complier设置Java1.8
```
###5.jsp项目启动后找不到index.jsp
``` 
删除Project Structure下的lib依赖
```