package cn.yhs.learn.staticproxy.demo2;

/**
 * @ProjectName: design-pattern
 * @Name: cn.yhs.learn.staticproxy.demo2.CinemaStaticProxy
 * @Author: Splendor -- 加油,你是最棒的 ~_~
 * @Email: 15617577080@163.com
 * @Time: 2020/6/1 10:05
 * @Description: todo
 **/
public class CinemaStaticProxy implements Movie {
    private Movie target;// 目标对象

    public CinemaStaticProxy(Movie target) {
        this.target = target;
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

    public void play() {
        // 代理对象可以为目标对象进行增强
        service1();// 提供服务
        service2();
        target.play();// 实际上调用目标对象的方法
        service3();
    }
}
