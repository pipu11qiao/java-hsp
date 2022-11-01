# 内部类
1. 什么是内部类
2. 有什么作用
3. 怎么使用

内部类是非常有用的特性，以为它允许你把一些逻辑相关的类组织在一起，并控制位于内部的类的可见性。

## 创建内部类

把类定义在外围类里面。
访问内部类：
* 在外围类的方法中使用内部类和使用普通类没有区别
* 外部类将有一个方法，返回一个指向内部类的引用。
* 如果想从外部类的非静态方法之外的任意位置创建某个内部类的对象，那么必须像在main方法中那样，具体地指明这个对象的类型： OuterClassName.InnerClassName


### 链接外部类

内部类可以访问外部类的成员

### 使用.this .new

