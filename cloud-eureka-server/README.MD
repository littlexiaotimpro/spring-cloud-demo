### Spring Cloud 的服务注册中心

Eureka Server 标识为服务端

### 服务集群配置
通过配置多环境，启动多服务，服务之间相互注册

Spring Cloud 官网配置示例：

```yaml
---
spring:
  profiles: peer1
eureka:
  instance:
    hostname: peer1
  client:
    serviceUrl:
      defaultZone: https://peer2/eureka/

---
spring:
  profiles: peer2
eureka:
  instance:
    hostname: peer2
  client:
    serviceUrl:
      defaultZone: https://peer1/eureka/
```