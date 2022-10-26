

## maven 项目结构

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