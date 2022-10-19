### 引用类型判断

判断基本类型可以使用==，引用类型需要使用equals方法

```java
String s1="hello";
        if(s1.equals("hello")){
        System.out.println("hello")
        }
```

要避免NullPointerException, 可以利用短路符号&&

```java
String s1="hello";
        if(s1!==null&&s1.equals("hello")){
        System.out.println("hello")
        }
```
