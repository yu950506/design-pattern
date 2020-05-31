package cn.yhs.learn.type8;

/**
 * @ProjectName: design-pattern
 * @Name: cn.yhs.learn.type8.Type8
 * @Author: Splendor -- 加油,你是最棒的 ~_~
 * @Email: 15617577080@163.com
 * @Time: 2020/5/31 16:43
 * @Description: 枚举实现
 **/
public class Type8 {
    public static void main(String[] args) {
        Singleton singleton = Singleton.INSTANCE;
        Singleton singleton2 = Singleton.INSTANCE;
        System.out.println(singleton == singleton2);
    }
}

/**
 * 枚举实现
 * 优缺点：
 * 优点： jdk1.5中添加的枚举实现单例模式，不仅能避免多线程的同步问题，而且还能防止反序列化重新创建新对象
 *          是Effective Java作者提倡的方式
 * 综合：推荐使用
 */
enum Singleton {
    INSTANCE; // 属性
}
