# 微服务中用户模块的提供者

主要用于用户管理

## 配置文件说明
- bootstrap.yml (bootstrap.properties)  
  用来在程序引导时执行，应用于更加早期配置信息读取  
  如可以使用来配置application.yml中使用到参数等
- application.yml (application.properties)  
  应用程序特有配置信息，可以用来配置后续各个模块中需使用的公共参数等。  
- bootstrap.yml 先于 application.yml 加载