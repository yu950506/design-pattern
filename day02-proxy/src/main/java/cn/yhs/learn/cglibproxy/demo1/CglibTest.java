package cn.yhs.learn.cglibproxy.demo1;

/**
 * @ProjectName: design-pattern
 * @Name: cn.yhs.learn.CglibTest
 * @Author: Splendor -- 加油,你是最棒的 ~_~
 * @Email: 15617577080@163.com
 * @Time: 2020/5/31 23:46
 * @Description: todo
 **/
public class CglibTest {
    public static void main(String[] args) {
        Teacher t = new Teacher();
        ProxyFactory proxyFactory = new ProxyFactory(t);
        Teacher instance = (Teacher) proxyFactory.getProxyInstance();
         instance.teach();
    }
}
