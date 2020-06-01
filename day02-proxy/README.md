# 代理模式

## 1.模式介绍

1. 为一个对象提供一个替身，一控制对这个对象的访问。即通过代理对象访问目标对象，这样做的好处是：可以在目标对象实现的基础上，增强额外的功能操作，即扩展目标对象的功能。
2. 被代理的对象可以是远程对象，创建开销大的对象或者是需要安全控制的对象。
3. 代理有不同的形式体现，主要有三种：**静态代理**、**动态代理**（jdk代理，基于接口代理）、**Cglib代理**（基于子类代理）。

## 2.静态代理

### 2.1 介绍

静态代理在使用时，需要定义接口或者父类，被代理对象（目标对象）与代理对象实现相同的接口或者继承相同的父类

### 2.2 代码演示

```java
// 接口，目标对象和代理对象都要实现这个接口
public interface TeacherDao {
    void teach();// 教书的方法
}

// 目标对象类
public class TeacherDaoImp implements TeacherDao {
    public void teach() {
        System.out.println("教课中。。。");
    }
}

// 代理对象类
public class TeacherProxy implements TeacherDao {

    // 目标对象,通过接口来进行聚合
    private TeacherDao target;

    public TeacherProxy(TeacherDao target) {
        this.target = target; // 给目标对象赋值
    }
	// 在目标对象实现的基础上，增强额外的功能操作，即扩展目标对象的功能。
    public void teach() {
        System.out.println("代理对象对目标对象的方法进行增强");
        System.out.println("开启事务");
        target.teach();
        System.out.println("关闭事务");// 这里也可以调用方法
    }
}
// 静态代理测试类
public class StaticProxyTest {
    public static void main(String[] args) {
        // 创建目标对象
        TeacherDaoImp teacherDaoImp = new TeacherDaoImp();
        // 创建代理对象，并将目标对象传递过去
        TeacherProxy teacherProxy = new TeacherProxy(teacherDaoImp);
        teacherProxy.teach();
    }
}
```

### 2.3 优缺点

- 优点：在不修改目标对象的功能前提下，能通过代理对象对目标对象进行功能的扩展。
- 缺点：代理对象需要与目标对象实现一样的接口,所以会有很多代理类,类太多.同时,一旦接口增加方法,目标对象与代理对象都要维护。

## 3.动态代理

### 3.1 介绍

与静态代理类对照的是动态代理类，动态代理类的字节码在程序运行时由Java反射机制动态生成，无需程序员手工编写它的源代码。动态代理类不仅简化了编程工作，而且提高了软件系统的可扩展性，因为Java 反射机制可以生成任意类型的动态代理类。`java.lang.reflect` 包中的Proxy类和`InvocationHandler` 接口提供了生成动态代理类的能力。代理对象不需要实现接口，但是目标对象要实现接口，否则不能用动态代理。

### 3.2 代码演示

```java
// 接口
public interface TeacherDao {
    void teacher();
    int sayHello(String name);
}

// 被代理的对象（目标对象）
public class TeacherDaoImpl implements TeacherDao {
    @Override
    public void teacher() {
        System.out.println("教课中，，，");
    }

    @Override
    public int sayHello(String name) {
        System.out.println("Hello "+name);
        return 100;
    }
}
// ---------下面这个是动态代理生成类-------------
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
                    // 调用目标对象中的任何一个方法都会走这个方法
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

// 动态代理测试类
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
```

### 3.3 优缺点

- 优点:代理对象不需要实现接口，可以动态的生成任意对象的代理对象，对目标对象中的方法进行扩展和增强。动态代码涉及了一个非常重要的类 `Proxy`。正是通过 `Proxy` 的静态方法 `newProxyInstance` 才会动态创建代理。

## 4.Cglib代理

### 4.1 介绍

静态代理和动态代理都要求目标对象实现一个接口，但是有时候目标对象就是一个单独的对象，并没有实现任何接口，这个时候就可以使用目标对象子类来实现这种代理-这就是Cglib代理，也被称作是子类代理。它是在内存中构建一个子类对象，从而实现对目标对象的扩展。

### 4.2 代码演示

```xml
<!-- 1.导入cglib相关的jar包 -->
<!-- https://mvnrepository.com/artifact/cglib/cglib -->
    <dependency>
        <groupId>cglib</groupId>
        <artifactId>cglib</artifactId>
        <version>2.2.2</version>
    </dependency>
```

```java
// 被代理对象，目标对象，是一个类
public class Teacher {
    public void teach() {
        System.out.println("教书。。。");
    }
}

// ------------------cglib代理类-----------------------
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import java.lang.reflect.Method;
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

    // 会调用目标对象的方法，intercept方法内容正好就是代理类中的方法体。
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

// 测试类
public class CglibTest {
    public static void main(String[] args) {
        Teacher t = new Teacher();
        ProxyFactory proxyFactory = new ProxyFactory(t);
        Teacher instance = (Teacher) proxyFactory.getProxyInstance();
         instance.teach();
    }
}
```

### 4.3 优缺点

- 用Cglib生成代理类是目标类的子类，不需要实现接口。
- Cglib是一个强大的,高性能,高质量的Code生成类库。它可以在运行期扩展Java类与实现Java接口。它广泛的被许多AOP的框架使用，如Spring AOP,实现方法的拦截。
- Cglib包的底层是通过使用字节码处理框架ASM来转换字节码并生成新的类。

## 5.总结

- 代理模式本质上的目的是为了增强现有代码的功能。
- 代理分为静态代理和动态代理两种
- 静态代理，代理类需要自己编写代码写成。
- 动态代理有JDK和Cglib，代理类通过 `Proxy.newInstance()`或者`ASM` 生成。
- 在AOP编程中如何选择代理模式：
  	1. 目标对象需要实现接口：用JDK代理
   	2. 目标对象不需要实现接口：用Cglib代理

