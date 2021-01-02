package cn.yhs.learn.demo01;

/**
 * @ProjectName: design-pattern
 * @Name: cn.yhs.learn.demo01.Demo
 * @Author: Splendor -- 加油,你是最棒的 ~_~
 * @Email: 15617577080@163.com
 * @Time: 2021/1/2 16:55
 * @Description: todo
 **/
public class Demo {
    public static void main(String[] args) {
        int num1 = 10;
        int num2 = 15;
        StrategyContext strategyContext = new StrategyContext(new AddMathStrategy());
        strategyContext.executeOperation(num1, num2);
        strategyContext = new StrategyContext(new SubMathStrategy());
        strategyContext.executeOperation(num1, num2);
    }
}
