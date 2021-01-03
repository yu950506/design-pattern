package cn.yhs.learn.deepclone;

import java.io.Serializable;

/**
 * @ProjectName: design-pattern
 * @Name: cn.yhs.learn.deepclone.CloneClassTarget
 * @Author: Splendor -- 加油,你是最棒的 ~_~
 * @Email: 15617577080@163.com
 * @Time: 2021/1/3 15:26
 * @Description: todo
 **/
public class CloneClassTarget implements Cloneable, Serializable {
    private int age;

    public CloneClassTarget() {
    }

    public CloneClassTarget(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "CloneClassTarget{" +
                "age=" + age +
                '}';
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
