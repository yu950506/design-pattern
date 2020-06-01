package cn.yhs.learn.cglibproxy.demo1;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import java.lang.reflect.Method;

/**
 * @ProjectName: design-pattern
 * @Name: cn.yhs.learn.ProxyFactory
 * @Author: Splendor -- 加油,你是最棒的 ~_~
 * @Email: 15617577080@163.com
 * @Time: 2020/5/31 23:37
 * @Description: todo
 **/

/**
 * public interface MethodInterceptor extends Callback {}
 * 使用cglib实现动态代理，实现MethodInterceptor接口，同时也是Callback的子接口
 */
public class ProxyFactory implements MethodInterceptor {
    // 维护一个目标对象
    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    // 返回一个目标对象的代理对象
    public Object getProxyInstance() {
        // 1. 创建Enhancer对象，类似于JDK动态代理的Proxy类，下一步就是设置几个参数
        Enhancer enhancer = new Enhancer();
        // 2. 设置目标对象的字节码文件
        enhancer.setSuperclass(target.getClass());
        // 3. 设置回调函数，this指代当前类（ProxyFactory也是间接实现Callback）， public void setCallback(Callback callback)，
        enhancer.setCallback(this);
        // 4. 创建子类对象，即一个代理对象
        return enhancer.create();
    }

    // 会调用目标对象的方法
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("使用cglib代理方法进行增强");
        System.out.println("method name:" + method.getName());
        System.out.println("method args:" + objects);
        Object returnVal = method.invoke(target, objects);
        System.out.println("方法调用的返回值是" + returnVal);
        System.out.println("方法增强结束之后");
        return returnVal;
    }
}
