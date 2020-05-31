package cn.yhs.learn.type4;

/**
 * @ProjectName: design-pattern
 * @Name: cn.yhs.learn.type4.Type4
 * @Author: Splendor -- 加油,你是最棒的 ~_~
 * @Email: 15617577080@163.com
 * @Time: 2020/5/30 21:54
 * @Description: 懒汉式（线程安全,使用同步方法）
 **/
public class Type4 {
    public static void main(String[] args) {
        Singleton singleton = Singleton.instance();
        Singleton singleton2 = Singleton.instance();
        System.out.println(singleton == singleton2);
    }
}

/**
 * 懒汉式（线程安全），使用同步方法解决
 * 优缺点：
 *  优点：当使用时才会去创建，即懒加载的效果，另外使用同步方法解决了线程安全问题
 *  缺点：效率太低了，每个线程都要获取实例的时候都要走同步方法，但是这个方法执行了一次实例化代码就可以了
 *          后面想获取该实例，直接return就好，方法进行同步，效率太低
 *  综合：在实际开发中不要使用这种模式，效率太低
 */
class Singleton {
    private static Singleton singleton;

    private Singleton() {
    }

    // 同步方法解决线程安全问题，但是效率低
    public static synchronized Singleton instance() {
        if (singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }
}



