# 单例设计模式

## 1.模式介绍

所谓的单例设计模式，就是采取一定的方法保证整个软甲系统中，对某个类只能存在一个对象实例，并且该类只提供一个取得其对象实例的方法（静态方法）

## 2.八种方式

- **饿汉式（静态常量）**

  ```java
  /**
   * 优缺点：
   *  优点：写法简单，就是在类装载的时候就完成了实例化，避免了线程同步问题
   *  缺点：一上来就创建对象，没有懒加载的效果，如果对象没使用，就会造成内存浪费
   *  总结：写法简单，模式可用，没有懒加载，可能造成内存浪费
   */
  class Singleton {
      // 静态常量
      private final static Singleton singleton = new Singleton();
  
      // 构造器私有化，不让外界创建对象
      private Singleton() {
  
      }
  
      // 对外提供公共的静态方法创建对象实例
      public static Singleton instance() {
          return singleton;
      }
  
  }
  ```

- **饿汉式（静态代码块）**

  ```java
  /**
   *  优缺点和第一种一样：模式可用，可能造成内存浪费
   */
  class Singleton {
      private static Singleton singleton;
  
      // 静态代码块中实例化
      static {
          singleton = new Singleton();
      }
  
      private Singleton() {
      }
  
      public static Singleton instance() {
          return singleton;
      }
  }
  ```

- 懒汉式（线程不安全）

  ```java
  /**
   * 懒汉式（线程不安全），当使用到这个对象时，才会去创建对象
   * 优缺点：
   *  优点：当使用时才会去创建，即懒加载的效果，但是只能在单线程下使用
   *  缺点：如果在多线程下，一个线程走到if语句，还没有来得及执行下面语句创建对象语句，另一个线程也刚好走到这个if语句，
   *         这时，便会产生多个实例。
   *  综合：在实际开发中不要使用这种模式，容易造成线程安全问题
   */
  class Singleton {
  
      private static Singleton singleton;
  
      // 构造器私有化，不让外界创建对象
      private Singleton() {
      }
  
      // 对外提供静态的得到对象实例的方法
      public static Singleton getInstance() {
          // 如果对象为null,才进行创建，保证只有一个实例
          if (singleton == null) {
              singleton = new Singleton();
          }
          return singleton;
      }
  }
  ```

- 懒汉式（线程安全，同步方法）

- 懒汉式（线程安全，同步代码块）

- **双重检查**

- **静态内部类**

- **枚举**

  