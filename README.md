##简介

微信支付相关，调用最新的统一下单接口已调通，包含扫码支付和公众号支付

##工程介绍

maven项目，parent为pom格式工程，另外几个工程的父级工程
>之前的博客项目都是一个maven simple project解决，没有利用好maven的优势所在。所以趁这个项目好好的了解了一下maven module相关的知识，发现果然很强大，并且十分方便

-lib存放所有的公用类/工具类/jar包配置在 
-core存放代码 mvc层次结构 引用了-lib工程 
-web用于存放页面及webservice接口 引用-core和-lib 里面并没有什么东西
-server存放配置文件 maven-webapp工程 引用-lib -core -web三个工程 项目发布时使用-server工程

##发布启动
###直接发布(需要maven环境)
cmd命令行下进入-parent下执行：
```bash
mvn clean install
```
进入-webserver下，执行：
```bash
mvn -Djetty.port=9999 jetty:run
```
即可使用jetty启动项目
###elcipse下(需有maven插件)
导入maven项目->配置tomcat->将-server发布到tomcat->启动tomcat
