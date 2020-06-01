package cn.yhs.learn.dynamicproxy.demo2;

/**
 * @ProjectName: design-pattern
 * @Name: cn.yhs.learn.dynamicproxy.demo2.VipLoveMovie
 * @Author: Splendor -- 加油,你是最棒的 ~_~
 * @Email: 15617577080@163.com
 * @Time: 2020/6/1 10:14
 * @Description: todo
 **/
public class VipLoveMovie implements VipMovie {

    public void vipMovie() {
        System.out.println("播放vip级别的电影");
    }
}
