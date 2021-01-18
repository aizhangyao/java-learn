# 前言
单例模式Singleton就是某个类只能生成一个实例，该类提供了一个全局访问点供外部获取该实例，其拓展是有限多例模式。

# 单例模式(Singleton Pattern)
单例模式属于创建型模式，它提供了一种创建对象的最佳方式。
> 1.单例类只能有一个实例。
> 2.必须保证自己创建自己的唯一实例。
> 3.并且给其他对象提供访问这一实例的方式。

# 应用场景
> 1.要求生产唯一序列号。
> 2.WEB 中的计数器，不用每次刷新都在数据库里加一次，用单例先缓存起来。
> 3.创建的一个对象需要消耗的资源过多，比如 I/O 与数据库的连接等。

# 分类
单例模式常见的有饿汉式、懒汉式、双检锁/双重校验锁、静态内部类、枚举。
## 饿汉式
这种方式类加载到内存后，就实例化一个单例，JVM会保证线程安全。简单实用，相当推荐使用。但是，他的唯一缺点就是：不管是否用到，类加载时就会完成实例化。
```java
/**
 * 饿汉式
 */
public class Singleton01 {
    private static final Singleton01 INSTANCE = new Singleton01();

    private Singleton01() {
    }

    public static Singleton01 getInstance() {
        return INSTANCE;
    }

    public void m() {
        System.out.println("m");
    }

    public static void main(String[] args) {
        Singleton01 s1 = Singleton01.getInstance();
        Singleton01 s2 = Singleton01.getInstance();
        System.out.println(s1 == s2);
    }
}
```
对于饿汉式的单例模式，还有一种是在静态代码块中进行new一个单例。和上面的本质没有区别，看看就好。
```java
public class Singleton02 {
    private static final Singleton02 INSTANCE;

    static {
        INSTANCE = new Singleton02();
    }
    //...
}
```

## 懒汉式（线程不安全）
相比饿汉式，懒汉式的单例模式达到了按需初始化的目的，但是带来了线程不安全的问题。
```java
/**
 * lazy loading 也称懒汉式
 * 虽然达到了按需初始化的目的，但却带来线程不安全的问题
 */
public class Singleton03 {
    private static Singleton03 INSTANCE;

    private Singleton03() {
    }

    public static Singleton03 getInstance() {
        if (INSTANCE == null) {
//            try {
//                Thread.sleep(1);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            INSTANCE = new Singleton03();
        }
        return INSTANCE;
    }

    public void m() {
        System.out.println("m");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(Singleton03.getInstance().hashCode());
            }).start();
        }
    }
}
```
上面这种方式线程不安全，在判断`INSTANCE == null`的后面我们把线程阻塞1ms，运行后通过比较hashCode就会发现不同线程访问到的实例并不全是同一个对象实例。
```
422057313
503674368
1650594751
1634218452
1160999711
1341620907
1522804050
72786614
1430746659
966186071
1133046463
151286434
2115147268
1326204679
422057313
796465865
796465865
733365800
796465865
796465865
...
```

## 懒汉式（线程安全）
为了保证懒汉式单例模式线程安全，考虑到对getInstance()方法的改造。通过`synchronized`来实现线程安全。
```java
/**
 * 可以通过synchronized解决，但却带来了效率下降
 */
public class Singleton04 {
    private static Singleton04 INSTANCE;

    private Singleton04() {

    }

    public static synchronized Singleton04 getInstance() {
        if (INSTANCE == null) {
//            try {
//                Thread.sleep(1);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            INSTANCE = new Singleton04();
        }
        return INSTANCE;
    }

    public void m() {
        System.out.println("m");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(Singleton04.getInstance().hashCode());
            }).start();
        }
    }
}
```
运行测试之后，发现这种方式可以保证线程安全。但是在内存当中的对象一定比我们上面这个简单的Singleton04对象大的多，还有就是在每一次使用的时候都需要去获取这把锁才可以获取实例。这样一来，效率就会降低。
所以就有人想通过减少同步代码块的方式来提高效率，所有就产生了下面这种。
```java
/**
 * 通过synchronized解决，但却带来了效率下降。所以就想通过减少同步代码块的方式来提高效率，但是不可行。
 */
public class Singleton05 {
    private static Singleton05 INSTANCE;

    private Singleton05() {

    }

    public static Singleton05 getInstance() {
        if (INSTANCE == null) {
            //试图通过减少同步代码块的方式来提高效率，不可行
            synchronized (Singleton05.class) {
//                try {
//                    Thread.sleep(1);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                INSTANCE = new Singleton05();
            }
        }
        return INSTANCE;
    }

    public void m() {
        System.out.println("m");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(Singleton05.getInstance().hashCode());
            }).start();
        }
    }
}
```
上面这种并不能保证线程安全。所以就出现了双检锁。

## 双检锁/双重校验锁
双检锁/双重校验锁（DCL，即 double-checked locking）这种方式采用双锁机制，安全且在多线程情况下能保持高性能。
```java
/**
 * 双检锁/双重校验锁
 */
public class Singleton06 {
    private static volatile Singleton06 INSTANCE;//JIT

    private Singleton06() {

    }

    public static Singleton06 getInstance() {
        if (INSTANCE == null) {
            //双重检查
            synchronized (Singleton06.class) {
                if (INSTANCE == null) {
//                    try{
//                        Thread.sleep(1);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                    INSTANCE = new Singleton06();
                }
            }
        }
        return INSTANCE;
    }

    public void m() {
        System.out.println("m");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(Singleton06.getInstance().hashCode());
            }).start();
        }
    }
}
```

## 静态内部类方式
只有第一次调用getInstance()方法时，虚拟机才加载`Singleton07Holder`内部类 并初始化`INSTANCE`，只有一个线程可以获得对象的初始化锁，其他线程无法进行初始化，保证对象的唯一性。
```java
/**
 * 静态内部类方式
 * JVM保证单例，加载外部类时不会加载内部类，这样可以实现懒加载
 */
public class Singleton07 {
    private Singleton07() {

    }

    private static class Singleton07Holder {
        private final static Singleton07 INSTANCE = new Singleton07();
    }

    public static Singleton07 getInstance() {
        return Singleton07Holder.INSTANCE;
    }

    public void m() {
        System.out.println("m");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(Singleton07.getInstance().hashCode());
            }).start();
        }
    }
}
```
## 枚举单例模式
```java
/**
 * 不仅可以解决线程同步，还可以防止反序列化。
 */
public enum Singleton08 {
    INSTANCE;

    public void m() {
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(Singleton08.INSTANCE.hashCode());
            }).start();
        }
    }
}
```
# 结束语
文末就不聊单例了。