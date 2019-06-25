## 1.1 String相关
### 1.1.1 String类为什么是final的。
解析:首先理解final关键字的意义

- 被final修饰的类不能被继承，即它不能拥有自己的子类
- 被final修饰的方法不能被重写
- final修饰的变量，无论是类属性、对象属性、形参还是局部变量，都需要进行初始化操作。

  **最后至于为什么String类要用final进行修饰 主要目的是为了`安全性`和`效率`的问题**

- 由于String类不能被继承，所以就不会没修改，这就避免了因为继承引起的安全隐患；
- String类在程序中出现的频率比较高，如果为了避免安全隐患，在它每次出现时都用final来修饰，这无疑会降低程序的执行效率，所以干脆直接将其设为final一提高效率；
如下图:(详情请见链接: https://www.cnblogs.com/hellowhy/p/6536590.html)
![799929-20170312014540311-774978386.png-29.5kB][1]
### 1.1.2 String、StringBuffer、StringBuilder区别
解析:
String是不可变的 StringBuffer和StringBuider是可变的 ,StringBuffer是线程安全(因为每个方法都用了synchronized进行修饰)的StringBuider是线程不安全的
![2019-06-06_114017.png-51.8kB][2]
![图拍你](../../../../src/main/resources/images/21.jpg)


**总结:**

- 在字符串不经常发生变化的业务场景优先使用String(代码更清晰简洁)。如常量的声明，少量的字符串操作(拼接，删除等)。
- 在单线程情况下，如有大量的字符串操作情况，应该使用StringBuilder来操作字符串。不能使用String"+"来拼接而是使用，避免产生大量无用的中间对象，耗费空间且执行效率低下（新建对象、回收对象花费大量时间）。如JSON的封装等。
- 在多线程情况下，如有大量的字符串操作情况，应该使用StringBuffer。如HTTP参数解析和封装等。
### 1.1.3 java中==和equals和hashCode的区别

- == : 是判断两个对象的地址是否相等
- equals : 是判断两个对象的内容是否相等
- hashCode() 的作用是获取哈希码，也称为散列码；它实际上是返回一个int整数。这个哈希码的作用是确定该对象在哈希表中的索引位置

**为什么要有 hashCode**
我们先以“HashSet 如何检查重复”为例子来说明为什么要有 hashCode： 当你把对象加入 HashSet 时，HashSet 会先计算对象的 hashcode 值来判断对象加入的位置，同时也会与其他已经加入的对象的 hashcode 值作比较，如果没有相符的hashcode，HashSet会假设对象没有重复出现。但是如果发现有相同 hashcode 值的对象，这时会调用 equals（）方法来检查 hashcode 相等的对象是否真的相同。如果两者相同，HashSet 就不会让其加入操作成功。如果不同的话，就会重新散列到其他位置。（摘自我的Java启蒙书《Head first java》第二版）。这样我们就大大减少了 equals 的次数，相应就大大提高了执行速度。


**hashCode（）与equals（）的相关规定**
如果两个对象相等，则hashcode一定也是相同的
两个对象相等,对两个对象分别调用equals方法都返回true
两个对象有相同的hashcode值，它们也不一定是相等的
因此，equals 方法被覆盖过，则 hashCode 方法也必须被覆盖
hashCode() 的默认行为是对堆上的对象产生独特值。如果没有重写 hashCode()，则该 class 的两个对象无论如何都不会相等（即使这两个对象指向相同的数据）