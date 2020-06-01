package cn.yhs.learn.staticproxy.demo1;

/**
 * @ProjectName: design-pattern
 * @Name: cn.yhs.learn.staticproxy.impl.TeacherDaoImp
 * @Author: Splendor -- 加油,你是最棒的 ~_~
 * @Email: 15617577080@163.com
 * @Time: 2020/5/31 20:12
 * @Description: todo
 **/

/**
 * 代理模式中的目标对象
 */
public class TeacherDaoImp implements TeacherDao {
    public void teach() {
        System.out.println("教课中。。。");
    }
}
