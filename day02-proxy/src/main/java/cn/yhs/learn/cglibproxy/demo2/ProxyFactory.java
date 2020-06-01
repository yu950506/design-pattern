package cn.yhs.learn.cglibproxy.demo2;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @ProjectName: design-pattern
 * @Name: cn.yhs.learn.cglibproxy.demo2.ProxyFactory
 * @Author: Splendor -- 加油,你是最棒的 ~_~
 * @Email: 15617577080@163.com
 * @Time: 2020/6/1 10:29
 * @Description: todo
 **/

// public interface MethodInterceptor extends Callback

/**
 * CGlib是一个强大的,高性能,高质量的Code生成类库。它可以在运行期扩展Java类与实现Java接口。
 * 用CGlib生成代理类是目标类的子类。
 * 用CGlib生成 代理类不需要接口。
 * 用CGLib生成的代理类重写了父类的各个方法。
 * 拦截器中的intercept方法内容正好就是代理类中的方法体。
 */
public class ProxyFactory implements MethodInterceptor {
    private Object target;// 目标对象

    public ProxyFactory(Object target) {
        this.target = target;
    }

    public Object getProxyInstance() {
        // 创建Enhancer对象化，类似于动态代理中的Proxy
        Enhancer enhancer = new Enhancer();
        // 设置目标类的字节码文件
        enhancer.setSuperclass(target.getClass());
        // 设置回调函数，this 指代当前类的实例ProxyFactory 也是实现了Callback接口
        enhancer.setCallback(this);
        // 创建代理对象
        Object o = enhancer.create();// 创建代理对象
        return o;
    }

    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        service1();
        service2();
        service3();
        Object returnVal = method.invoke(target, objects);
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
