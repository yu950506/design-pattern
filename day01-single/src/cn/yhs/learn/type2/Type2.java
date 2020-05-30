package cn.yhs.learn.type2;

/**
 * @ProjectName: design-pattern
 * @Name: cn.yhs.learn.type2.Type2
 * @Author: Splendor -- 加油,你是最棒的 ~_~
 * @Email: 15617577080@163.com
 * @Time: 2020/5/30 21:37
 * @Description: 饿汉式，静态代码块
 **/
public class Type2 {
    public static void main(String[] args) {
        Singleton singleton = Singleton.instance();
        Singleton singleton2 = Singleton.instance();
        System.out.println(singleton == singleton2);
    }
}

/**
 *  优缺点和第一种一样：模式可用，可能造成内存浪费
 */
class Singleton {
    private static Singleton singleton;

    // 静态代码块中实例化
    static {
        singleton = new Singleton();
    }

    private Singleton() {
    }

    public static Singleton instance() {
        return singleton;
    }
}
