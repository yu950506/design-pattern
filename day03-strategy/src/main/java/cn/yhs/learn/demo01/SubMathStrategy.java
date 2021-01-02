package cn.yhs.learn.demo01;

/**
 * @ProjectName: design-pattern
 * @Name: cn.yhs.learn.demo01.SubMathStrategy
 * @Author: Splendor -- 加油,你是最棒的 ~_~
 * @Email: 15617577080@163.com
 * @Time: 2021/1/2 16:50
 * @Description: todo
 **/
public class SubMathStrategy implements MathStrategy {
    @Override
    public void doOperation(int num1, int num2) {
        System.out.println("这是减法的策略实现");
        System.out.println(num1 + " - " + num2 + " = " + (num1 - num2));
    }
}
