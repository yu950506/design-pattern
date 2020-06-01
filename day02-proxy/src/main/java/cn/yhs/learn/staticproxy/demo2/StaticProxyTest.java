package cn.yhs.learn.staticproxy.demo2;

/**
 * @ProjectName: design-pattern
 * @Name: cn.yhs.learn.staticproxy.demo2.StaticProxyTest
 * @Author: Splendor -- 加油,你是最棒的 ~_~
 * @Email: 15617577080@163.com
 * @Time: 2020/6/1 10:09
 * @Description: todo
 **/
public class StaticProxyTest {
    public static void main(String[] args) {
        LoveMovie loveMovie = new LoveMovie();
        CinemaStaticProxy cinemaStaticProxy = new CinemaStaticProxy(loveMovie);
        cinemaStaticProxy.play();
    }
}
