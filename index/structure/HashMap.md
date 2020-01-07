## HashMap源码分析

- 构造函数：初始容量、负载因子
- `init()` 该方法为一个空方法，在Java中意味着该方法是交由子类实现的
- 初始容量16，扩容阈值为12

### Jdk1.7 

- HashMap默认容量
- -HashMap线程是否安全，与HashTable的区别
- HashMap存放null值
  	存放在数组0位置或者第一个链表
- HashMap是如何减少Index下标冲突问题
- HashMap如何解决hash冲突

```
Index冲突
对象不同，二进制运算后Index相同
hash冲突
对象不同，hashCode相同
链表解决

length-1,是因为HashMap底层的数组为2的幂次方，h&2的幂次方产生冲突太大，
为减少冲突，使length必须为奇数
static int indexFor(int h, int length) {
	return h & (length-1);
}
```

- 同一个链表中存在了哪些内容

```
Index冲突和Hash冲突
```

- HashMap根据Key查询时间复杂度为多少

```
分两种情况
如果key没有产生hash冲突的情况下，可以直接根据key计算index索引直接从数组中查询：O(1)
如果key产生了hash冲突的情况下，会形成链表，链表过长的话，查询效率非常低：O(N)
```

- HashMap底层扩容

```
扩容机制为2倍
```

- Hash是否可以存放自定义对象
- HashMap加载因子为何是0.75而不是其他

```
加载因子越大(扩容时间越晚)，Index下标冲突概率也就越大，反而空间利用率是非常高的
加载因子越小(扩容时间越早)，Index下标冲突概率也就越小，反而空间利用率不是特别高
如果Index下标冲突越高，反而查询的成本非常高，反之空间利用率越低,因此，必须在“冲突
的机会”与“空间利用率”之间寻找一种平衡与折中.
```

- JDK7的HashMap存在哪些问题

```
HashMap线程不安全，链表过长导致查询效率慢，底层扩容时可能存在死循环问题
Jdk7的HashMap计算hash值非常均摊 减少hash冲突问题，因为链表查询效率低
Jdk8的HashMap计算hash非常简单，存在hash冲突的概率比Jdk7的HashMap要大，但是没有关系，
因为Jdk8中HashMap使用红黑树解决查询效率问题

```

