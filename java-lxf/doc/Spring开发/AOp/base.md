# AOP Aspect Oriented Programming 面向切面编程

```java
public  class BookService {
    public void createBook(Book book){
        securityCheck();
        Transaction tx = startTransaction();
        try{
            //核心业务逻辑
            tx.commit();
        }catch(RuntimeException e){
            tx.rollback();
            throw e;
        }
        
        log("created book: " + book);
    }
    public  void updateBook(Book book){
        securityCheck();
        Transaction tx = startTransaction();
        try{
            //核心业务逻辑
            tx.commit();
        }catch(RuntimeException e){
            tx.rollback();
            throw e;
        }

        log("updated book: " + book);
    }
}
```

# 装配AOP

* Aspect: 切面，即一个横跨多个核心逻辑的功能，或者称之为系统关注点
* Joinpoint: 连接点，即定义在应用程序流程的何处插入切面的执行
* Pointcut
* Advice
* Introduction
* Weaving
* Intercept
* Target Object
* AOP Proxy



