# springCloud的简单示例程序

- github地址：[springCloud](https://github.com/huanyingtoyou/springcloud)
- 使用时，先启动服务注册中心eureka-registry-center里的EurekaRegistryCenterApplication
- 这时可以访问：[localhost:8081](http://localhost:8081)，这是服务注册中心的控制台，在这里可以看到服务的注册情况
- 再启动service-impl里的ServiceImplApplication
- 最后再启动test-web里的TestWebApplication
- 访问：[localhost:8088/hello/helloWorld?name=lihy](http://localhost:8088/hello/helloWorld?name=lihy)
- 集成了swaggerUI，访问：[localhost:8088/swagger/index.html](http://localhost:8088/swagger/index.html)
- hystrix监控界面，访问：[hystrix监控界面](http://localhost:8088/hystrix)，点击链接进入hystrix dashboard界面，在该界面中输入http://localhost:8088/hystrix.stream 即可看到监控服务。
- 新增zuul路由功能，访问[localhost:8088/api-a/hello/helloWorld?name=lihy](http://localhost:8088/api-a/hello/helloWorld?name=lihy)同样能进入[localhost:8088/hello/helloWorld?name=lihy](http://localhost:8088/hello/helloWorld?name=lihy)