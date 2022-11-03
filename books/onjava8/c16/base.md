# 代码校验

你永远不能保证你的代码是正确的，你只能证明它是错的

## 测试

## 如果没有测试过，它就是不能工作的。

Java是一个静态类型的语言，静态类型的检查是一种非常局限性的测试。只是说明编译器接受你代码中的语法和基本类型规则。创建测试，并基于你的目标检查带代码的行为。

### 单元测试

讲集成测试构建到你创建的所有代码中，并在每次构建系统时运行这些测试。
单元测试对应系统测试

## JUnit

@BeforeAll 注解是再任何其他测试操作之前运行一次的方法，@afterAll是之后 ，都必须是静态的

@BeforeEach 通常用来创建和初始化公共对象的方法，可以将这样的方法放在测试类的构造函数中。@BeforeEach和构造的唯一区别是@BeforeEach是在测试前调用

@AfterEach 关闭清理 网络连接 文件 


### 测试覆盖率的幻觉

测试覆盖率的多少是基于需要测试的东西，不是越高就越好。

### 前置条件

前置条件的概念来自于（Design By Contract, DbC)。

#### 断言 Assertions

断言通过验证在程序执行期间满足某些条件，从而增加了程序的健壮性。确保程序正确的重要测试，他们不能再编译时被检查，不属于单元测试的范围。

#### Java语言断言

assert boolean-expression;
assert boolean-expression:information-expression;

我断言这个布尔表达式会产生true，否则，抛出AssertionError
AssertionError是Throwable的派生类，因此不需要异常说明。

##### 断言的使用方式 
* -ea 类加载器对象
* ClassLoader setDefaultAssertionStatus

第一中断言不会生成包含布尔表达式的任何信息。

需要给jvm添加-ea参数开启断言，会接受到AssertionError的异常

information-expression 将生成一条有用的消息作为异常堆栈跟踪的一部分。

#### Guava断言

因为启用本地断言很麻烦

Guava 团队添加一个始终启用的Verify类，静态导入Verify犯法

### 使用断言进行契约设计

DBC 是Eiffel语言发明者 Bertrand Meyer提出的一个概念，通过确保对象遵循默写规则来帮助创建健壮的程序。
dbc假定服务供应者与该服务的消费者或客户之间存在明确制定的契约。

1. 应该明确制定行为，就好像它是一个契约一样
2. 通过实现某些运行时检查来保证这种行为，他将这些检查成为前置条件后置条件和不变相

