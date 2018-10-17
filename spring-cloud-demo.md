配置说明
一、注册中心(eureka-server)
1.依赖
  spring-cloud-starter-netflix-eureka-server 
2.配置
  registerWithEureka=false，避免注册自己
  启动类注解@EnableEurekaServer
  
二.服务provider(eureka-client)
1.依赖
    spring-cloud-starter-netflix-eureka-client
2.配置
    1)配置中心地址,端口,服务（实例）
    2）启动类配置@EnableEurekaClient
    
三、负载均衡
feign：
1）依赖
    spring-cloud-starter-netflix-eureka-client
    spring-cloud-starter-openfeign
2）配置
    @EnableEurekaClient
    @EnableDiscoveryClient
    @EnableFeignClients
    注册中心实例
    配置应用服务转发
ribbon：
1）依赖
    spring-cloud-starter-netflix-eureka-client
    spring-cloud-starter-ribbon
2)配置
    @EnableDiscoveryClient
    @EnableEurekaClient
    注册中心实例
    restTemplate 转发请求
    
四、熔断服务(hystrix)
1.依赖
    spring-cloud-starter-netflix-hystrix
2.配置（见ribbon的demo）
    @EnableHystrix启动熔断服务
    @HystrixCommand(fallbackMethod = "hiError") 实现熔断接口
    
五.网关（zuul）
1.依赖
    spring-cloud-starter-netflix-eureka-client
    spring-cloud-starter-netflix-zuul
    @EnableZuulProxy
    @EnableEurekaClient
    @EnableDiscoveryClient
    注册中心实例
    
六、consul（服务注册与发现）
    注册中心需安装consul包，支持多数据中心,demo使用本地单实例注册中心
    [provider]
    spring-cloud-starter-consul-discovery
    spring-boot-starter-actuator
    配置注册中心（见consulservice）
    [provider]
    spring-cloud-starter-consul-discovery
    spring-boot-starter-actuator
    spring-cloud-starter-openfeign
    配置注册中心（见consul-consumer）
    配置feign转发请求
        
    

