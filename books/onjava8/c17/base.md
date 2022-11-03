# 文件

1. 讲了啥 文件操作


java.nio "n"飞阻塞id
两个组件
* 文件或目录的路径
* 文件本身

## 文件和目录的路径
一个Path对象表示一个文件或者目录的路径，是一个跨操作系统的和文件系统的抽象。

java.nio.file.Paths类包含一个重载方法static get(),该方法接受一些列String字符串或一个统一资源标识符作为参数，并且进行转换返回一个Path对象

## 文件本身

toString() 生成路径的完整的路径信息
getFileName() 返回当前文件名
toRealPath() 会返回实际情况下的Path,并且还会删除冗余元素

### 选取路径部分片段

getName来索引Path的各个部分，知道达到上限，getNameCount()。Path也实现了Iterable接口
endsWith() 比较的是整个路径的部分，不包含后缀名
startsWith()包含根路径

### 路径分析

通过Files的静态方法分析路径

exists,isDirectory,isExecutable,isWritable,isReadable,isRegularFile,notExists,isHidden,size,getFileStore,getLastModifiedTime,getOwner,probeContentType,isSymbolicLink
getPosixPermissions

### Paths的增减修改

必须能通过对Path对象的增加或修改删除来构造一个新的Path对象。使用relativize()移除Path的根路径，使用resolve()添加Path的尾路径。


## 目录

Files工具类中包含大部分我们需要的目录操作和文件操作方法。删除目录树相关的方法。

Files.walkFileTree()

Visitor设计模式提供了一种标准机制来访问集合中的每个对象，然后你需要提供在每个对象上执行的操作。实现FileVisitor的四个抽象方法

* preVisitDirectory()
* visitFile()
* visitFileFailed() 调用无法访问的文件
* postVisitDirectory() 在访问目录中条目之后在目录上运行，包括所有的子项目

对于已经存在的目录调用createDirectory()将会抛出异常


## 文件系统

方法查找文件系统相关的其他信息， FileSystems工具类获取"默认"的文件系统,Path对象上使用getFileSystem()以获取创建该Path的文件系统。可以获得给定的URI的文件系统，还可以构建新的文件系统

一个FileSystem对象也能生成WatchService和PathMatcher 对象，将会在接下来的两章中详细讲解

### 路径监听

通过WatchService 可以设置一个进程对目录中的更改做出相应。


### 文件查找

通过在FileSystem 对象上调用getPathMatcher() 获得一个 PathMatcher 然后传入感兴趣的模式： glob和regex


### 文件读写


Files.readAllLines() 一次读取整个文件，产生List<String>






