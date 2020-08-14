# Redisson简介

Redis 是最流行的 NoSQL 数据库解决方案之一，而 Java 是世界上最流行（注意，我没有说“最好”）的编程语言之一。虽然两者看起来很自然地在一起“工作”，但是要知道，Redis 其实并没有对 Java 提供原生支持。

相反，作为 Java 开发人员，我们若想在程序中集成 Redis，必须使用 Redis 的第三方库。而 Redisson 就是用于在 Java 程序中操作 Redis 的库，它使得我们可以在程序中轻松地使用 Redis。Redisson 在 java.util 中常用接口的基础上，为我们提供了一系列具有分布式特性的工具类。

在这篇文章里，我会给你们介绍 Redisson 的一些常见用例，请跟随我一起来看看吧。

如何安装 Redisson

安装 Redisson 最便捷的方法是使用 Maven 或者 Gradle：

Maven
```
<dependency>
 <groupId>org.redisson</groupId>
 <artifactId>redisson</artifactId>
 <version>3.11.4</version>
</dependency>
```

Gradle
```compile group: 'org.redisson', name: 'redisson', version: '3.11.4'```

目前 Redisson 最新版是 3.11.4，当然你也可以通过搜索 Maven 中央仓库 mvnrepository 来找到 Redisson 的各种版本。


## 使用 RList 操作 Redis 列表

下面的代码简单演示了如何在 Redisson 中使用 RList 对象。RList 是 Java 的 List 集合的分布式并发实现。考虑以下代码：
```java
import org.redisson.Redisson;
import org.redisson.api.RList;
import org.redisson.api.RedissonClient;
public class ListExamples {
     public static void main(String[] args) {
         // 默认连接上 127.0.0.1:6379
         RedissonClient client = Redisson.create();
         // RList 继承了 java.util.List 接口
         RList<String> nameList = client.getList("nameList");
         nameList.clear();
         nameList.add("bingo");
         nameList.add("yanglbme");
         nameList.add("https://github.com/yanglbme");
         nameList.remove(-1);
         boolean contains = nameList.contains("yanglbme");
         System.out.println("List size: " + nameList.size());
         System.out.println("Is list contains name 'yanglbme': " + contains);
         nameList.forEach(System.out::println);
         client.shutdown();
     }
}
```


运行上面的代码时，可以获得以下输出：
```java
List size: 2
Is list contains name 'yanglbme': true
bingo
yanglbme
```

## 使用 RMap 操作 Redis 哈希

Redisson 还包括 RMap，它是 Java Map 集合的分布式并发实现，考虑以下代码：
```java
import org.redisson.Redisson;
import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;
public class MapExamples {
     public static void main(String[] args) {
         // 默认连接上127.0.0.1:6379
         RedissonClient client = Redisson.create();
         // RMap 继承了 java.util.concurrent.ConcurrentMap 接口
         RMap<String, String> map = client.getMap("personalInfo");
         map.put("name", "yanglbme");
         map.put("address", "Shenzhen");
         map.put("link", "https://github.com/yanglbme");
         boolean contains = map.containsKey("link");
         System.out.println("Map size: " + map.size());
         System.out.println("Is map contains key 'link': " + contains);
         String value = map.get("name");
         System.out.println("Value mapped by key 'name': " + value);
         boolean added = map.putIfAbsent("link", "https://doocs.github.io") == null;
         System.out.println("Is value mapped by key 'link' added: " + added);
         client.shutdown();
     }
}
```


运行上面的代码时，将会看到以下输出：
```java
Map size: 3
Is map contains key 'link': true
Value mapped by key 'name': yanglbme
Is value mapped by key 'link' added: false
```

## 使用 RLock 实现 Redis 分布式锁

RLock 是 Java 中可重入锁的分布式实现，下面的代码演示了 RLock 的用法：

```java
import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
public class LockExamples {
     public static void main(String[] args) throws InterruptedException {
         // 默认连接上127.0.0.1:6379
         RedissonClient client = Redisson.create();
         // RLock 继承了 java.util.concurrent.locks.Lock 接口
         RLock lock = client.getLock("lock");
         lock.lock();
         System.out.println("lock acquired");
         Thread t = new Thread(() -> {
         RLock lock1 = client.getLock("lock");
         lock1.lock();
         System.out.println("lock acquired by thread");
         lock1.unlock();
         System.out.println("lock released by thread");
         });
         t.start();
         t.join(1000);
         lock.unlock();
         System.out.println("lock released");
         t.join();
         client.shutdown();
     }
}
```

此代码将产生以下输出：
```java
lock acquired
lock released
lock acquired by thread
lock released by thread
```

## 使用 RAtomicLong 实现 Redis 原子操作

RAtomicLong 是 Java 中 AtomicLong 类的分布式“替代品”，用于在并发环境中保存长值。以下示例代码演示了 RAtomicLong 的用法：

```java
import org.redisson.Redisson;
import org.redisson.api.RAtomicLong;
import org.redisson.api.RedissonClient;
public class AtomicLongExamples {
     public static void main(String[] args) {
         // 默认连接上127.0.0.1:6379
         RedissonClient client = Redisson.create();
         RAtomicLong atomicLong = client.getAtomicLong("myLong");
         System.out.println("Init value: " + atomicLong.get());
         atomicLong.incrementAndGet();
         System.out.println("Current value: " + atomicLong.get());
         atomicLong.addAndGet(10L);
         System.out.println("Final value: " + atomicLong.get());
         client.shutdown();
     }
}
```


此代码的输出将是：
```java
Init value: 0
Current value: 1
Final value: 11
```

文章地址：https://zhuanlan.zhihu.com/p/97484791