package cn.yhs.learn.dynamicproxy.demo1;

/**
 * @ProjectName: design-pattern
 * @Name: cn.yhs.learn.dynamicproxy.DynamicProxyTest
 * @Author: Splendor -- 加油,你是最棒的 ~_~
 * @Email: 15617577080@163.com
 * @Time: 2020/5/31 21:00
 * @Description: todo
 **/
public class DynamicProxyTest {
    public static void main(String[] args) {
        // 目标对象
        TeacherDao teacherDao = new TeacherDaoImpl();
        // 使用代理工厂动态创建一个代理对象
        ProxyFactory proxyFactory = new ProxyFactory(teacherDao);
        TeacherDao instance = (TeacherDao) proxyFactory.getInstance();
        instance.teacher();
        instance.sayHello("yhs");
    }
}
