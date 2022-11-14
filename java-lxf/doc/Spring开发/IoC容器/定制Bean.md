### Scope 

当我们使用@Component标记一个Bean后，它就会自动为我们创建一个单例，即容器初始化时创建Bean,容器关闭前销毁Bean.容器运行期间，我们调用getBean(Class)获取的Bean总是一个实例。
如果想要在每次获取时获得新的实例，需要添加一个@Scope注解。 这种Bean称为Prototype(原型)，

```java
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE) // @Scope("prototype")
public  class Hello{
    
}
```
### List
```java
@Component
public class Hello{
    @Autowired
    List<Validator> validators;
}
```

如果@Autowired的字段是一个List,Spring会自动把所有类型为Validator的Bean装配位一个List注入进来。 Validator 是一个接口。Spring是通过扫描所有的classpath获取到所有的Bean，而List是有序的，要指定List中Bean的顺序，可以加上@Order注解

### 可选注入

@Autowired(required=false)

### 创建第三方Bean

如果一个Bean不在我们的package管理范围之内，如何创建？

自己在@Configuration类中编写一个Java方法并返回它，注意给方法添加一共@Bean注解：

```java
@Configuration
@ComponentScan
public class AppConfig{
    @Bean
    ZoneId createZoneId(){
        return ZoneId.of("Z");
    }
}
```

### 初始化和销毁

一个Bean在注入必要的依赖后需要进行初始化（监听消息等），在容器关闭时，有时候还需要清理资源。
Spring 容器会Bean进行初始化的流程：
1. 调用构造方法创建实例
2. 更具@Autowired进行注入
3. 调用标记有@PostConstructor的方法进行初始化

Spring 只根据Annotation查找无参数方法，对方法名不做要求

### 使用别名 @Bean("name") 或 @Bean  @Qualifier("z")


@Bean("z")
@Bean("utc8")


#### primary

@Bean
@Primary
@Qualifier("z")


### 使用FactoryBean

```java
@Component
public class ZoneIdFactoryBean implements FactoryBean<ZoneId>{
    String zone = "Z";
    
    @Override
    public ZoneId getObject() throws Exception {
        return ZoneId.of(zone);
    }
    @Override
    public Class<?> getObjectType(){
        return ZoneId.class;
    }
}
```


