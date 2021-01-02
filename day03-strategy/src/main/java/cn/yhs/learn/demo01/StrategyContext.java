package cn.yhs.learn.demo01;

/**
 * @ProjectName: design-pattern
 * @Name: cn.yhs.learn.demo01.StrategyContext
 * @Author: Splendor -- 加油,你是最棒的 ~_~
 * @Email: 15617577080@163.com
 * @Time: 2021/1/2 16:52
 * @Description: 策略容器
 **/
public class StrategyContext {
    private MathStrategy strategy;

    /**
     *  构造器将策略算法注入进来
     * @param mathStrategy
     */
    public StrategyContext(MathStrategy mathStrategy) {
        this.strategy = mathStrategy;
    }

    /**
     * 更具注入的策略算法实现特有的策略
     *
     * @param num1
     * @param num2
     */
    public void executeOperation(int num1, int num2) {
        strategy.doOperation(num1, num2);
    }

}
