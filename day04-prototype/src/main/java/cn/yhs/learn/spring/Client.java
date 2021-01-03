package cn.yhs.learn.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ProjectName: design-pattern
 * @Name: cn.yhs.learn.spring.Client
 * @Author: Splendor -- 加油,你是最棒的 ~_~
 * @Email: 15617577080@163.com
 * @Time: 2021/1/3 15:21
 * @Description: todo
 **/
public class Client {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Sheep sheep = (Sheep) context.getBean("sheep");
        Sheep sheep1 = (Sheep) context.getBean("sheep");
        System.out.println("sheep = " + sheep);
        System.out.println("sheep1 = " + sheep1);
        System.out.println(sheep == sheep1);

    }
}
