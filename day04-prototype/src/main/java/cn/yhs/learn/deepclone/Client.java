package cn.yhs.learn.deepclone;

import java.io.IOException;

/**
 * @ProjectName: design-pattern
 * @Name: cn.yhs.learn.deepclone.Client
 * @Author: Splendor -- 加油,你是最棒的 ~_~
 * @Email: 15617577080@163.com
 * @Time: 2021/1/3 15:32
 * @Description: todo
 **/
public class Client {
    public static void main(String[] args) throws CloneNotSupportedException, IOException {
        CloneClass cloneClass = new CloneClass("Hello", 18, new CloneClassTarget(188));
        // 深拷贝之Object的clone方法
        CloneClass clone = (CloneClass) cloneClass.clone();
        CloneClass clone1 = (CloneClass) cloneClass.clone();
        System.out.println(cloneClass);
        System.out.println("clone = " + clone +"==>"+clone.getCloneClassTarget().hashCode());
        System.out.println("clone1 = " + clone1 +"==>"+clone1.getCloneClassTarget().hashCode());
        // 深拷贝之序列化的方式
        CloneClass o = (CloneClass)clone.deepClone();
        CloneClass o1 = (CloneClass)clone.deepClone();
        System.out.println("o1 = " + o1+"==>"+o1.getCloneClassTarget().hashCode());
        System.out.println("o = " + o+"==>"+o.getCloneClassTarget().hashCode());
    }
}
