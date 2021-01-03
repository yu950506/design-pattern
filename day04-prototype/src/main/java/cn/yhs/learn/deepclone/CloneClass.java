package cn.yhs.learn.deepclone;

import java.io.*;

/**
 * @ProjectName: design-pattern
 * @Name: cn.yhs.learn.deepclone.CloneClass
 * @Author: Splendor -- 加油,你是最棒的 ~_~
 * @Email: 15617577080@163.com
 * @Time: 2021/1/3 15:26
 * @Description: todo
 **/
public class CloneClass implements Cloneable, Serializable {
    private String name;
    private int age;
    private CloneClassTarget cloneClassTarget;

    public CloneClass() {
    }

    public CloneClass(String name, int age, CloneClassTarget cloneClassTarget) {
        this.name = name;
        this.age = age;
        this.cloneClassTarget = cloneClassTarget;
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

    public CloneClassTarget getCloneClassTarget() {
        return cloneClassTarget;
    }

    public void setCloneClassTarget(CloneClassTarget cloneClassTarget) {
        this.cloneClassTarget = cloneClassTarget;
    }

    /**
     * 深拷贝
     *
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        CloneClass o = null;
        o = (CloneClass) super.clone();
        o.cloneClassTarget = (CloneClassTarget) cloneClassTarget.clone();
        return o;
    }

    @Override
    public String toString() {
        return "CloneClass{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", cloneClassTarget=" + cloneClassTarget +
                '}';
    }

    public Object deepClone() throws IOException {
        ByteArrayInputStream bis = null;
        ObjectInputStream ois = null;
        ByteArrayOutputStream bos = null;
        ObjectOutputStream oos = null;
        try {
            bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);
            oos.writeObject(this);
            bis = new ByteArrayInputStream(bos.toByteArray());
            ois = new ObjectInputStream(bis);
            Object o = ois.readObject();
            return o;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            ois.close();
            bis.close();
            oos.close();
            ois.close();

        }


    }
}
