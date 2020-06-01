package cn.yhs.learn.staticproxy.demo1;

/**
 * @ProjectName: design-pattern
 * @Name: cn.yhs.learn.staticproxy.TeacherProxy
 * @Author: Splendor -- 加油,你是最棒的 ~_~
 * @Email: 15617577080@163.com
 * @Time: 2020/5/31 20:12
 * @Description: todo
 **/

/**
 * 静态代理优缺点：
 * 优点：在不改变目标对象方法的前提下，对目标方法进行增强：比如权限验证，事务控制。。。
 * 缺点：因为代理对象需要和目标对象实现一样的接口，所以会有很多代理类，一旦接口增加方法，目标对象和代理对象都要维护
 */

// 代理对象
public class TeacherProxy implements TeacherDao {

    // 目标对象,通过接口来进行聚合
    private TeacherDao target;

    public TeacherProxy(TeacherDao target) {
        this.target = target; // 给目标对象赋值
    }

    public void teach() {
        System.out.println("代理对象对目标对象的方法进行增强");
        System.out.println("开启事务");
        target.teach();
        System.out.println("关闭事务");
    }
}
