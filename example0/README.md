# 初始化

本项目使用

- `Java 17`
- `maven 3.9.4`

在 `example0` 中，主要完成下面的目标

- `example0` 作为 `maven` 项目
  - 维护 `pom.xml` ，用于项目下的版本控制
    - [maven | parent](https://benpaodewoniu.github.io/2023/10/11/maven11/)
- `example0/cbim` 为 `spring boot` 项目
  - 为整个项目的入口程序
    - [spring boot | 在 IDEA 中创建 spring boot 项目](https://benpaodewoniu.github.io/2021/07/18/spring1/)
- `example/flow` 为 `maven` 项目

# 环境安装

这里不再详细说明环境和项目怎么导入和安装，如果不懂请参考

- [maven | IDEA 配置 maven 项目环境](https://benpaodewoniu.github.io/2021/06/29/maven1/)

# 测试

启动 cbim 中的 spring boot 程序，出现下述字样，即成功

```
success

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::      (v2.7.17-SNAPSHOT)

2023-10-17 21:42:49.231  INFO 10288 --- [           main] com.cbim.cbim.CbimApplication            : Starting CbimApplication using Java 17.0.8 on S3 with PID 10288 (D:\JAVA\Code\CBIM\example0\cbim\target\classes started by Administrator in D:\JAVA\Code\CBIM)
2023-10-17 21:42:49.236  INFO 10288 --- [           main] com.cbim.cbim.CbimApplication            : No active profile set, falling back to 1 default profile: "default"
2023-10-17 21:42:50.011  INFO 10288 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 8080 (http)
```