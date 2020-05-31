package cn.yhs.learn.type6;

/**
 * @ProjectName: design-pattern
 * @Name: cn.yhs.learn.type.Type6
 * @Author: Splendor -- 加油,你是最棒的 ~_~
 * @Email: 15617577080@163.com
 * @Time: 2020/5/31 16:16
 * @Description: 双重检车
 **/
public class Type6 {
    public static void main(String[] args) {
        Singleton singleton = Singleton.instance();
        Singleton singleton2 = Singleton.instance();
        System.out.println(singleton == singleton2);
    }

}

/**
 * 懒汉式（线程安全），双重检查
 * 优缺点：
 * 优点：双重检查是多线程中常用到的，如代码中所示，我们进行了两次if()检查，这样就保证了线程安全，实例化代码
 *      执行了一次，后面再访问时，判断第一个if，直接return实例化对象，也避免了反复进行方法同步
 *      线程安全，延迟加载，效率高
 * 综合：推荐使用
 */
class Singleton {
    // volatile 实现线程各自的数据立马同步到主存
    private static volatile Singleton singleton;

    private Singleton() {
    }

    // 同步代码块中再加上if判断，实现双重检查，既保证了线程安全问题，又实现了懒加载,同时保证了效率
    public static synchronized Singleton instance() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
