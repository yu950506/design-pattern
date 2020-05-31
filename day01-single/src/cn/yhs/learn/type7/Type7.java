package cn.yhs.learn.type7;

/**
 * @ProjectName: design-pattern
 * @Name: cn.yhs.learn.type7.Type7
 * @Author: Splendor -- 加油,你是最棒的 ~_~
 * @Email: 15617577080@163.com
 * @Time: 2020/5/31 16:26
 * @Description: 使用静态内部类
 **/
public class Type7 {
    public static void main(String[] args) {
        Singleton singleton = Singleton.instance();
        Singleton singleton2 = Singleton.instance();
        System.out.println(singleton == singleton2);
    }
}

/**
 * 静态内部类
 * 优缺点：
 * 优点：①采用了类装载机制来保证初始化实例对象只有一个线程，
 *      ②静态内部类在外部类装载时并不会立即实例化，而是在需要实例化时调用instance()方法，才回装载内部类，从而完成外部类的实例化
 *      ③类的静态属性只会在第一次装载类的时候实例化，所以这里JVM帮助我们保证了线程的安全性，在类进行实例化时，别的线程无法进入
 *      ④延迟加载，线程安全，效率高
 * 综合：推荐使用
 */
class Singleton {
    private static Singleton singleton;

    private Singleton() {

    }

    // 静态内部类,该类只有一个静态属性INSTANCE
    private static class SingletonInstance {
        private static final Singleton INSTANCE = new Singleton();
    }

    // 提供一个静态的公共方法，直接返回SingletonInstance.INSTANCE
    public static synchronized Singleton instance() {
        return SingletonInstance.INSTANCE;
    }
}
