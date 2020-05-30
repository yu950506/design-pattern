package cn.yhs.learn.type1;

/**
 * @ProjectName: design-pattern
 * @Name: cn.yhs.learn.type1.Type1
 * @Author: Splendor -- 加油,你是最棒的 ~_~
 * @Email: 15617577080@163.com
 * @Time: 2020/5/30 21:26
 * @Description: 懒汉式-静态常量
 **/

public class Type1 {
    public static void main(String[] args) {
        Singleton singleton = Singleton.instance();
        Singleton singleton2 = Singleton.instance();
        System.out.println(singleton.hashCode());
        System.out.println(singleton2.hashCode());
        System.out.println(singleton == singleton2); // true
    }
}

/**
 * 优缺点：
 *  优点：写法简单，就是在类装载的时候就完成了实例化，避免了线程同步问题
 *  缺点：一上来就创建对象，没有懒加载的效果，如果对象没使用，就会造成内存浪费
 *  总结：写法简单，模式可用，没有懒加载，可能造成内存浪费
 */
class Singleton {
    // 静态常量
    private final static Singleton singleton = new Singleton();

    // 构造器私有化，不让外界创建对象
    private Singleton() {

    }

    // 对外提供公共的静态方法创建对象实例
    public static Singleton instance() {
        return singleton;
    }

}