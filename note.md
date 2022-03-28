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