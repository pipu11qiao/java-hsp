# JDBC

什么是JDBC？ JDBC是Java DataBase Connectivity的缩写，是Java程序访问数据库的标准接口。

使用Java程序访问数据库时，Java代码并不是直接通过TCP链接去访问数据，而是通过JDBC接口来访问，而JDBC接口则通过JDBC驱动来实现对具体数据库的访问。

例如，我们的代码中必须访问MySQL,那么必须编写代码操作JDBC接口。 注意到JDBC接口是Java标准库自带的，可以直接编译。而具体的JDBC驱动是由数据库厂商提供的

访问的过程描述

Java App 通过 JDBC Interface(JDK 提供) 通过 JDBC Driver (Vendor 提供) 数据库

具体到mysql的过程描述

Java App 通过 JDBC Interface(JDK 提供) 通过 MySQL Driver (Oracel 提供) MySQL

从代码来看，Java标准库自带的JDBC接口其实就是定义了一组接口，而某个具体的JDBC驱动其实就是实现了这些接口的类：

实际上，一个MySQL的JDBC的驱动就是一个jar包，它本身是纯Java编写的。当编程时，只需引用标准库提供的java.sql包中的相关接口，进行数据库操作。最后java程序通过MySQL的驱动（jar）包来完成实际的数据库访问操作。

使用JDBC的好处是：

1. 各数据库厂商使用相同的接口，Java代码不需要针对不同数据库分别开发
2. Java程序编译期，仅依赖java.sql包，不依赖具体数据库的jar包
3. 可以随时替换底层数据库，访问数据库的Java代码基本不变


JDBC驱动： 实现了JDBC接口的jar包称为JDBC的驱动
