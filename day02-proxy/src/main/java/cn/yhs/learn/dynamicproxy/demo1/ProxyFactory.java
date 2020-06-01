package cn.yhs.learn.dynamicproxy.demo1;

/**
 * @ProjectName: design-pattern
 * @Name: cn.yhs.learn.dynamicproxy.ProxyFactory
 * @Author: Splendor -- 加油,你是最棒的 ~_~
 * @Email: 15617577080@163.com
 * @Time: 2020/5/31 20:50
 * @Description: todo
 **/

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

//动态代理也叫jdk代理
public class ProxyFactory {
    // 维护一个目标对象，因为可以代理任意的对象，所以用Object
    private Object target;

    // 使用构造器给目标对象赋值
    public ProxyFactory(Object target) {
        this.target = target;
    }

    // 用于生成代理对象的方法
    public Object getInstance() {
        /*
        public static Object newProxyInstance(ClassLoader loader,Class<?>[] interfaces,InvocationHandler h)
        参数说明：
        loader:指明当前目标对象的类加载器
        interfaces:目标对象实现的接口类型
        h:事件通知处理,调用目标对象的方法，对方法进行增强控制
         */
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler() {
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("method name:" + method.getName());
                        System.out.println("method args:" + Arrays.toString(args));
                        System.out.println("动态代理开始");
                        System.out.println("方法进行增强");
                        // 对象调用返回的返回值
                        Object returnValue = method.invoke(target, args);
                        System.out.println("方法调用的返回值:" + returnValue);
                        System.out.println("动态代理结束");
                        return returnValue;
                    }
                }
        );
    }
}
