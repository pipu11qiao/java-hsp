在java程序中，我们经常会读取配置文件，资源文件等。使用Spring容器时，也可以吧"文件"注入进来，方便程序读取。

@PropertySource 来自动读取配置文件。我们只需要在@Configuration配置类在添加一个注解：

```java
@PropertySource("app.properties")
public class AppConig{
    @Value("${app.zone:Z}")
    String zoneId;
    
    @Bean
    ZoneId createZoneId(){
        return ZoneId.of(zoneId);
    }
}
```

Spring 看到@PropertySource("app.properties)注解后，自动读取这个配置文件，然后，我们使用@Value正常注入

@Value("${app.zone:Z}")


注入的字符串语法：

* "${app.zone}" 读取对应的值，不存在启动报错。
* "${app.zone:Z}" 读取对应的值，不存在就使用默认值z

引用其它ben的配置

@Value("#{bean.property}")