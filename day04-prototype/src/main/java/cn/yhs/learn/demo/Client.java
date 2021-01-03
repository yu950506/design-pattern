package cn.yhs.learn.demo;

/**
 * @ProjectName: design-pattern
 * @Name: cn.yhs.learn.demo.Client
 * @Author: Splendor -- 加油,你是最棒的 ~_~
 * @Email: 15617577080@163.com
 * @Time: 2021/1/3 14:59
 * @Description: 演示原型模式
 **/
public class Client {
    public static void main(String[] args) {
        Sheep tom = new Sheep("TOM", 18);
        Sheep sheep1 = new Sheep(tom.getName(), tom.getAge());
        Sheep sheep2 = new Sheep(tom.getName(), tom.getAge());
        Sheep sheep3 = new Sheep(tom.getName(), tom.getAge());
        Sheep sheep4 = new Sheep(tom.getName(), tom.getAge());
        Sheep sheep5 = new Sheep(tom.getName(), tom.getAge());
        System.out.println("sheep5 = " + sheep5);
        System.out.println("sheep4 = " + sheep4);
        System.out.println("sheep3 = " + sheep3);
        System.out.println("sheep2 = " + sheep2);
        System.out.println("sheep1 = " + sheep1);
        System.out.println("tom = " + tom);
        System.out.println(tom == sheep1); // false
        System.out.println(sheep1 == sheep2); // false
    }
}
