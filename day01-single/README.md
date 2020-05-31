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

  ```java
  /**
   * 懒汉式（线程安全），使用同步方法解决
   * 优缺点：
   *  优点：当使用时才会去创建，即懒加载的效果，另外使用同步方法解决了线程安全问题
   *  缺点：效率太低了，每个线程都要获取实例的时候都要走同步方法，但是这个方法执行了一次实例化代码就可以了
   *          后面想获取该实例，直接return就好，方法进行同步，效率太低
   *  综合：在实际开发中不要使用这种模式，效率太低
   */
  class Singleton {
      private static Singleton singleton;
  
      private Singleton() {
      }
  
      // 同步方法解决线程安全问题，但是效率低
      public static synchronized Singleton instance() {
          if (singleton == null) {
              singleton = new Singleton();
          }
          return singleton;
      }
  }
  ```

- 懒汉式（线程安全，同步代码块）

  ```java
  /**
   * 懒汉式（线程安全），使用同步代码块解决
   * 优缺点：
   * 优点：当使用时才会去创建，即懒加载的效果，另外使用同步代码块解决了线程安全问题，实际上并没有解决
   * 缺点：是懒汉式同步方法的另一种写法，实际上并没哟解决线程安全问题，
   * 综合：在实际开发中不要使用这种模式，不推荐
   */
  class Singleton {
      private static Singleton singleton;
  
      private Singleton() {
      }
  
      // 使用同步代码块解决线程安全问题，实际上并没有解决，一个线程走到if语句，另一个线程在同步代码块，还是没有解决，这里只是对同步方法的另一种方式的提现，有人这样写过。
      public static Singleton instance() {
          if (singleton == null) {
              synchronized (Singleton.class) {
                  singleton = new Singleton();
              }
          }
          return singleton;
      }
  }
  ```

- **双重检查**

  ```java
  /**
   * 懒汉式（线程安全），双重检查
   * 优缺点：
   * 优点：双重检查是多线程中常用到的，如代码中所示，我们进行了两次if()检查，这样就保证了线程安全，实例化代码
   *      执行了一次，后面再访问时，判断第一个if，直接return实例化对象，也避免了反复进行方法同步
   *      线程安全，延迟加载，效率高
   * 综合：推荐使用
   */
  class Singleton {
      // volatile 实现线程各自的数据立马同步到主存
      private static volatile Singleton singleton;
  
      private Singleton() {
      }
  
      // 同步代码块中再加上if判断，实现双重检查，既保证了线程安全问题，又实现了懒加载,同时保证了效率
      public static synchronized Singleton instance() {
          if (singleton == null) {
              synchronized (Singleton.class) {
                  if (singleton == null) {
                      singleton = new Singleton();
                  }
              }
          }
          return singleton;
      }
  }
  ```

- **静态内部类**

  ```java
  /**
   * 静态内部类
   * 优缺点：
   * 优点：①采用了类装载机制来保证初始化实例对象只有一个线程，
   *      ②静态内部类在外部类装载时并不会立即实例化，而是在需要实例化时调用instance()方法，才回装载内部类，从而完成外部类的实例化
   *      ③类的静态属性只会在第一次装载类的时候实例化，所以这里JVM帮助我们保证了线程的安全性，在类进行实例化时，别的线程无法进入
   *      ④延迟加载，线程安全，效率高
   * 综合：推荐使用
   */
  class Singleton {
      private static Singleton singleton;
  
      private Singleton() {
  
      }
  
      // 静态内部类,该类只有一个静态属性INSTANCE
      private static class SingletonInstance {
          private static final Singleton INSTANCE = new Singleton();
      }
  
      // 提供一个静态的公共方法，直接返回SingletonInstance.INSTANCE
      public static synchronized Singleton instance() {
          return SingletonInstance.INSTANCE;
      }
  }
  ```

- **枚举**

  ```java
  /**
   * 枚举实现
   * 优缺点：
   * 优点： jdk1.5中添加的枚举实现单例模式，不仅能避免多线程的同步问题，而且还能防止反序列化重新创建新对象
   *          是Effective Java作者提倡的方式
   * 综合：推荐使用
   */
  enum Singleton {
      INSTANCE; // 属性
  }
  ```
  
  
  
  ## 3.单例模式总结
  
  - 单例模式保证了 系统内存中只存在一个对象，节省了系统资源，对于一些需要频繁创建销毁的对象，使用单例模式类提高系统的性能
  - 当想实例化一个单例类的时候，必须记住使用相应获取对象的方法，而不是new
  - 推荐使用：双重检查、静态内部类
  
  ## 4. 单例模式使用场景
  
  需要频繁的创建和次销毁对象、创建对象耗时过多或者耗费资源过多（重量级对象），但又经常用到的对象、工具类对数据库或者文件的对象（数据源，session工厂等）
  
  ## 5. 源码体现
  
  ### 5.1 java.lang.Runtime 就是一个饿汉式的单例体现
  
  ```java
  public class Runtime {
      private static Runtime currentRuntime = new Runtime();
  
      /**
       * Returns the runtime object associated with the current Java application.
       * Most of the methods of class <code>Runtime</code> are instance
       * methods and must be invoked with respect to the current runtime object.
       *
       * @return  the <code>Runtime</code> object associated with the current
       *          Java application.
       */
      public static Runtime getRuntime() {
          return currentRuntime;
      }
  
      /** Don't let anyone else instantiate this class */
      private Runtime() {}
  }
  ```
  
  
  
  
  
  