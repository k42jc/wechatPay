## 简介

微信支付相关，调用最新的统一下单接口已调通，只有获取支付二维码(主扫)

## 工程介绍

-lib存放所有的公用类/工具类/jar包配置在 
-core存放代码 mvc层次结构 引用了-lib工程 
-web用于存放页面及webservice接口 引用-core和-lib 里面并没有什么东西
-server存放配置文件 maven-webapp工程 引用-lib -core -web三个工程 项目发布时使用-server工程

## 获取支付二维码

具体逻辑在`wechatPay-core->service.WechatPayService`

## 注意事项

利用公众号的支付相关接口开发需要公众号有相应的权限，本工程只是本人之前测试获取支付二维码的简单工程，并不提供这些参数
