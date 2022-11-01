# 函数式编程

1. 什么是函数式编程
2. 有什么意义
3. 怎么使用

使用代码以某种方式操作其他代码，只要能保证它更安全。不用从头开始编写大量代码，而是从易于理解，充分测试及可靠的现有小块开始，最后将他们组合在一起以创建新代码。
函数式编程 通过合并现有代码来生成新功能而不是从头开始编写所有内容,我们可以更快的获得更可靠的代码。
OO(object oriented 面向对象)是抽象数据，FP(functional programming，函数式编程)是抽象行为。

纯粹的函数式语言在安全方面更进一步。它加强了额外的约束，所有数据都是不可变的，设置一次，永不改变。将值传递给函数，该函数然后生成新值但从不修改自身外部的任何东西。当强制执行此操作时，任何错误都不是所谓的副作用引起的。

不可变对象和无副作用 范式解决了并发编程中最基本和最棘手的问题。

## 新旧对比

改变某些行为的方式

Strategy 接口提供了单一的approach()方法来承载函数功能。

#### 函数式接口
有且仅有一个函数式方法的接口称为函数式接口,可以使用@FunctionalInterface来作检查

#### lambda表达式

可以单独使用lambda表达式，不用预先定义接口承接。会根据lambda表达式的输入和输出，java自动添加对应的类型。

lambda表达式产生的时函数，不是类。在jvm上一切都是类，类似匿名内部类，但是具体实现原理不一样。

### 递归

1. 函数的引用怎么表示
2. 注意事项

## 方法引用

方法引用组成： 类名或对象名后面跟 ：： 方法名

## Runnable 接口

Runnable接口符合单方法接口格式，不带参数也没有返回值。

## 未绑定的方法调用
未绑定的方法是指没有关联对象的普通（非静态）方法。使用未绑定方法前，要提供对象。

普通方法需要this来执行，需要传递的第一个参数是类
java知道这种方法的第一个参数是提供类方法的对象，实例

## 构造函数引用

可以引用构造函数，::new

## 函数式接口

方法引用和Lambda表达式必须被赋值，同时编译器需要识别类型信息已确保类型正确。
传递给方法的参数类型。
java.util.function包,包含一组接口,这些接口是Lambda表达式和方引用的目标类型。
在编写接口是可以使用@FunctionInterface注解强制执行此"函数式方法"模式

使用注解后，在定义时的赋值，只是赋值了方法。

java.util.function包旨在创建一组完整的目标接口，使得我们一般情况下不需要再定义自己的接口。

1. 如果只是处理对象而非基本类型，名称则为Function Consumer,Predicate等。参数类型通过泛型添加。
2. 如果接受的是基本类型，则由名称的第一部分表示，如LongConsumer,DoubleFunction, IntPredicate,但基本Supplier类型除外
3. 如果返回值为基本类型，则用To表示，如ToLongFunction<T>和IntToLongFunction。
4. 如果返回值类型和参数类型一致，则是一个运算符， 单个参数使用UnaryOperator BinaryOperator
5. 如果接口两个参数且返回值为布尔值，则是一个谓词（Predicate)
6. 如果接口的两个参数类型不同，则名称中有一个Bi

* Runnable run
* Supplier get 功能接口代表结果的提供者 Suppiler <T> IntSupplier
* Callable call
* Consumer accept
* BiConsumer
* Obj类型Consumer
* Function
* UnaryOperator
* BinaryOperator
* Predicate
* 类型to类型Function
* Bi操作

Java Supplier是一个功能接口，代表结果的提供者。


## 多参数函数式接口

三个参数怎么解决
自定义接口

## 高阶函数

## 柯里化和部分求值

柯里化意为： 讲一个多参数的函数，转换为一系列单参数函数。