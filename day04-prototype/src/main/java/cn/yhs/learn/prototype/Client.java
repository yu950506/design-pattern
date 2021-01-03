package cn.yhs.learn.prototype;

/**
 * @ProjectName: design-pattern
 * @Name: cn.yhs.learn.prototype.Client
 * @Author: Splendor -- 加油,你是最棒的 ~_~
 * @Email: 15617577080@163.com
 * @Time: 2021/1/3 15:08
 * @Description: todo
 **/
public class Client {
    public static void main(String[] args) throws CloneNotSupportedException {
        Sheep sheep = new Sheep("jack", 22);
        sheep.setSheep(new Sheep("tom", 18));
        Sheep clone = (Sheep) sheep.clone();
        Sheep clone1 = (Sheep) sheep.clone();
        Sheep clone2 = (Sheep) sheep.clone();
        System.out.println(sheep);
        System.out.println(clone+"==>"+clone.getSheep().hashCode());
        System.out.println(clone1+"==>"+clone1.getSheep().hashCode());
        System.out.println(clone2+"==>"+clone2.getSheep().hashCode());

        System.out.println(sheep == clone);
        System.out.println(clone == clone1);
    }
}
