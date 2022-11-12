# 集合
1. 讲了什么

### 1. 讲了什么

介绍Java集合类库的基本知识，并重点介绍一些典型用法，专注于在日常编程中使用的集合。

```java
ArrayList<Apple> apples = new ArrayList<>(); // 菱形语法
```

java7之前

```java
ArrayList<Apple> apples = new ArrayList<Apple>(); // 菱形语法
```

并不一定是确切的对象，向上转型的对象也可以放入泛型定义的集合中

## 基本概念

Java 集合中采用 持有对象(holding objects)的思想，并将其分为两个不同的概念，便是为类库的基本接口：

1. 集合(Collection): 一个独立元素的序列，这些元素都服从一条或多条规则。
    * List 必须以插入的顺序
    * Set 不能包含重复
    * Queue 按照排队的规则
2. 映射(Map) 一组成对的"键值对"对象，允许使用建来查找值
   * ArrayList使用数字查找对象
   * Map 允许我们使用一个对象查找另个一对象 关联数组 字典 Map是强大的编程工具

唯一需要制定所使用的精确类型的地方就是再创建的时候。

```java
List<Apple> apples = new ArrayList<>();
```

ArrayList已经向上转型为List。** 使用接口的目的是，如果想要改变实现，只需在创建时修改它就行了**
创建一个具体类的对象，将其向上转型为对应的接口，然后在其余代码中都是用这个接口。

但是也有例外，想使用具体类的中额外的功能，就不能向上转型


## 添加元素组

* Arrays.asList() 方法节后给数组或是逗号分隔的元素列表（使用可变参数），并将其转换为List对象。
* Collections.addAll 方法接受一个Collection对象，以及一个数组或是一个逗号分隔的列表，将其中元素添加到Collection中。
* Collection.addAll只接受一个Collection对象

Arrays.asList的底层实现是数组,得到的List无法进行add和remove操作

## 集合的打印

Arrays.toSring()用来打印数组的信息,打印集合无需任何的其他方法，toString已经实现

* ArrayList LinkedList 是List类型
* HashSet TreeSet LinkedHashSet。是Set类型 HashSet没有顺序，TreeSet根据比较顺序升序，LinkedHashSet 添加顺序
* HashMap TreeMap LinkedHashMap. 顺序同Set  

Map 包含 put和 get方法

## 列表List

List接口在Collection 的基础上添加了许多方法，允许在List的中间插入和删除元素。

两种List
* ArrayList
* LinkedList

```java

List<Pet> pets = new ArrayList<>();
pets.add(1);
pets.remove(1);
pets.contains(1);
pets.get(2);
pets.indexOf(1);
pets.subList(1,4);
pets.containsAll(sub);
retainAll
removeAll
set
addAll
clear

```
subList() 所产生的列表是原始列表

## 迭代器 Iterators

迭代器（也是一种设计模式）的概念实现了这种抽象。迭代器是一个对象，它在一个序列中移动并选择该序列中的每个对象。 轻量级对象，创建它的代价小

1. 使用iterator()方法要求返回一个Iterator.Iterator将准备好返回序列中的第一个元素
2. 使用next()方法获得序列中的下一个元素
3. 使用hasNext()方法检查序列中是否还有元素
4. 使用remove()方法将迭代器最近返回的那个元素删除

能够将遍历序列的操作与该序列的底层结构分离。 迭代器统一了对集合的访问方式。

## ListIterator

ListIterator可以双向移动，只能由各种List类生成。

ListIterator可以双向移动。

## 列表LinkedList

* getFirst element peek; 都是返回头部， getFirst 和 element，List为空时，会报错,peek 它在列表为空时返回null
* removeFirst()和remove()，也是相同的，删除并返回列表的头部元素，并在列表为空时抛出异常NoSuchElementException poll稍有差异，它在列表为空时返回null
* addFirst()
* offer() add () addLast
* removeLast()

## 堆栈 Stack

```java
Deque<String> stack = new ArrayDeque<>();
```

## 集合Set

HashSet用了散列表，散列函数
TreeSet用了红黑树数据结构
LinkedHashSet 散列

## 映射Map

get put
containsKey() containsValue()

## 队列
offer()

## 优先级队列 PriorityQueue

## 集合与迭代器

Collection 是所有序列集合共有的接口。java.util.AbstractCollection类提供了 Collection 的默认实现，使得你可以创建AbstractCollection的子类型。

## for-in 和迭代器



