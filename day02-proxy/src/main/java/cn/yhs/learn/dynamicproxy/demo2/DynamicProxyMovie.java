package cn.yhs.learn.dynamicproxy.demo2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @ProjectName: design-pattern
 * @Name: cn.yhs.learn.dynamicproxy.demo2.DynamicProxyMovie
 * @Author: Splendor -- 加油,你是最棒的 ~_~
 * @Email: 15617577080@163.com
 * @Time: 2020/6/1 10:15
 * @Description: todo
 **/
// 动态代理类不需要实现目标类的接口
public class DynamicProxyMovie implements InvocationHandler {
    private Object object; // 维护一个目标对象

    public DynamicProxyMovie(Object object) {
        this.object = object;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 对方法进行增强
        service1();
        service2();
        Object returnVal = method.invoke(object, args);
        service3();
        return returnVal;
    }

    public void service1() {
        System.out.println("出售爆米花");
    }

    public void service2() {
        System.out.println("插入广告");
    }

    public void service3() {
        System.out.println("提供按摩椅");
    }

}
