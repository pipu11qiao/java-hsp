# 注解

注解是放在Java源码的类、方法、字段、参数前的一种特殊"注释":

```java

@Resource("hello")
public class Hello {
    @Inject
    int n;

    @PostConstruct
    public void hello(@Param String name) {
        System.out.println(name);
    }

    @Override
    public String toString() {
        return "Hello";
    }
}
```

注释会被编译器直接忽略，注解则可以被编译器打包进入class文件，因此，注解是一种用作标注的"元数据"

## 注解的作用

从JVM的角度看，注解本身队代码逻辑没有影响，如何使用注解完全由工具决定。

注解分为三类：

1. 由编译器使用的注解

@Override: 覆写
@SuppressWarnings: 忽略警告

不会被编译进入.class文件，在编译后就被编译器扔掉了。

2. 工具处理.class文件使用的注解，有些工具会在加载class的时候，对class做动态修改。这类注解会被编译进入.class文件，但加载结束后不会存在于内存中。这类注解只被一些底层库使用，一般我们不必自己处理。
3. 程序运行期间能读取的注解，它们在加载后一致存在于JVM中，这也是最常用的注解。

定义一个注解时，还可以定义配置参数。配置参数可以包括：

* 所有基本类型
* String
* 枚举类型
* 基本类型、String、Class以及枚举的数组。

```java
public class Hello {
    @Check(min = 0, max = 100, value = 55)
    public init n;

    @Check(value = 99)
    public int p;

    @Check(99) // @Check(value=99)
    public int x;

    @Check
    public int y;
}
```

# 定义注解

使用@interface语法来定义注解

```java
public @interface Report {
    int type() default 0;

    String level() default "info";

    String value() default "";
}
```

注解的参数类似无参数方法，可以用default设定一个默认值

### 元注解

有一些注解可以修饰其他注解，称为元注解（meta annotation)。

#### @Target

使用@Target可以定义annotation能够被应用于源码的哪些位置：

* 类或接口： ElementType.TYPE;
* 字段：ElementType.FIELD;
* 方法 ElementType.METHOD;
* 构造方法 ElementType.CONSTRUCTOR;
* 方法参数 ElementType.PARAMETER;

定义一个可用在方法上的注解

```java

@Target(ElementType.METHOD)
public @interface Report {
    int type() default 0;
}
```

可用在方法和字段上

```java

@Target({
        ElementType.METHOD,
        ElementType.FIELD
})
public @interface Report {
    int type() default 0;
}
```

@Target的value是一个ElementType[]，只有一个时可以省略数组的写法

#### @Retention

@retention 定义了annotation的声明周期

* 仅编译器 RetentionPolicy.SOURCE;
* 仅class文件 RetentionPolicy.CLASS;
* 运行期 RetentionPolicy.RUNTIME

如果@Retention不存在，则改Annotation默认为CLASS。因为我们通常自定义的Annotation都是RUNTIME,@Retention(
RetentionPolicy.RUNTIME)

#### @Repeatable 是否可以重复

```java

@Report(type = 1, level = "debug")
@Report(type = 2, level = "warning")
public class Hello {

}
```

#### @Inherited
使用@Inherited定义子类是否可继承父类定义的Annotation。@Inherited仅针对@Target(Element.TYPE)类型的annotation有效，并且仅针对class的继承


## 如何定义Annotation

1. 用@interface定义注解
2. 添加参数默认值
3. 用元注解配置注解

# 处理注解

三种类型的注解，SOURCE类型的注解不需要定义只使用，CLASS类型的注解主要有底层工具库使用，涉及到class的加载。只有RUNTIME类型的注解不但要使用，还经常需要编写。

注解定义后也是一种class，继承自 java.lang.annotation.Annotation 因此，读取注解，需要使用反射API。

java提供的使用反射API读取Annotation的方法包括：

的判断某个注解是否存在于Class、Field、Method或Constructor:

* Class.isAnnotationPresent(Class)
* Field.isAnnotationPresent(Class)
* Method.isAnnotationPresent(Class)
* Constructor.isAnnotationPresent(Class)

```java
Person.class.isAnnotationPresent(Report.class);
```

使用反射API读取Annotation:

* Class.getAnnotation(Class)
* Field.getAnnotation(Class)
* Method.getAnnotation(Class)
* Constructor.getAnnotation(Class)

```java

Report report = Person.class.getAnnotation(Report.class);
int type = report.type();
String level = report.level();

```


