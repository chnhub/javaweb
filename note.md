##一、技术有关
###1.数据库操作DDL等
```aidl
DDL 数据库定义语言 create、alter、drop
DML 数据库操作语言 insert、update、delete
DQL 数据库查询语言 select
DCL 数据库控制语言 grant
DPL 数据库事务处理语言
```
###2.装饰器
对类进行扩展，直接继承接口类时需要实现所有的方法，为了避免实现所有方法中间可加一层实现类，并实现所有方法，然后再继承该实现类

##二、工具有关
###1. 解决IDEA 2020.1.1 找不到程序包和符号
```aidl
解决方案：https://www.cnblogs.com/slankka/p/12964971.html
./m2下创建链接
cd %USERPROFILE%/.m2
mklink /D repository D:\.m2\repository
```

