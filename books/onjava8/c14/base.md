# 流式编程
1. 什么是
2. 意义
3. 实现

集合优化了对象的存储，而流和对象的处理有关

利用流，我们无需迭代集合中的元素，就可以提取和操作他们。
流的一个核心好处是，它使得程序更加短小并且易于理解。当Lambda表达式和方法引用和流一起使用的时候会让人感觉自成一体。
```java
Random(47) // 47 是一个种子，再次运行时产生相同的结果
```
ints()方法产生一个流并且ints()方法有多重方式的重载--两个参数限定了数值产生的边界。

流可以在不使用赋值或可变数据的情况下对有状态的系统建模，这非常有用。
声明式编程是一种声明要做什么，而非怎么做的编程风格。 命令式编程的形式更难以理解。


在Randoms.java中，我们无需定义任何变量。

在Random.java中，代码只是告诉你正在做什么。这种语义清晰性也是Java8的流式变成更受推崇的重要原因。

在ImperativeRandoms.java中显式的编写迭代机制称为外部迭代。而在Randoms.java中，流式鞭策会给你采用内部迭代，这是流式编程的核心特性之一。这种机制使得编写的代码可读性更强，也能更多的利用多和处理器的优势。通过放弃对迭代的控制，我们吧控制权交给并行化机制。

另一个重要的方面。流式懒加载的。这代表着他只有在绝对必要是才会计算。可以将流看作是 延迟列表。由于计算延迟，流使我们能够表示非常大（甚至是无限）的序列，而不需要考虑内存问题。

## 流支持

现存的大量类库不仅被Java所用，也被Java生态圈数百万行的代码中。如何将全新的流的概念融入到现有类库中呢？

类部分可以通过添加新的方法，可是接口部分如果添加了新的方法，会破坏已经实现了接口的类。

### 解决
java8采用 在接口中添加被 default修饰的方法。 通过这种方案，设计者们可以将流式方法平滑地嵌入到现有类中。流方法预置的操作几乎满足了我们平常所有的需求。
流操作的类型有三种： 创建流、修改流元素（中间操作 Intermediate Operations), 消费元素（终端操作 Terminal Operations)。最后一种类型通常意味着收集流元素（通常是集合中）。

* 流创建
* 流修改
* 流消费

### 流创建

1. Stream.of() 将一组元素转化成为流
2. 每个集合都可以通过stream()方法来产生一个流。



map 中间操作，获取每个元素。
为了从Map集合中产生数据流，首先调用entrySet()产生一个对象流，每个对象包含key和value两个属性，调用getKey和个Value

3. 随机数据流
rand
* ints() longs doubles 传入参数可以控制上下限

boxed()流操作会自动地把基本类型包装成为对对应的装箱类型。

4. IntStream 类提供了 range()方法用于生成整型的序列的流。编写循环时，这个方法更加便利。

```java
System.getProperty("user.dir");//获取当前执行路径
```

5. Stream.generate() 搭配 Supplier<T> 来创造流

6. Stream.iterate() 以种子第一个参数开头，并将其传给方法第二个参数。 方法的结果将添加到流，并存储作为第一个参数用于下次调用。

7.  流的建造者模式 Stream.Builder

```java
Stream.Builder<String> builder = Stream.builder();
builder.add()
builder.build()
```
8. Arrays Arrays.stream

9. 正则表达式 Patter.compile("\\w+").splitAsStream(str);

## 中间操作

中间操作用于从一个流中获取对象，并将对象作为另一个流从后端输出，已连接到其他操作

1. peek()跟踪和调试

操作的目的是帮助测试，它允许你无修改的查看流中的元素。
pee符合付返回值的Consumer函数式接口，所以我们只能观察，无法使用不同的元素来替换流中的对象

2. sorted 流元素排序

sorted() 默认比较器  Comparator参数，也可以传入lambda函数

3. 移除元素

* distinct() 消除流中的重复元素
* filter(Predicate):过滤操作会保留与传递进去的过滤器函数计算结果为true的元素

4. 应用函数到元素

* map(Function) 将函数操作应用在输入流的元素中，并将返回值传递到输出流中
* mapToInt(ToIntFunction) 操作同上，但结果是IntStream
* mapToLong 
* mapToDubble

5. 在map() 中组合流
解决： 用产生流的函数得到一个元素流
flatMap()做了两件事，将产生流的函数应用在每个元素上（与map（）所做的相同），然后将每个流都扁平化为元素，因而最终产生的仅仅是元素。

concat()以参数顺序组合两个流。


## Optional 类

如果在一个空流中获取元素会发生什么
是否有某种对象，可作为流元素的持有者，即使查看的元素不存在也能友好的提示我们（也就是说，不会发生异常）

Optional 一些标准流返回Optional对象，因为它们并不能保证预期结果一定存在：

* findFirst() 返回一个包含第一个元素的Optional对象
* findAny
* min max
* reduce
* average

通过Stream.empty() 创建空流。该方法需要上下文来获取类型，或者显示指定类型
Stream.<String>empty()

## 便利函数


## 终端操作

### 数组
* toArray() 将流转成适当的数组
* toArray(generator) 再特殊情况下，生成自定义类型的数组

## 循环

forEach(Consumer) 无序
forEachOrdered(Consumer) 有序

## 集合

* collect(Collector)
* collect(Supplier,BiConsumer,BiConsumer) 

## 组合

* reduce

## 匹配

## 查找

## 信息

## 数字流信息

