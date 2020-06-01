package cn.yhs.learn.staticproxy.demo1;

/**
 * @ProjectName: design-pattern
 * @Name: cn.yhs.learn.staticproxy.StaticProxyTest
 * @Author: Splendor -- 加油,你是最棒的 ~_~
 * @Email: 15617577080@163.com
 * @Time: 2020/5/31 20:16
 * @Description: todo
 **/
public class StaticProxyTest {
    public static void main(String[] args) {
        // 创建目标对象
        TeacherDaoImp teacherDaoImp = new TeacherDaoImp();
        // 创建代理对象，并将目标对象传递过去
        TeacherProxy teacherProxy = new TeacherProxy(teacherDaoImp);
        teacherProxy.teach();
    }
}
