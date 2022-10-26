### classpath
classpath 是JVM用到的一个环境变量，它用来指示JVM如何所搜class
因为Java是编译型语言，源码文件是.java,而编译后.class文件才是真正可以被JVM执行的字节码。因此，JVM需要知道，如果要加载一个abc.xyz.Hello的类，应该去哪搜索对应的Hello.class文件。
classpath是一组目录的集合，它设置的搜索路径与操作系统有关。

> /usr/shared:/usr/local/bin:/home/aa/bin

当JVM在加载abc.xyz.Hello这个类时，会依次查找：

* <当前目录>/abc/xyz/Hello.class
* /home/aa/bin/abc/xyz/Hello.class
* /usr/local/bin/abc/xyz/Hello.class
* /usr/shared/abc/xyz/Hello.class

依次寻找，找到就停止，找不到报错。

设定方法有两种：
* 系统环境变量
* 启动JVM时设置classpath变量

> java -classpath .;C:\work\project1\bin;C:\shared abc.xyz.Hello
> java -cp .;C:\work\project1\bin;C:\shared abc.xyz.Hello


### jar 包

很多的.class文件散落在各层目录中，不便于管理，如果能报目录达成一个包，变成一个文件，就方便多了。
jar包，可以把package组织的目录层级，以及各个目录下的所有文件（包括.class文件和其他文件）都打成一个jar文件。

jar包实际就是个.zip格式的压缩文件。

jar包中会有，/META-INF/MANIFEST.MF文件，指定Main-Class和其他信息。

如何生成jar包， 手动压缩

maven等构建工具，用来在项目中构建jar包
