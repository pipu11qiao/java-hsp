# 多态

1. 什么是多态
2. 有啥意义
3. 怎么实现

多态是面向对象语言中，继数据抽象和继承之外的第三个重要特性。

多态提供了另一个纬度的接口与实现分离，以解耦作什么和怎么做。多态不近能改善代码的组织，提高代码的可读性，而且能创建有扩展的程序--无论在最初创建项目时还是在添加新特性时都可以"生长"的程序。
多态方法调用允许一种类型表现出与相似类型的区别，只要这些类型派生自一个类型。这种却别是当你通过基类调用时，由方法的不同行为表先出来。

多态也称为 动态绑定 后期绑定 运行时绑定

### 忘掉对象类型

忘掉派生类，只和基类的方法打交道

## 转机

### 方法调用绑定

将一个方法调用恶化一个方法主题关联起来称作绑定。若绑定发生在程序运行前，叫做前期绑定
js中的biand call apply

动态绑定和运行时绑定。和类型有关
Java中除了staic和final方法，其他所有方法都是后期绑定。
为了设计而是用final而不是性能使用final

### 产生正确的行为

编写只与基类打交道的代码


### 可扩展性


#### 陷阱私有方法
#### 陷阱属性和静态方法

## 构造器和多态

### 清理工作 
dispose方法 ，并且调用基类的dispose方法

## 
构造器方法中，先调用基类的方法，该方法反问了上下文的属性，该属性在后续修改。此时调用时的属性

### 协变返回类型


## 使用继承设计

利用已有的的类创建新类首先选择继承的话，事情会变得莫名的复杂。
更好的方法是选择组合。

## 替代和扩展

### 向下转型

检测类型

