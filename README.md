#Spring Cloud in Action

## Introduction

This is a demo Spring Boot project which shows the use of Spring Cloud families including:

* Spring Cloud Config
* Spring Cloud Netflix
    - Eureka
    - Hystrix
    - Zuul
    - Ribbon

http://cloud.spring.io/spring-cloud-consul/

http://projects.spring.io/spring-cloud/spring-cloud.html

dubbo与spring cloud的比较
https://zhuanlan.zhihu.com/p/25450681

总结：
dubbo关注于RPC调用，关注点服务调用的管理，平台基于java技术栈，没有原生的REST；
spring cloud 基于rest 调用，关注的是微服务之间的调用管理，相关组件包括：服务注册，服务网关，服务调用链跟踪，分布式配置，断路器，消息总线等；


随着微服务数量不断增长，需要跟踪一个请求从一个微服务到下一个微服务的传播过程，Spring Cloud Sleuth 正是解决这个问题
http://www.jdon.com/dl/best/spring-cloud-sleuth.html?utm_source=tuicool&utm_medium=referral

 
    https://zhuanlan.zhihu.com/p/25141622"  Spring Cloud构建微服务架构（一）服务注册与发现 
    https://zhuanlan.zhihu.com/p/25208346" Spring Cloud构建微服务架构（二）服务消费者 
    https://zhuanlan.zhihu.com/p/25284407 Spring Cloud构建微服务架构（三）断路器 
    https://zhuanlan.zhihu.com/p/25346353 Spring Cloud构建微服务架构（四）分布式配置中心
    
    http://git.oschina.net/didispace/SpringCloud-Learning  打造Spring Cloud构建微服务架构的最全资料
    
    http://git.oschina.net/didispace/SpringBoot-Learning  Spring Boot教程与Spring Cloud教程
    
    http://blog.csdn.net/liaokailin/article/details/51470051
