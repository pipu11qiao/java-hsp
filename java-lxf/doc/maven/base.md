## maven 项目结构

```shell
a-maven-project
├── pom.xml
├── src
│   ├── main
│   │   ├── java
│   │   └── resources
│   └── test
│       ├── java
│       └── resources
└── target
```

**a-maven-project**是项目名
**pom.xml**项目描述文件
**src/main/java**存放java源码
**src/main/resources**存放资源文件
**src/test/java**存放测试源码
**src/test/resources**存放测试资源
**target**所有编译、打包生成的文件

### pom.xml 项目描述文件

```xml

<project>
    <modleVersion>4.0.0</modleVersion>
    <groupId>com.itranswarp.learnjava</groupId>
    <artifactId>hello</artifactId>
    <version>1.0</version>
    <packaging>jar</packaging>
    <properties>

    </properties>
    <dependencies>
        <dependency>
            <groupId>commons-logging</groupId>
            <artifactId>commons-logging</artifactId>
            <version>1.2</version>
        </dependency>
    </dependencies>
</project>
```

**groupId** 类似于java的包名
**artifactId** java的类名
**version** 版本
一个库由，groupId,artifactId,version,三个字段来作为唯一标识。
使用<dependency>声明一个依赖后，maven会自动下载这个依赖包到classpath中

# 依赖管理

### 依赖关系处理

a包依赖b包，b包依赖c，d包等等的依赖关系
例如spring-boot-starter-web依赖时

```shell
spring-boot-starter-web
spring-boot-starter
spring-boot
sprint-boot-autoconfigure
spring-boot-starter-logging
logback-classic
logback-core
slf4j-api
jcl-over-slf4j
slf4j-api
jul-to-slf4j
slf4j-api
log4j-over-slf4j
slf4j-api
spring-core
snakeyaml
spring-boot-starter-tomcat
tomcat-embed-core
tomcat-embed-el
tomcat-embed-websocket
tomcat-embed-core
jackson-databind
...
```

##### 依赖关系

maven定义集中依赖关系，分别是compile,test,runtime和provided

| scope    | 说明                      | 示例              |
|----------|-------------------------|-----------------|
| compile  | 编译时需要用到该jar包（默认）        | commons-logging |
| test     | 编译Test时需要用到的jar包        | junit           |
| runtime  | 编译时不需要，但运行时需要用到         | mysql           |
| provided | 编译时需要用到，但运行时由JDK或某个服务提供 | servlet-api     |

compile就是直接加到classpath中
test是测试时使用

runtime是运行时使用，编译时不使用。就像mysql，它是一种jdbc驱动，例如Mysql驱动。
provided 编译时需要，运行时由Servlet服务器内置了相关jar，所以运行时不需要

##### maven 中央仓库
从中央仓库下载包
本地公共缓存包
