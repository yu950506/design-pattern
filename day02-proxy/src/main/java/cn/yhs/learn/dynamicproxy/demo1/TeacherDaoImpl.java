package cn.yhs.learn.dynamicproxy.demo1;

/**
 * @ProjectName: design-pattern
 * @Name: cn.yhs.learn.dynamicproxy.TeacherDaoImpl
 * @Author: Splendor -- 加油,你是最棒的 ~_~
 * @Email: 15617577080@163.com
 * @Time: 2020/5/31 20:49
 * @Description: todo
 **/
// 被代理的对象（目标对象）
public class TeacherDaoImpl implements TeacherDao {
    public void teacher() {
        System.out.println("教课中，，，");
    }


    public int sayHello(String name) {
        System.out.println("Hello "+name);
        return 100;
    }
}
