package cn.yhs.learn.cglibproxy.demo2;

/**
 * @ProjectName: design-pattern
 * @Name: cn.yhs.learn.cglibproxy.demo2.CglibTest
 * @Author: Splendor -- 加油,你是最棒的 ~_~
 * @Email: 15617577080@163.com
 * @Time: 2020/6/1 10:34
 * @Description: todo
 **/
public class CglibTest {
    public static void main(String[] args) {
        LoveMovie2 loveMovie2 = new LoveMovie2();
        ProxyFactory proxyFactory = new ProxyFactory(loveMovie2);
        LoveMovie2 instance = (LoveMovie2) proxyFactory.getProxyInstance();
        instance.play();
    }
}
