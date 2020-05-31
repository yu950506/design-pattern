package cn.yhs.learn.type5;

/**
 * @ProjectName: design-pattern
 * @Name: cn.yhs.learn.type.Type5
 * @Author: Splendor -- 加油,你是最棒的 ~_~
 * @Email: 15617577080@163.com
 * @Time: 2020/5/31 16:08
 * @Description: 懒汉式，同步代码块
 **/
public class Type5 {
    public static void main(String[] args) {
        Singleton singleton = Singleton.instance();
        Singleton singleton2 = Singleton.instance();
        System.out.println(singleton == singleton2);
    }
}

/**
 * 懒汉式（线程安全），使用同步代码块解决
 * 优缺点：
 * 优点：当使用时才会去创建，即懒加载的效果，另外使用同步代码块解决了线程安全问题，实际上并没有解决
 * 缺点：是懒汉式同步方法的另一种写法，实际上并没哟解决线程安全问题，
 * 综合：在实际开发中不要使用这种模式，不推荐
 */
class Singleton {
    private static Singleton singleton;

    private Singleton() {
    }

    // 使用同步代码块解决线程安全问题，实际上并没有解决，一个线程走到if语句，另一个线程在同步代码块，还是没有解决，这里只是对同步方法的另一种方式的提现，有人这样写过。
    public static Singleton instance() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                singleton = new Singleton();
            }
        }
        return singleton;
    }
}
