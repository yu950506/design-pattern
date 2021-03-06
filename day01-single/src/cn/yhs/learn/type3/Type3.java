package cn.yhs.learn.type3;

/**
 * @ProjectName: design-pattern
 * @Name: cn.yhs.learn.type3.Type3
 * @Author: Splendor -- 加油,你是最棒的 ~_~
 * @Email: 15617577080@163.com
 * @Time: 2020/5/30 21:43
 * @Description: 懒汉式
 **/
public class Type3 {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();
        System.out.println(singleton == singleton2);
    }
}

/**
 * 懒汉式（线程不安全），当使用到这个对象时，才会去创建对象
 * 优缺点：
 *  优点：当使用时才会去创建，即懒加载的效果，但是只能在单线程下使用
 *  缺点：如果在多线程下，一个线程走到if语句，还没有来得及执行下面语句创建对象语句，另一个线程也刚好走到这个if语句，
 *         这时，便会产生多个实例。
 *  综合：在实际开发中不要使用这种模式，容易造成线程安全问题
 */
class Singleton {

    private static Singleton singleton;

    // 构造器私有化，不让外界创建对象
    private Singleton() {
    }

    // 对外提供静态的得到对象实例的方法
    public static Singleton getInstance() {
        // 如果对象为null,才进行创建，保证只有一个实例
        if (singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }
}
