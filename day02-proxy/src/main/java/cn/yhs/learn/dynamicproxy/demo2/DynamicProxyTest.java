package cn.yhs.learn.dynamicproxy.demo2;

import cn.yhs.learn.staticproxy.demo2.LoveMovie;
import cn.yhs.learn.staticproxy.demo2.Movie;

import java.lang.reflect.Proxy;

/**
 * @ProjectName: design-pattern
 * @Name: cn.yhs.learn.dynamicproxy.demo2.DynamicProxyTest
 * @Author: Splendor -- 加油,你是最棒的 ~_~
 * @Email: 15617577080@163.com
 * @Time: 2020/6/1 10:19
 * @Description: todo
 **/
public class DynamicProxyTest {
    public static void main(String[] args) {
        VipLoveMovie vipLoveMovie = new VipLoveMovie();
        DynamicProxyMovie dynamicProxyMovie = new DynamicProxyMovie(vipLoveMovie);
        VipMovie instance = (VipMovie) Proxy.newProxyInstance(vipLoveMovie.getClass().getClassLoader(), vipLoveMovie.getClass().getInterfaces(), dynamicProxyMovie);
        instance.vipMovie();
        System.out.println("---------------");
        LoveMovie loveMovie = new LoveMovie();
        DynamicProxyMovie dynamicProxyMovie1 = new DynamicProxyMovie(loveMovie);
        Movie o = (Movie) Proxy.newProxyInstance(loveMovie.getClass().getClassLoader(), loveMovie.getClass().getInterfaces(), dynamicProxyMovie1);
        o.play();

/**
 * 我们通过 Proxy.newProxyInstance() 方法，却产生了 Movie和 VIPMovie两种接口的实现类代理，这就是动态代理的魔力。
 */
    }
}
