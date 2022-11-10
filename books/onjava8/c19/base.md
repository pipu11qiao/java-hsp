# 类型信息

1. 什么是RTTI
2. 有什么用
3. 反射是啥

RTTI (RunTime Type Information,运行时类型信息)把我们从只能在编译期间进行类型操作的禁锢中解脱了出来，并且可以使用某些强大的程序。
对RTTI的需要，揭示了面向对象设计中许多有趣的特性，关于如何组织程序的基本问题：

讨论Java如何在运行时识别对象和类信息的。

1. 传统的RTTI，假定我们在编译时已经知道了所有的类型
2. "反射"机制： 允许我们在运行时发现和使用类的信息

## 为什么需要RTTI

Shape
Circle Square Triangle

```java
Stream.of(new Circle(),new Square(),new Triangle())
        .forEach(Shape::draw);

```

在Java中所有类型转换的正确性检查都是在运行时进行的。在运行时，识别一个对象的类型。

在多态中使用一般都是基类，在使用具体行为是和基类打交道，派生类在使用时会向上转型，在运行时需要做类型检查。
另一方面，我们又是也需要派生类的具体类型，使用RTTI，可以查询某个派生类的具体类型。

### Class 对象

RTTI在Java中的工作原理， 首先必须知道类型信息在运行时时如何表示的。由Class对象完成。
Class对象就是用来创建该类的常规对象的。Java使用Class对象来实现RTTI.

类时程序的一部分，每个类都有一个Class对象，保存在同名的.class文件中。为了生成这个类的对象，Java虚拟机（JVM)
先会调用类加载器子系统把这个类加载到内存中。

类加载器子系统可能包含了一条加载器链，但是原生类加载器有且只有一个，是JVM实现的一部分。
所有类都是在第一次使用时动态加载到JVM中的
首先检查是否挂载，没有就加载，对其进行验证。确保她没有损坏，不包含不良java代码。

Class.forName 检测是否有这个类 参数String c19.Gum 完整的类引用地址

getName
getSimpleName
getCanonicalName
isInterface
getInterfaces
getSupperClass
newInstance

### 类字面量

Java还提供了另一种方法来生成类对象的引用： 类字面常量,"Toy.class",这样做不仅简单而且安全，因为它在编译时就会收到检查，并且它根除了对forName方法的调用，所以效率很高。

基本类型的有TYPE 标准字段

boolean.class Boolean.TYPE

注意的一点： 当使用.class来创建Class对象的引用时，不会自动初始化改Class对象。

* 加载 由类加载器完成。找到字节码，并从字节码中创建Class对象
* 链接 该阶段验证字节码，为static字段分配存储空间、并且如果需要的话，将解析这个类创建的对其他类的所有引用
* 初始化 如果该类具有超类，则初始化超类，执行static初始化器和static初始化块

知道第一次引用一个static方法或者非常量的static字段，才会进行类初始化,执行静态初始块

### 泛华的Class引用

Class引用指向某个Class对象
java引入泛型后，可以使用泛型为Class引用所指向的Class对象的类型进行限定。

```java
Class<Integer>
```

为了使用Class放松限制使用"？"

Class<?>比单纯使用Class要好，泛华的可以在编译阶段进行类型的检查

如何创建一个限定指向某种类型或其子类的Class引用，我们需要将通配符与extends关键在配合使用，创建一个范围限定。

## 类型转换监测

RTTI类型包括

1. 传统的类型转换 "(Shape)"
2. 代表对象类型的Class对象。通过查询Class对象可以获取运行时所需的信息

RTTI在Java中还有第三种形式，那就是关键在 instanceof. 返回布尔值， 判断对象是不是某个特定类型的实例，可以用提问的方式使用它

```java
if(x instanceof Dog){
    ((Dog)x).bark()
}
```

ClassCastException 

通过
Class.forName 或者字面量 .class 获得类的Class引用，我们就获得了可以自由创建需要的类型的对象实例


## 注册工厂

每当想层次结构中添加一种类型的Pet时，必须将其添加到LiteralPetCreator中。在一个定期添加更多类的系统中，这可能会成为问题。

可能会考虑向每个子类中天啊及静态初始值设定项。将其类添加到某个列表中，不幸的是，静态初始值设定项仅在首次加载类时调用，因此存在鸡和蛋的问题：生成器的列表中没有类，因此无法创建该类的对象

### 类的等价表示

instanceof 和 isInstance 返回的结果是一致的标识类的继承关系

Class 对象表示一种确切的关系，和继承没有关系。

## 反射： 运行时类信息

1. 为什么需要运行时知道类的信息
2. 什么是反射


通过反射，.class文件在编译时不可用，它由运行时环境打开并检查。

类Class支持反射的概念， java.lang.reflect 库中包含类 Field、Method和Constructor,每一个都实现了Member接口。

### 类方法提取器

Class.forName 获取class

getMethods
getContructors

### 动态代理

代理是基本的设计模式之一。一个对象封装真实对象，代替其提供其他或不同的操作--这些操作通常涉及到与"真实"对象的通信，因此代理通常充当中间对象。

Java的动态代理更进一步，不仅动态创建代理对象而且动态处理代理方法的调用。在动态代理上进行的所有调用都被重定向到单个 调用处理程序，该处理程序负责发现调用的内容并决定如何处理

可以通过Proxy.newProxyInstance()来创建动态代理，该方法需要一个类加载器(通常可以从已加载的对象中获取),希望代理实现的接口列表（不是类或抽象类），以及接口InvocationHandler的一个实现
invoke 方法。可以过滤某些方法调用，同时传递其他方法调用



## Optional 类

涉及到运行时检测，对于null的检测

Optional 最有用武之地的地方是再那些"更接近数据"的地方，在问题空间中代表实体的对象上。


Person的设计有时又叫 "数据传输对象" （DTO,data-transfer object)。所有字段都是public 和 final的，所以没有getter和setter方法。也就是说，Person是不可变的，只能通过构造器给它赋值，之后就只能读而不能修改它的值。