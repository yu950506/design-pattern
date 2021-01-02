package cn.yhs.learn.demo01;

/**
 * @ProjectName: design-pattern
 * @Name: cn.yhs.learn.demo01.MathStrategy
 * @Author: Splendor -- 加油,你是最棒的 ~_~
 * @Email: 15617577080@163.com
 * @Time: 2021/1/2 16:46
 * @Description: 定义一个策略接口
 **/
public interface MathStrategy {
    /**
     * 策略里面的方法
     *
     * @param num1
     * @param num2
     */
    void doOperation(int num1, int num2);
}
