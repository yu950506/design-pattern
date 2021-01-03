package cn.yhs.learn.prototype;

/**
 * @ProjectName: design-pattern
 * @Name: cn.yhs.learn.prototype.Sheep
 * @Author: Splendor -- 加油,你是最棒的 ~_~
 * @Email: 15617577080@163.com
 * @Time: 2021/1/3 15:03
 * @Description: todo
 **/
public class Sheep implements Cloneable {
    private String name;
    private int age;
    private Sheep sheep;

    public Sheep getSheep() {
        return sheep;
    }

    public void setSheep(Sheep sheep) {
        this.sheep = sheep;
    }

    public Sheep() {
    }

    public Sheep(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Sheep{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sheep=" + sheep +
                '}';
    }


    @Override
    protected Object clone() throws CloneNotSupportedException {
        Sheep sheep = null;
        sheep = (Sheep) super.clone(); // 调用父类的方法为其克隆
        return sheep;
    }
}
