# Java 服务端核心技术

## 基础篇
### Java 基本功
* 面向对象的三大特征
    > <h4>1.封装</h4>
        所谓封装，也就是把客观事物封装成抽象的类，并且类可以把自己的数据和方法只让可信的类或者对象操作，
        对不可信的进行信息隐藏。<br>
      <h4>2.继承</h4>
        继承是指这样一种能力：它可以使用现有类的所有功能，并在无需重新编写原来的类的情况下对这些功能进
        行扩展。<br>
      <h4>3.多态</h4>
        所谓多态就是指一个类实例的相同方法在不同情形有不同表现形式。多态机制使具有不同内部结构的对象可
        以共享相同的外部接口。<br>
* 面向对象的五大原则
    > <h4>1.单一职责原则</h4>
        一个类应该仅有一个引起它变化的原因<br>
      <h4>2.开放封闭原则</h4>
        对扩展是开放的，对更改是封闭的！<br>
      <h4>3.里氏替换原则</h4>
        子类可以替换父类并且出现在父类能够出现的任何地方,贯彻 GOF 倡导的面向接口编程<br>
      <h4>4.依赖倒置原则</h4>
        传统的结构化编程中，最上层的模块通常都要依赖下面的子模块来实现，也称为高层依赖低层！<br>
        <br>
        所以 DIP 原则就是要逆转这种依赖关系，让高层模块不要依赖低层模块，所以称之为依赖倒置原则！<br>
      <h4>5.ISP 接口隔离原则</h4>
        使用多个专门的接口比使用单个接口要好的多！<br>
* final, finally, finalize 的区别
    > final 用于声明属性，方法和类，分别表示属性不可变性，方法不可覆盖，类不可继承。<br>
      <br>
      finally 是异常处理语句结构的一部分，表示总是执行。<br>
      <br>
      finalize 是 Object 类的一个方法，在垃圾收集器执行的时候会调用被回收对象的此方法，供垃圾收
      集时的其他资源回收，例如关闭文件等。<br>
* int 和 Integer 有什么区别
    > 1.int 是基本的数据类型<br>
      2.Integer 是 int 的封装类<br>
      3.int 和 Integer 都可以表示某一个数值<br>
      4.int 和 Integer 不能够互用，因为他们是两种不同的数据类型<br>
* 重载和重写的区别
    > <h4>重载</h4>
      1.重载(overloading) 是在一个类里面，方法名字相同，而参数不同。返回类型可以相同也可以不同。<br>
      2.每个重载的方法（或者构造函数）都必须有一个独一无二的参数类型列表。<br>
      3.最常用的地方就是构造器的重载。<br>
      <h4>重载规则</h4>
      1.被重载的方法必须改变参数列表(参数个数或类型不一样)；<br>
      2.被重载的方法可以改变返回类型；<br>
      3.被重载的方法可以改变访问修饰符；<br>
      4.被重载的方法可以声明新的或更广的检查异常；<br>
      5.方法能够在同一个类中或者在一个子类中被重载。<br>
      6.无法以返回值类型作为重载函数的区分标准。<br>
      <h4>重写</h4>
      1.重写是子类对父类的允许访问的方法的实现过程进行重新编写, 返回值和形参都不能改变。
        **即外壳不变，核心重写！**<br>
      2.重写的好处在于子类可以根据需要，定义特定于自己的行为。 也就是说子类能够根据需要实现父类的方法。<br>
      3.重写方法不能抛出新的检查异常或者比被重写方法申明更加宽泛的异常。例如： 父类的一个方法申明了一
        个检查异常 IOException，但是在重写这个方法的时候不能抛出 Exception 异常，因为 Exception 是 
        IOException 的父类，只能抛出 IOException 的子类异常。<br>
      <h4>重写规则</h4>
      1.参数列表必须完全与被重写方法的相同；<br>
      2.返回类型必须完全与被重写方法的返回类型相同；<br>
      3.访问权限不能比父类中被重写的方法的访问权限更低。例如：如果父类的一个方法被声明为 public，那么
        在子类中重写该方法就不能声明为 protected。<br>
      4.父类的成员方法只能被它的子类重写。<br>
      5.声明为 final 的方法不能被重写。<br>
      6.声明为 static 的方法不能被重写，但是能够被再次声明。<br>
      7.子类和父类在同一个包中，那么子类可以重写父类所有方法，除了声明为 private 和 final 的方法。<br>
      8.子类和父类不在同一个包中，那么子类只能够重写父类的声明为 public 和 protected 的非 final 方法。<br>
      9.重写的方法能够抛出任何非强制异常，无论被重写的方法是否抛出异常。但是，重写的方法不能抛出新的
        强制性异常，或者比被重写方法声明的更广泛的强制性异常，反之则可以。<br>
      10.构造方法不能被重写。<br>
      11.如果不能继承一个方法，则不能重写这个方法。<br>
* 抽象类和接口有什么区别
    > [链接](http://www.importnew.com/12399.html)
* 说说反射的用途及实现
    > <h4>1.什么是反射？</h4>
        Reflection 是 Java 程序开发语言的特征之一，它允许运行中的 Java 程序获取自身的信息，
        并且可以操作类和对象的内部属性。<br>
      <h4>2.java 反射框架提供以下功能：</h4>
        1) 在运行时判断任意一个对象所属的类<br>
        2) 在运行时构造任意一个类的对象<br>
        3) 在运行时判断任意一个类所具有的成员变量和方法（通过反射设置可以调用 private）<br>
        4) 在运行时调用任何一个对象的方法<br>
      <h4>3.反射的主要用途</h4>
        当我们在使用 IDE（如 Eclipse\IDEA）时，当我们输入一个队长或者类并向调用它的属性和方法时，
        一按 (“.”)点号，编译器就会自动列出她的属性或方法，这里就会用到反射。<br>
        <br>
        反射最重要的用途就是开发各种通用框架。（比如 spring，hibernate，Struts 都是配置化的）<br>
* 说说自定义注解的场景及实现
    > 登陆、权限拦截、日志处理，以及各种 Java 框架，如 Spring，Hibernate，JUnit 提到注解就不能不说反射，Java 自定义注解是通过运行时靠反射获取注解。实际开发中，例如我们要获取某个方法的调用日志，可以通过 AOP（动态代理机制）给方法添加切面，通过反射来获取方法包含的注解，如果包含日志注解，就进行日志记录。反射的实现在 Java 应用层面上讲，是通过对 Class 对象的操作实现的，Class 对象为我们提供了一系列方法对类进行操作。在 JVM 这个角度来说，Class 文件是一组以 8 位字节为基础单位的二进制流，各个数据项目按严格的顺序紧凑的排列在 Class 文件中，里面包含了类、方法、字段等等相关数据。通过对 Class 数据流的处理我们即可得到字段、方法等数据。
* JDBC 流程
    > 1.加载 Driver 类，注册数据库驱动；<br>
      2.通过 DriverManager，使用 url，用户名和密码建立连接(Connection)；<br>
      3.通过 Connection，使用 sql 语句打开 Statement 对象；<br>
      4.执行语句，将结果返回 resultSet；<br>
      5.对结果 resultSet 进行处理；<br>
      6.倒序释放资源 resultSet -> preparedStatement -> connection。<br>
* equals 与 == 的区别
    > Java中的数据类型，可分为两类：<br>
      <h4>1.基本数据类型</h4>
        byte, short, char, int, long, float, double, boolean，他们之间的比较，应用双等号（==），
        比较的是他们的值。<br>
      <h4>2.复合数据类型（类）</h4>
        当他们用（==）进行比较时，比较的是他们在内存中的存放地址，所以，除非是同一个 new 出来的对象，
        他们的比较结果为 true，否则比较结果为 false。<br>
        <br>
        **注意**：JAVA 当中所有的类都是继承于 Object 这个基类的，在 Object 中的基类中定义了一个 equals 的
        方法，这个方法的初始行为是比较对象的内存地 址，但在一些类库当中这个方法被覆盖掉了，如 String,
        Integer, Date 在这些类当中 equals 有其自身的实现，而不再是比较类在堆内存中的存放地址了。<br>
      <h4>3.字符串缓冲池</h4>
        原来，程序在运行的时候会创建一个字符串缓冲池当使用 s2 = "Monday" 这样的表达是创建字符串的时候，程序
        首先会在这个 String 缓冲池中寻找相同值的对象，在第一个程序中，s1 先被放到了池中，所以在 s2 被创建的
        时候，程序找到了具有相同值的 s1，将 s2 引用 s1 所引用的对象 "Monday"。<br>
      <h4>4.String.intern()方法</h4>
        java.lang.String 的 intern() 方法 "abc".intern() 方法的返回值还是字符串 "abc"，表面上看起来好像这
        个方法没什么用处。但实际上，它做了个小动作：检查字符串池里是否存在 "abc" 这么一个字符串，如果存在，
        就返回池里的字符串；如果不存在，该方法会把 "abc" 添加到字符串池中，然后再返回它的引用。<br>
* [IO相关（bio和nio的区别，nio中的ByteBuffer,Selector,Channal）](https://blog.csdn.net/m_xiaoer/article/details/73501825)
    > <h4>BIO 和 NIO 的区别</h4>
      1.BIO 是同步阻塞的，NIO 是同步非阻塞的。<br>
      2.使用 BIO 的时候往往会引入多线程，每个连接一个单独的线程；而 NIO 则是使用单线程或者只使用少量的线程，
      多个连接共用一个线程。<br>
      Java BIO：同步并阻塞，服务器实现模式为一个连接一个线程，即客户端有连接请求时服务器端就需要启动一个线程
      进行处理，如果这个连接不做任何事情会造成不必要的线程开销，当然可以通过线程池机制改善。<br>
      Java NIO：同步非阻塞，服务器实现模式为一个请求一个线程，即客户端发送的连接请求都会注册到多路复用器上，
      多路复用器轮询到连接有 I/O 请求时才启动一个线程进行处理。<br>
      <h4>适用场景</h4>
      BIO 方式适用于连接数目比较小且固定的架构，这种方式对服务器资源要求比较高，并发局限于应用中，JDK1.4 以
      前的唯一选择，但程序直观简单易理解。<br>
      NIO 方式适用于连接数目多且连接比较短（轻操作）的架构，比如聊天服务器，并发局限于应用中，编程比较复杂，
      JDK1.4 开始支持。
      <h4>1、Buffer（缓冲区）</h4>
      使用数组的方式不够灵活且性能差，Java NIO的缓冲区功能更加强大；容量(capacity)表示缓冲区的额定大小，需要在创建时指定（allocate静态方法）；读写限制(limit)表示缓冲区在进行读写操作时的最大允许位置；读写位置(position)表示当前进行读写操作时的位置；缓冲区的很多操作（clear、flip、rewind）都是操作limit和position的值来实现重复读写；
      <h4>2、Channel（通道）</h4>
      channel表示为一个已经建立好的支持I/O操作的实体（如文件和网络）的连接，在此连接上进行数据的读写操作，使用的是缓冲区来实现读写。
      <h4>3、Selector（多路复用器）</h4>
      套接字通道的多路复用的思想比较简单，通过一个专门的选择器（Selector）来同时对多个套接字通道进行监听；当其中的某些套接字通道上有它感兴趣的事件发生时，这些通道就会变为可用状态，可以在选择器的选择操作中被选中；可用通道的选择一般是通过操作系统提供的底层操作系统调用来实现的，性能也比较高。
* [深入理解并发 / 并行，阻塞 / 非阻塞，同步 / 异步](https://juejin.im/entry/58ae4636b123db0052b1caf8)
* [动态加载类的框架了解哪些？](https://www.liaoxuefeng.com/article/0014617596492474eea2227bf04477e83e6d094683e0536000)
    > CGlib 和 javassist
* [动态代理一般有哪几种实现方式？](https://blog.csdn.net/heyutao007/article/details/49738887)
    > jdk动态代理和cglib动态代理。<br>
* 动态代理的应用场景有哪些？
    > 代理的使用场景很多，struts2中的 action 调用， hibernate的懒加载， spring的 AOP无一不用到代理。<br>
    总结起来可分为以下几类： <br>
      1. 在原方法执行之前和之后做一些操作，可以用代理来实现（比如记录Log，做事务控制等）。<br> 
      2. 封装真实的主题类，将真实的业务逻辑隐藏，只暴露给调用者公共的主题接口。 <br>
      3. 在延迟加载上的应用。<br>
* [String、StringBuffer、StringBuilder的区别？对应的使用场景？](https://blog.csdn.net/u013679744/article/details/58605645)
* 如何实现不可变的类？
    > 1.将类声明为final，所以它不能被继承<br>
      2.将所有的成员声明为私有的，这样就不允许直接访问这些成员<br>
      3.对变量不要提供setter方法<br>
      4.将所有可变的成员声明为final，这样只能对它们赋值一次<br>
      5.通过构造器初始化所有成员，进行深拷贝(deep copy)<br>
      6.在getter方法中，不要直接返回对象本身，而是克隆对象，并返回对象的拷贝<br>
* [十道海量数据处理面试题与十个方法大总结](https://blog.csdn.net/v_JULY_v/article/details/6279498)
* [二叉查找树，红黑树，AVL树，B~/B+树(B-tree)，伸展树——优缺点及比较](https://blog.csdn.net/bytxl/article/details/40920165)
* [进程间通信IPC](https://www.jianshu.com/p/c1015f5ffa74)
* [理解滑动窗口算法](https://blog.csdn.net/renhui1993/article/details/72123455)
* [Linux 进程调度浅析](http://blog.jobbole.com/106168/)
* [Linux查看机器负载](https://blog.csdn.net/szchtx/article/details/38455385)
* [输入URL后的处理流程](https://segmentfault.com/a/1190000012092552)

### Java 虚拟机（JVM）
* [JVM 内存模型](http://gityuan.com/2016/01/09/java-memory/)
    > 线程私有的：程序计数器、虚拟机栈、本地方法栈。<br>
      线程共享的：堆， 方法区（包含常量池）。<br>
* [Linux与JVM的内存关系分析](http://www.importnew.com/14486.html)      
* [内存溢出一般发生在哪个区？](https://www.cnblogs.com/xiaoxi/p/7406903.html)
  [永久代会不会导致内存溢出？（OMM）](https://blog.csdn.net/qq_28165595/article/details/79246922)
    > <h4>内存溢出一般发生在哪个区？</h4>
      1.Java 堆溢出<br>
      2.虚拟机栈和本地方法栈溢出<br>
      3.方法区和运行时常量池溢出<br>
      4.直接内存溢出<br>
      <h4>永久代会不会导致内存溢出？</h4>
      会，在jvm中的永久代中主要存放是经过几次GC之后依旧没有被回收的对象，而永久代不是经常进行GC，所以在项目
      运行汇总，如果加载了大量的类，永久代没有及时的回收，就会出现永久代内存溢出。<br>
      <h4>jvm中几个内存参数</h4>
      – -XX:+HeapDumpOnOutofMemoryError，dump的时候转储堆快照 <br>
      – -Xms 堆最小容量(heap min size) <br>
      – -Xmx 堆最大容量(heap max size) <br>
      – -Xss 栈容量(stack size) <br>
      – -XX:PermSize=size 永生代最小容量<br> 
      – -XX:MaxPermSize=size 永生代最大容量<br> 
* 栈会不会溢出？栈溢出一般抛什么异常？jvm在哪里设置栈的大小？设置的参数是什么？
    > 1.会。<br>
      2.如果线程请求的栈深度大于虚拟机所允许的最大深度，将抛出 StackOverflowError 异常；<br>
        如果虚拟机在扩展栈时无法申请到足够的内存空间，则抛出 OutOfMemoryError 异常。<br>
      3.jvm 参数设置栈的大小。<br>
      4.-Xss 参数。<br>
* 用过哪些命令查看jvm的状态、堆栈信息？
    > <h4>1.jmap</h4>
       这个命令是用来查看当前系统中 jvm 进程 heap dump 的情况，包括对象的数量，对象所占内存的大小。<br>
       使用方式：<br>
       1.先使用 jps 查看进程 id；<br>
       2.使用 jmap -dump:live,file=b.map PID 将 live 进程生成 java 堆转储快照；<br>
       使用 jmap -heap PID 生成 java 堆的详细信息；<br>
       使用 jmap -histo PID 生成 java 堆中对象的相关信息，包含数量以及占用的空间大小。<br>
      <h4>2.[jstat](https://blog.csdn.net/zlzlei/article/details/46471627)</h4>
       主要是用来监控 heap size 和 jvm垃圾回收情况，尤其是gc情况的监控，如果老年代发生full gc，那么
       很可能会导致内存泄漏的可能性。
      <h4>jstack</h4>
       jstack用于生成java虚拟机当前时刻的线程快照。
* jvm的垃圾回收机制？
    > <h4>垃圾检测算法</h4>
        1.**引用计数法：** 给对象中添加一个引用计数器，每当有一个地方引用它时，计数器值加1；当引用失效时，计数器
        值减一；任何时刻计数器值为0的对象就是内存垃圾。<br>
          **缺点：** 很难解决对象之间相互循环引用的问题。<br>
        2.**可达性分析：** 通过一系列 GC Roots 的对象作为起始点，开始向下搜索，搜索走过的路径称为引用链，当一个
        对象到 GC Roots 没有任何引用链相连时，则它就是内存垃圾。<br>
          java中可作为**GC Root**的对象有：<br>
        　  * 虚拟机栈中引用的对象（本地变量表）<br>
        　　* 方法区中静态属性引用的对象<br>
        　　* 方法区中常量引用的对象<br>
        　　* 本地方法栈中引用的对象（Native对象）<br>
      <h4>垃圾收集算法</h4>
        1.**标记——清除算法：** 先标记出所有需要回收的对象，在标记完成后统一回收所有被标记的对象。<br>
          **缺点：** 效率不高；会产生大量不连续的空间碎片。<br>
        2.**复制算法：** 应用于回收新生代。<br>
          **缺点：** 空间代价过高。<br>
        3.**标记——整理算法：** 应用于回收老年代。<br>
        4.**分代收集算法：** 不同的对象的生命周期是不一样的。因此，不同生命周期的对象可以采取不同的回收算法，以便提高回收效率。<br>
          **年轻代**<br>
          1.所有新生成的对象首先都是放在新生代中。<br>
          2.新生代内存按照 8:1:1 的比例分为一个 eden 区和两个 survivor 区。<br>
          3.当 survivor1 区不足以存放 eden 区和 survivor0 区的存活对象时，就将存活对象直接放到老年代。若老年代也满，
            就会触发一次 Full GC，也就是新生代、老年代都进行回收。<br>
          4.新生代发生的 GC 也叫做 Minor GC，Minor GC 发生频率比较高（一般是Eden区满了触发）。<br>
          **老年代**<br>
          1.在年轻代中经历 N 次垃圾回收后仍然存活的对象，就会被放到老年代中。<br>
          2.内存比新生代也大很多，当老年代内存满时，触发 Major GC（即 Full GC）。<br>
      <h4>GC（垃圾收集器）</h4>
        新生代收集器使用的收集器：Serial、PraNew、Parallel Scavenge <br>
        老年代收集器使用的收集器：Serial Old、Parallel Old、CMS <br>
        Serial收集器（复制算法）<br>
        　　新生代单线程收集器，标记和清理都是单线程，优点是简单高效。<br>
        Serial Old收集器（标记-整理算法）<br>
        　　老年代单线程收集器，Serial收集器的老年代版本。<br>
        ParNew收集器（停止-复制算法）<br>
        　　新生代收集器，可以认为是Serial收集器的多线程版本,在多核CPU环境下有着比Serial更好的表现。<br>
        Parallel Scavenge收集器(停止-复制算法)<br>
        　　并行收集器，追求高吞吐量，高效利用CPU。吞吐量一般为99%， 吞吐量= 用户线程时间/(用户线程时间+GC线程时间)。
            适合后台应用等对交互响应要求不高的场景。<br>
        Parallel Old收集器(停止-复制算法)<br>
        　　Parallel Scavenge收集器的老年代版本，并行收集器，吞吐量优先<br>
        CMS(Concurrent Mark Sweep)收集器（标记-清理算法）<br>
        　　高并发、低停顿，追求最短GC回收停顿时间，cpu占用比较高，响应时间快，停顿时间短，多核cpu 追求高响应时间的选择<br>
* [java类加载机制？如何实现自定义类加载器？findClass与loadClass的区别？](https://blog.csdn.net/javazejian/article/details/73413292)
* [有哪些破坏双亲委派模式？以及如何破坏？](https://blog.csdn.net/dangwanma6489/article/details/80244981)
    > 破坏双亲委派模式一般需要继承ClassLoader，重写loadClass()和findClass()。<br>
      1.当父类加载器需要子类加载器加载类时，可以使用线程上下文加载器。（如JNDI，JDBC等）<br>
      2.为了实现热插拔，热部署，模块化功能，只需要将被加载的类和类加载器一同换掉就可以实现代码的热替换。（如Tomcat中，当JSP被修改后，不需要重启服务器就可以生成新的类。）<br>
* [G1 和 CMS收集器的区别](http://www.woowen.com/java/2016/12/10/G1%20CMS%E5%8C%BA%E5%88%AB/)
* [jvm调优](https://juejin.im/post/59f02f406fb9a0451869f01c)


### 集合
* List 和 Set 区别
    > List 接口为 Collection 直接接口，List 所代表的是有序的 Collection。实现 List 接口的集合主要有：
      ArrayList、LinkedList、Vector、Stack。<br>
      <br>
      Set 是一种不包括重复元素的 Collection，且无序。实现了 Set 接口的集合有：EnumSet、HashSet、TreeSet。
* List 和 Map 区别
    > Map 与 List、Set 接口不同，它是由一系列键值对组成的集合，提供了 key 到 value 的映射。
      实现 Map 接口的集合有：HashMap、TreeMap、LinkedHashMap、HashTable、EnumMap、Properties。
* Arraylist 与 LinkedList 区别
    > 1.ArrayList 是实现了基于动态数组的数据结构，LinkedList 基于双向链表的数据结构。<br>
      2.对于随机访问 get 和 set，ArrayList 优于 LinkedList，因为 LinkedList 要移动指针。<br>
      3.对于新增和删除操作，add 和 remove，LinkedList 比较占优势，因为 ArrayList 要移动数据。<br>
      如果新增和删除操作比较多，则使用 LinkedList 比较高效；但如果随机访问比较多，则使用 ArrayList 比较好。<br>
* ArrayList 与 Vector 区别
    > 1.Vector 是线程安全的，而 ArrayList 是线程不安全的。<br>
      2.扩容机制不同。Vector 扩容后是扩容前的2倍；ArrayList 扩容后是扩容前的 1.5 倍。<br>
* HashMap 和 Hashtable 的区别
    > 1、历史原因：Hashtable 是基于陈旧的 Dictionary 类的，HashMap 是Java 1.2 引进的 Map 接口的一个实现。<br>
      2、同步性：Hashtable 是线程安全的，也就是说是同步的，而 HashMap 是线程序不安全的，不是同步的。<br>
      3、值：只有 HashMap 可以让你将空值作为一个表的条目的 key 或 value。<br>
* HashSet 和 HashMap 区别
    > HashSet 是基于 HashMap 实现的，在 HashSet 类里面有一个 map 字段，该 map 字段就是一个
      HashMap，保留 map 的 key，弃用 value，以实现 HashSet。<br>
* HashMap 和 ConcurrentHashMap 的区别
    > 1.线程安全性：HashMap 是线程不安全的；ConcurrentHashMap 是线程安全的。<br>
      2.在 ConcurrentHashMap 的 Node 内部类中，其属性 value、next 都是带有 volatile 的。
      同时其对 value 的 setter 方法进行了特殊处理，不允许直接调用其 setter 方法来修改 value
      的值。最后 Node 还提供了 find 方法来赋值 map.get()。<br>
      3.在 HashMap 和 ConcurrentHashMap 中链表的数据过长是会转换为红黑树来处理。但ConcurrentHashMap
      并不是直接转换，而是将这些链表的节点包装成 TreeNode 放在 TreeBin 对象中，然后由 TreeBin 完成红
      黑树的转换。<br>
* [HashMap 的工作原理及代码实现](https://blog.csdn.net/zxt0601/article/details/77413921)
    > 扩容因子LoadFactor=0.75，初始大小InitailCapacity=16 <br>
      纵向——底层实现：数组 + 链表 + 红黑树（jdk1.8之后对链表节点到达8之后转换为红黑树） <br>
      横向——HashMap为线程不安全，多线程操作会导致其死循环的，主要原因在于resize()扩容阶段。
* [ConcurrentHashMap 的工作原理及代码实现](http://www.iocoder.cn/JUC/sike/ConcurrentHashMap/)
    > 1.8之前采用分段锁，其目的就是降低同步锁的粒度。<br>
      1.8之后使用 CAS 思想代替冗杂的分段锁实现。<br>
      CAS：采用乐观锁思想达到 lock free，其中会使用到 sun.misc.Unsafe 中的 native 方法，
      例如 Atomic 原子类中大量应用到了 CAS 操作，但 CAS 存在一个ABA问题。

### 线程
* 线程安全的定义（源自周志明）
    > 当多个线程访问某个类时，不管运行环境采用何种调度方式或者这些线程将如何交替进行，并且
      在主调代码中不需要任何额外的同步或协同，这个类都能表现出正确的行为，那么称这个类是线
      程安全的。
* 创建线程的方式及实现
    > 创建线程有几种方式：1种。<br>
      Java创建线程只有一种方式：Thread。Runnable是代表任务，无论是Callable，Runnable，
      ThreadPool，最终都是Thread。
* sleep() 、join（）、yield（）有什么区别
    > <h4>sleep()</h4> 
      sleep() 方法需要指定等待的时间，它可以让当前正在执行的线程在指定的时间内暂停执行，进入阻塞状态，
      该方法既可以让其他同优先级或者高优先级的线程得到执行的机会，也可以让低优先级的线程得到执行机会。
      但是 sleep() 方法不会释放“锁标志”，也就是说如果有 synchronized 同步块，其他线程仍然不能访问共
      享数据。 
      <h4>wait()</h4> 
      wait() 方法需要和 notify() 及 notifyAll() 两个方法一起介绍，这三个方法用于协调多个线程对共享数据的
      存取，所以必须在 synchronized 语句块内使用，也就是说，调用 wait()，notify() 和 notifyAll() 的任务在
      调用这些方法前必须拥有对象的锁。注意，它们都是 Object 类的方法，而不是 Thread 类的方法。 <br>
      <br>
      wait() 方法与 sleep() 方法的不同之处在于，wait() 方法会释放对象的“锁标志”。当调用某一对象的 wait()
      方法后，会使当前线程暂停执行，并将当前线程放入对象等待池中，直到调用了 notify() 方法后，将从对象
      等待池中移出任意一个线程并放入锁标志等待池中，只有锁标志等待池中的线程可以获取锁标志，它们随时
      准备争夺锁的拥有权。当调用了某个对象的 notifyAll() 方法，会将对象等待池中的所有线程都移动到该对
      象的锁标志等待池。 <br>
      <br> 
      除了使用 notify() 和 notifyAll() 方法，还可以使用带毫秒参数的 wait(long timeout) 方法，效果是在延迟
      timeout 毫秒后，被暂停的线程将被恢复到锁标志等待池。此外，wait()，notify() 及 notifyAll() 只能在
      synchronized 语句中使用，但是如果使用的是 ReenTrantLock 实现同步，该如何达到这三个方法的效果呢？解决
      方法是使用 ReenTrantLock.newCondition() 获取一个 Condition 类对象，然后 Condition的await()，signal()
      以及 signalAll() 分别对应上面的三个方法。
      <h4>yield()</h4> 
      yield() 方法和sleep() 方法类似，也不会释放“锁标志”，区别在于，它没有参数，即 yield() 方法只是使当前线
      程重新回到可执行状态，所以执行 yield() 的线程有可能在进入到可执行状态后马上又被执行，另外 yield() 方法
      只能使同优先级或者高优先级的线程得到执行机会，这也和 sleep() 方法不同。
      <h4>join()</h4> 
      join() 方法会使当前线程等待调用 join() 方法的线程结束后才能继续执行。<br>
* [说说 CountDownLatch 原理](http://www.iocoder.cn/JUC/sike/CountDownLatch/)
    > CountDownLatch 内部通过共享锁实现。（基于AQS）<br>
      1.在创建 CountDownLatch 实例时，需要传递一个int型的参数：count，该参数为计数器的初始值，也可以理解为该共享锁可以获取的总次数。<br>
      2.当某个线程调用 #await() 方法，程序首先判断 count 的值是否为 0 ，如果不为 0 的话，则会一直等待直到为 0 为止。<br>
      3.当其他线程调用 #countDown() 方法时，则执行释放共享锁状态，使 count 值 - 1。<br>
      4.当在创建 CountDownLatch 时初始化的 count 参数，必须要有 count 线程调用#countDown() 方法，才会使计数器 count 等于 0 ，锁才会释放，前面等待的线程才会继续运行。<br>
      5.注意 CountDownLatch 不能回滚重置。<br>
* [说说 CyclicBarrier 原理](http://www.iocoder.cn/JUC/sike/CyclicBarrier/)
    > 基于重入锁 ReentrantLock 和 Condition。<br>
* [说说 Semaphore 原理](http://www.iocoder.cn/JUC/sike/Semaphore/)
    > 和CountDownLatch 一样，内部通过共享锁实现。（基于AQS实现了非公平和公平锁）
* [说说 Exchanger 原理](http://www.iocoder.cn/JUC/sike/Exchanger/)
* 说说 CountDownLatch 与 CyclicBarrier 区别
    > 1.CountDownLatch 简单的说就是一个线程等待，直到他所等待的其他线程都执行完成并且调用
        countDown() 方法发出通知后，当前线程才可以继续执行。<br>
      2.CyclicBarrier 是所有线程都进行等待，直到所有线程都准备好进入 await() 方法之后，所
        有线程同时开始执行！<br>
      3.CountDownLatch 的计数器只能使用一次。而 CyclicBarrier 的计数器可以使用 reset() 
        方法重置。所以 CyclicBarrier 能处理更为复杂的业务场景，比如如果计算发生错误，可以
        重置计数器，并让线程们重新执行一次。<br>
      4.CyclicBarrier 还提供其他有用的方法，比如 getNumberWaiting 方法可以获得 CyclicBarrier
        阻塞的线程数量。isBroken 方法用来知道阻塞的线程是否被中断。如果被中断返回 true，否则返
        回 false。<br>
* [ThreadLocal 原理分析](http://www.iocoder.cn/JUC/sike/ThreadLocal/)
* [java线程池？线程池构造函数的几个参数含义？keepAliveTime解释一下？](http://www.iocoder.cn/JUC/sike/ThreadPoolExecutor/)
* [线程的生命周期](https://github.com/codinglzc/JavaProjects/tree/master/JavaNotes/src/concurrency/note/线程状态图.jpg)
* [J.U.C Future 和 FutureTask](https://www.jianshu.com/p/e043f83b8862)

### 锁机制
* 说说线程安全问题
* [volatile 实现原理](http://www.iocoder.cn/JUC/sike/volatile/)
* [synchronize 实现原理](http://www.iocoder.cn/JUC/sike/synchronized/)
* synchronized 与 lock 的区别

类别 | synchronized | Lock
---  | --- | --- 
存在层次 | Java的关键字，在jvm层面上 | 是一个类
锁的释放 | 1、以获取锁的线程执行完同步代码，释放锁 2、线程执行发生异常，jvm会让线程释放锁 | 在finally中必须释放锁，不然容易造成线程死锁
锁的获取 | 假设A线程获得锁，B线程等待。<br>如果A线程阻塞，B线程会一直等待 | 分情况而定，Lock有多个锁获取的方式，具体下面会说道，<br>大致就是可以尝试获得锁，线程可以不用一直等待
锁状态 | 无法判断 | 可以判断
锁类型 | 可重入 不可中断 非公平 | 可重入 可中断 可公平（两者皆可）
性能 | 少量同步 |大量同步

* 悲观锁
    > 总是假设最坏的情况，每次去拿数据的时候都认为别人会修改，所以每次在拿数据的时候都会上锁，
    这样别人想拿这个数据就会阻塞直到它拿到锁（**共享资源每次只给一个线程使用，其它线程阻塞，用
    完后再把资源转让给其它线程**）。传统的关系型数据库里边就用到了很多这种锁机制，比如行锁，表
    锁等，读锁，写锁等，都是在做操作之前先上锁。Java中synchronized和ReentrantLock等独占锁就
    是悲观锁思想的实现。<br>
    <br>
    常用于多写的场景
* 乐观锁
    > 总是假设最好的情况，每次去拿数据的时候都认为别人不会修改，所以不会上锁，但是在更新的时
    候会判断一下在此期间别人有没有去更新这个数据，可以使用版本号机制和 CAS 算法实现。**乐观锁适用
    于多读的应用类型，这样可以提高吞吐量**，像数据库提供的类似于 write_condition 机制，其实都是
    提供的乐观锁。在 Java 中 java.util.concurrent.atomic 包下面的原子变量类就是使用了乐观锁的一
    种实现方式 CAS 实现的。<br>
    <br>
    常用于多读的场景
* [深入分析CAS？](http://www.iocoder.cn/JUC/sike/CAS/)
* CAS 中的 ABA 问题
    > 如果一个变量 V 初次读取的时候是 A 值，并且在准备赋值的时候检查到它仍然是A值，那我们就能说明它
    的值没有被其他线程修改过了吗？很明显是不能的，因为在这段时间它的值可能被改为其他值，然后又改
    回 A，那 CAS 操作就会误认为它从来没有被修改过。这个问题被称为 CAS 操作的 "ABA" 问题。<br>
    <br>
    JDK 1.5 以后的 AtomicStampedReference 类就提供了此种能力，其中的 compareAndSet 方法就是
    首先检查当前引用是否等于预期引用，并且当前标志是否等于预期标志，如果全部相等，则以原子方式
    将该引用和该标志的值设置为给定的更新值。
* 乐观锁的业务场景及实现方式
* 产生死锁的 4 个必要条件
    > 1.互斥条件<br>
      2.占有且等待<br>
      3.不可强行占有<br>
      4.循环等待条件<br>

### Web 
* HTTP 请求的 GET 与 POST 方式的区别
    > GET：根据 HTTP 规范，GET 用于信息获取，而且对同一 URL 的多个请求应该返回同样的结果<br>
      <br>
      POST：根据 HTTP 规范，POST 表示可能修改变服务器上的资源的请求。<br>
      <br>
      1.GET 请求的数据会附在 URL 之后；而 POST 把提交的数据放置在 HTTP 头中。<br>
      2.GET 提交的数据大小有限；而 POST 提交的数据的大小没有限制。<br>
      3.POST 的安全性要比 GET 的安全性高。<br>
* session 与 cookie 区别
    > 1.session 是存放在服务器端的，cookie 是存放在客户端的。<br>
      2.session 相对 cookie 较为安全<br>
      3.cookie 最典型的应用：判断用户是否登陆过网站；“购物车”中类的处理和设计。<br>
* session 分布式处理
    > <h4>前言</h4> 
      集群中存在 A、B 两台服务器，用户在第一次访问网站时，Nginx 通过其负载均衡机制将用户请求转发到 A 服务器，
      这时 A 服务器就会给用户创建一个 Session。当用户第二次发送请求时，Nginx 将其负载均衡到 B 服务器，而这时
      候 B 服务器并不存在 Session，所以就会将用户踢到登录页面。这将大大降低用户体验度。<br>
      <br>
      以下有4种 Session 分布式处理策略，并分析其优劣性。<br>
      <h4>第一种：粘性 session </h4>
      **原理**：粘性 Session 是指将用户锁定到某一个服务器上，比如上面说的例子，用户第一次请求时，负载均衡器
      将用户的请求转发到了 A 服务器上，如果负载均衡器设置了粘性 Session 的话，那么用户以后的每次请求都会转
      发到 A 服务器上，相当于把用户和 A 服务器粘到了一块，这就是粘性 Session 机制。<br>
      <br> 
      **优点**：简单，不需要对 session 做任何处理。<br> 
      <br>
      **缺点**：缺乏容错性，如果当前访问的服务器发生故障，用户被转移到第二个服务器上时，他的 session信息都
      将失效。<br>
      <br>
      **适用场景**：发生故障对客户产生的影响较小；服务器发生故障是低概率事件。 <br>
      <br>
      **实现方式**：以 Nginx 为例，在 upstream 模块配置`ip_hash`属性即可实现粘性 Session。<br>
    ```bash
    upstream mycluster{
        #这里添加的是上面启动好的两台Tomcat服务器
        ip_hash;#粘性Session
         server 192.168.22.229:8080 weight=1;
         server 192.168.22.230:8080 weight=1;
    }
    ```
    > <h4>第二种：服务器 session 复制</h4>
      **原理**：任何一个服务器上的 session 发生改变（增删改），该节点会把这个 session 的所有内容序列化，
      然后广播给所有其它节点，不管其他服务器需不需要 session，以此来保证 Session 同步。<br>
      <br> 
      **优点**：可容错，各个服务器间 session 能够实时响应。<br>
      <br> 
      **缺点**：会对网络负荷造成一定压力，如果 session 量大的话可能会造成网络堵塞，拖慢服务器性能。 <br>
      <br>
      **实现方式**：1)设置 tomcat ，server.xml 开启 tomcat 集群功能 enter description here Address:
      填写本机 ip 即可，设置端口号，预防端口冲突。2)在应用里增加信息：通知应用当前处于集群环境中，支持
      分布式 在 web.xml 中添加选项 `<distributable/>`。
      <br>
      <h4>第三种：session 共享机制</h4>
      使用分布式缓存方案比如 memcached、Redis，但是要求 Memcached 或 Redis 必须是集群。 使用 Session 
      共享也分两种机制，两种情况如下：<br>
      <h5>粘性 session 处理方式</h5>
      **原理**：不同的 tomcat 指定访问不同的主 memcached。多个 Memcached 之间信息是同步的，能主从备份和
      高可用。用户访问时首先在 tomcat 中创建 session，然后将 session 复制一份放到它对应的 memcahed 上。
      memcache 只起备份作用，读写都在 tomcat 上。当某一个 tomcat 挂掉后，集群将用户的访问定位到备 tomcat 
      上，然后根据 cookie 中存储的 SessionId 找 session，找不到时，再去相应的 memcached 上去 session，
      找到之后将其复制到备 tomcat 上。<br>
      <h5>非粘性 session 处理方式</h5>
      **原理**：memcached 做主从复制，写入 session 都往从 memcached 服务上写，读取都从主 memcached 读取，
      tomcat 本身不存储 session。<br>
      <br>
      **优点**：可容错，session 实时响应。<br>
      <h4>第四种：session 持久化到数据库</h4>
      **原理**：就不用多说了吧，拿出一个数据库，专门用来存储 session 信息。保证 session 的持久化。<br>
      <br>
      **优点**：服务器出现问题，session 不会丢失。<br>
      <br>
      **缺点**：如果网站的访问量很大，把 session 存储到数据库中，会对数据库造成很大压力，还需要增加额外的
      开销维护数据库。<br>
      <h4>小结</h4>
      以上讲述的就是集群或分布式环境下，session 的 4 种处理策略。其中就应用广泛性而言，第三种方式，也就是
      基于第三方缓存框架共享 session，应用的最为广泛，无论是效率还是扩展性都很好。<br>
* TCP三次握手和四次挥手（[为什么是三次握手和四次挥手](https://blog.csdn.net/xifeijian/article/details/12777187)）
    > <h4>三次握手：</h4>
      1.客户端——发送带有 SYN 标志的数据包——一次握手——服务端<br>
      2.服务端——发送带有 SYN/ACK 标志的数据包——二次握手——客户端<br>
      3.客户端——发送带有 ACK 标志的数据包——三次握手——服务端<br>
      <h4>四次挥手：</h4>
      1.客户端——发送一个 FIN，用来关闭客户端到服务器的数据传送<br>
      2.服务器——收到这个 FIN，它发回一个 ACK，确认序号为收到的序号加 1。和 SYN 一样，一个 FIN 将占用一个序号<br>
      3.服务器——关闭与客户端的连接，发送一个 FIN 给客户端<br>
      4.客户端——发回 ACK 报文确认，并将确认序号设置为序号加 1<br>
* [TCP 的流量控制和拥塞控制](https://blog.csdn.net/yechaodechuntian/article/details/25429143)
* 输入url到页面加载都发生了什么事情？（面试中最最长问的）
    > 1.输入地址<br>
      2.浏览器查找域名的IP地址，这一步包括DNS具体的查找过程，比如：浏览器缓存，系统缓存，路由器缓存。。。<br>
      3.浏览器向web服务器发送一个HTTP请求<br>
      4.服务器的永久重定向响应<br>
      5.浏览器跟踪重定向地址<br>
      6.服务器处理请求<br>
      7.服务器返回一个 HTTP 响应<br>
      8.浏览器显示 HTML <br>
      9.浏览器发送请求获取嵌入在 HTML 中的资源（如图片、音频、视频、CSS/JS 等等）
      10.浏览器发送异步请求，渲染界面
* [HTTP 和 HTTPS 的区别](https://juejin.im/entry/58d7635e5c497d0057fae036)
* [非对称加密和对称加密](https://blog.csdn.net/u013320868/article/details/54090295)
* MVC 设计思想
    > MVC将应用程序划分为实体（Model）、视图（View）和控制（Controller）三个逻辑部件，具有逻辑复用、松耦合等特点。
* [HTTP 2.0 相比 HTTP 1.1 的改进](https://www.zhihu.com/question/34074946)

## 核心篇
### 数据存储
* [如何查找MySQL中查询慢的SQL语句](https://blog.csdn.net/qq_29663071/article/details/76924072)
    > 1.slow_query_log<br>
      这个参数设置为ON，可以捕获执行时间超过一定数值的SQL语句。<br>
      2.long_query_time<br>
      当SQL语句执行时间超过此数值时，就会被记录到日志中，建议设置为1或者更短。<br>
      3.slow_query_log_file<br>
      记录日志的文件名。<br>
      4.log_queries_not_using_indexes<br>
      这个参数设置为ON，可以捕获到所有未使用索引的SQL语句，尽管这个SQL语句有可能执行得挺快。<br>
* [MySQL 索引使用的注意事项](http://www.yuanrengu.com/index.php/2017-01-13.html)
* [说说分库与分表设计](http://www.infoq.com/cn/articles/key-steps-and-likely-problems-of-split-table)
* [分库与分表带来的分布式困境与应对之策](http://blog.720ui.com/2017/mysql_core_09_multi_db_table2/)
* 说说 SQL 优化之道
    > <h4>1.负向条件查询不能使用索引</h4>
        ```sql
        select * from order where status!=0 and stauts!=1
        ```
        <br>not in/not exists都不是好习惯。<br>
        可以优化为in查询：<br>
        ```sql
        select * from order where status in(2,3)
        ```
        <br>
      <h4>2.前导模糊查询不能使用索引</h4>
        ```sql
        select * from order where desc like '%XX'
        ```
        <br>而非前导模糊查询则可以：<br>
        ```sql
        select * from order where desc like 'XX%'
        ```
        <br>
      <h4>3.数据区分度不大的字段不宜使用索引</h4>
        ```
        select * from user where sex=1
        ```
        <br>
        原因：性别只有男，女，每次过滤掉的数据很少，不宜使用索引。<br>
        经验上，能过滤80%数据时就可以使用索引。对于订单状态，如果状态值很少，不宜使用索引，
        如果状态值很多，能够过滤大量数据，则应该建立索引。<br>
      <h4>4.在属性上进行计算不能命中索引</h4>
        ```
        select * from order where YEAR(date) < = '2017'
        ```
       <br>即使date上建立了索引，也会全表扫描，可优化为值计算：<br>
        ```
        select * from order where date < = CURDATE()
        ```
        <br>或者：<br>
        ```
        select * from order where date < = '2017-01-01'
        ```
        <br>
      <h4>5.如果业务大部分是单条查询，使用Hash索引性能更好，例如用户中心</h4>
        ```
        select * from user where uid=?
        ```<br>
        ```
        select * from user where login_name=?
        ```<br>
        原因：B-Tree索引的时间复杂度是O(log(n))；Hash索引的时间复杂度是O(1)。<br>
      <h4>6.允许为null的列，查询有潜在大坑。</h4>
        单列索引不存null值，复合索引不存全为null的值，如果列允许为null，可能会得到“不符合预期”的结果集。<br>
        ```
        select * from user where name != 'shenjian'
        ```<br>
        如果name允许为null，索引不存储null值，结果集中不会包含这些记录。<br>
        所以，请使用not null约束以及默认值。<br>
      <h4>7.复合索引最左前缀，并不是值SQL语句的where顺序要和复合索引一致。</h4>
        用户中心建立了(login_name, passwd)的复合索引。<br>
        ```
        select * from user where login_name=? and passwd=?
        ```<br>
        ```
        select * from user where passwd=? and login_name=?
        ```<br>
        都能够命中索引。<br><br>
        ```
        select * from user where login_name=?
        ```<br>
        也能命中索引，满足复合索引最左前缀。<br><br>
        ```
        select * from user where passwd=?
        ```<br>
        不能命中索引，不满足复合索引最左前缀。<br>
      <h4>8.如果明确知道只有一条结果返回，limit 1能够提高效率</h4>
      ```
      select * from user where login_name=?
      ```<br>
      可以优化为：
      ```
      select * from user where login_name=? limit 1
      ```<br>
      原因：你知道只有一条结果，但数据库并不知道，明确告诉它，让它主动停止游标移动。<br>
      <h4>9.把计算放到业务层而不是数据库层，除了节省数据的CPU，还有意想不到的查询缓存优化效果</h4>
      ```
      select * from order where date < = CURDATE()
      ```<br>
      这不是一个好的SQL实践，应该优化为：
      ```
      $curDate = date('Y-m-d');
      $res = mysql_query(
          'select * from order where date < = $curDate');
      ```<br>
      原因：<br>
      释放了数据库的CPU。<br>
      多次调用，传入的SQL相同，才可以利用查询缓存。<br>
      <h4>10.强制类型转换会全表扫描</h4>
      ```
      select * from user where phone=13800001234
      ```<br>
      不要使用select *（潜台词，上面的SQL都不合格 =_=），只返回需要的列，能够大大的节省数据传输量，
      提高数据库的内存使用量。<br>
* [MySQL 遇到的死锁问题](http://phpstudy.php.cn/b.php/71480.html)
* 存储引擎的 InnoDB 与 MyISAM [链接](https://link.juejin.im/?target=https%3A%2F%2Fjuejin.im%2Fpost%2F5b1685bef265da6e5c3c1c34)
    > 1.1 MyISAM简介：<br>
          MyISAM是MySQL的默认数据库引擎（5.5版本之前），由早期的
          ISAM(Indexed Sequential Access Method: 有索引的顺序访问方法)所改良。<br>
          <br>
      1.2 MyISAM特点：<br>
          不支持行锁（MyISAM只有表锁），读取时对需要读到的所有表加锁，写入时则对表加排它锁<br>
          不支持事务<br>
          不支持外键<br>
          不支持崩溃后的安全恢复<br>
          在表有读取查询的同时，支持往表中插入新记录<br>
          支持BLOB和TEXT的前500个字符索引，支持全文索引<br>
          支持延迟跟新索引，及大地提升了写入性能<br>
          对于不会进行修改的表，支持压缩表，极大地减少了磁盘空间的占用<br>
          <br>
      2.1 InnoDB简介：<br>
          InnoDB是MySQL 5.5版本之后的默认数据库引擎，支持ACID兼容的事务功能。<br>
          <br>
      2.2 InnoDB特点：<br>
          支持行锁，采用MVCC来支持高并发，有可能死锁<br>
          支持事务<br>
          支持外键<br>
          支持崩溃后的安全恢复<br>
          不支持全文索引<br>
          <br>
      3.1 二者的常见对比<br>
          1）count运算上的区别：因为MyISAM缓存有表meta-data（行数等），因此在做COUNT(*)时对于
          一个结构很好的查询是不需要消耗多少资源的。而对于InnoDB来说，则没有这种缓存。<br>
          2）是否支持事务和崩溃后的安全恢复：MyISAM强调的是性能，每次查询具有原子性，其执行速度
          比InnoDB类型更快，但是不提供事务支持。但是InnoDB提供事务支持，外键等高级数据库功能。
          具有事务提交、回滚和崩溃修复能力的事务安全型表。<br>
          3) 是否支持外键：MyISAM不支持，而InnoDB支持。<br>
          <br>
      3.2 总结<br>
          MyISAM更适合读密集的表，而InnoDB更适合写密集的表。<br>
* [数据库索引的原理](https://blog.csdn.net/suifeng3051/article/details/52669644)
* 为什么要用 B-tree
    > B-tree中一次检索最多需要（深度-1）次I/O（根节点常驻内存），渐进复杂度为 O(h)=O(logdN)。
      一般实际应用中，出度 d 是非常大的数字，通常超过 100，因此深度非常小（通常不超过 3）。
* 聚集索引与非聚集索引的区别
    > MyISAM 采用的是非聚集索引；InnoDB采用的聚集索引。<br>
      聚集索引：主索引的叶结点 data 域中存储的是数据记录，辅助索引的叶节点 data 域中存储的是主索引，也就是说数据就是索引；<br>
      非聚集索引：主索引和辅助索引的叶结点 data 域中存储的是数据记录的地址，也就是说索引和数据时分离的。
* [limit 20000 加载很慢怎么解决](http://www.funtl.com/2018/04/08/interview/Java-%E9%9D%A2%E8%AF%95%E5%AE%9D%E5%85%B8-limit-20000-%E5%8A%A0%E8%BD%BD%E5%BE%88%E6%85%A2%E6%80%8E%E4%B9%88%E8%A7%A3%E5%86%B3/)
* [选择合适的分布式主键方案](https://blog.csdn.net/chenshun123/article/details/79588208)
    > 1.通过应用程序生成一个 GUID，然后和数据一起插入切分后的集群 <br>
      2.通过独立的应用程序事先在数据库中生成一系列唯一的 ID，各应用程序通过接口或者自己去读取再和数据一起插入到切分后的集群中 <br>
      3.通过集群编号加集群内的自增 (auto_increment类型) 两个字段 共同组成唯一主键 <br>
      4.通过设置每个集群中自增 ID 起始点 (auto_increment_offset)，将各个集群的 ID 进行绝对的分段来实现全局唯一。当遇到某个集群数据 <br>
      5.Redis 生成 ID <br>
      6.Twitter 的 snowflake 算法 <br>
      7.利用 zookeeper 生成唯一 ID <br>
      8.MongoDB 的 ObjectId <br>
* [数据库的脏读、不可重复读和幻读](http://dr-yanglong.github.io/2016/06/06/transaction-feature/)
* [选择合适的数据存储方案](http://blog.720ui.com/2017/db_better_db_use/)
* [SQL 和 NoSQL 的区别](https://www.jianshu.com/p/b32fe4fe45a3)
* [ObjectId 规则](http://www.funtl.com/2018/04/08/interview/Java-%E9%9D%A2%E8%AF%95%E5%AE%9D%E5%85%B8-ObjectId-%E8%A7%84%E5%88%99/)
* [聊聊 MongoDB 使用场景](http://blog.720ui.com/2017/mongodb_core_use/)
* [倒排索引](https://blog.csdn.net/u011239443/article/details/60604017)
* [聊聊 ElasticSearch 使用场景](https://www.jianshu.com/p/ed80664141a5)
* [数据库事务ACID的描述和隔离级别](https://blog.csdn.net/qq_27409289/article/details/73348186)
* [MVCC 多版本控制](https://segmentfault.com/a/1190000012650596)

### 缓存使用
* [Redis 和 Memcached 的区别](http://www.infoq.com/cn/articles/tq-why-choose-redis)
* Redis 有哪些类型
    > Redis 支持 5 种数据类型：string（字符串），hash（哈希），list（列表），set（集合）和 zset（有序集合）。<br>
* [Redis 内部结构](https://www.jianshu.com/p/f09480c05e42)
* [Redis-内存淘汰机制](http://www.funtl.com/2018/04/08/interview/Java-%E9%9D%A2%E8%AF%95%E5%AE%9D%E5%85%B8-Redis-%E5%86%85%E5%AD%98%E6%B7%98%E6%B1%B0%E6%9C%BA%E5%88%B6/)
* [聊聊 Redis 使用场景](https://juejin.im/post/5a24c6f2f265da431d3c8204)
* [Redis 持久化机制](https://blog.csdn.net/zhanglh046/article/details/78630469)
* Redis 如何实现持久化
    > RDB 和 AOF
* [Redis 集群方案与实现](https://juejin.im/post/5a707f4d5188255a8817f5b1)
* [Redis 为什么是单线程的](https://blog.csdn.net/xlgen157387/article/details/79470556)
* [缓存奔溃，缓存穿透，缓存预热，缓存更新，缓存降级](https://blog.csdn.net/qq_37606901/article/details/79569250)
* [使用缓存的合理性问题](https://segmentfault.com/a/1190000009129624)

### 消息队列
* [消息队列的使用场景](https://blog.csdn.net/he90227/article/details/50800646)
* 消息的重发补偿解决思路
    > 1.消息服务定时查询状态为已发送并超时的消息；<br>
      2.消息服务将消息重新投递到 MQ 组件中；<br>
      3.消费端监听消息，在满足幂等性的条件下，重新执行业务；<br>
      4.在成功消费消息之后，消费端通知消息服务，表示该消息已经成功消费；<br>
      5.通过消息状态确认和消息重发两个功能，可以确保生产端、消息服务和消费端数据的最终一致性。<br>
* 消息的幂等性解决思路
    > <h4>1.全局唯一ID</h4>
      如果使用全局唯一ID，就是根据业务的操作和内容生成一个全局ID，在执行操作前先根据这个全局唯一ID是否存在，
      来判断这个操作是否已经执行。如果全局ID不存在，则把全局ID存储到存储系统中；如果全局ID存在，则表示该方法
      已经执行。<br>
      <h4>2.去重表</h4>
      利用数据库表的特性来实现幂等性，常用的思路的就是在表上构建唯一性索引，保证某一类数据一旦执行完毕，后续
      同样的请求再也无法成功写入。<br><br>
      例如订单创建和订单支付，一个订单只会支付一次，所以订单ID可以作为唯一标识，在我们实现时，把创建及支付订单
      和写入去重表，放在一个事务中，如果重复创建，数据库会抛出唯一约束异常，事务就会回滚。<br>
* 消息的堆积解决思路
    > 处理消息堆积的方法就是把它存下来，只是这个存储可以做成很多方式。比如存储在内存里，存储在分布式KV里，存储
      在磁盘里，存储在数据库里等等。但归结起来，主要有持久化和非持久化两种。<br><br>
      持久化的形式能更大程度地保证消息的可靠性（如断电等不可抗外力），并且理论上能承载更大限度的消息堆积
      （外存的空间远大于内存）。<br><br>
      但并不是每一种消息都需要持久化存储。很多消息对于投递性能的要求大于可靠性的要求，且数量极大（如日志）。
      这时候，消息不落地直接暂存内存，尝试几次 failover，最终投递出去也未尝不可。<br>
* 自己如何实现消息队列
    > [blog1](https://www.jianshu.com/p/2d2271ecc64d)<br>
      [blog2](https://blog.csdn.net/liaodehong/article/details/52413905)
* [如何保证消息的有序和重复性](http://www.sohu.com/a/129521820_487514)

## 框架篇
### Spring
* [Spring加载Bean的流程？](https://segmentfault.com/a/1190000012887776)
* [BeanFactory 和 ApplicationContext 有什么区别](https://my.oschina.net/yao00jun/blog/215642)
* [Spring Bean 的生命周期](https://www.jianshu.com/p/3944792a5fff)
* [Spring IOC 容器如何实现](https://www.jianshu.com/p/9fe5a3c25ab6)
* Spring AOP
    > 其原理就是 CGLib 和 JDK 的动态代理。<br><br>
      SpringAOP动态代理策略是：<br>
      1、如果目标对象实现了接口，默认情况下会采用JDK的动态代理实现AOP <br>
      2、如果目标对象实现了接口，可以强制使用CGLIB实现AOP <br>
      3、如果目标对象没有实现了接口，必须采用CGLIB库，spring会自动在JDK动态代理和CGLIB之间转换<br>
* [动态代理（CGLib 与 JDK）](https://www.jianshu.com/p/1712ef4f2717)
* [Spring 事务实现方式（编程式事务和声明式事务）](https://blog.csdn.net/liaohaojian/article/details/70139151)
* [Spring 事务底层原理](https://blog.csdn.net/TVwR8OfV0P/article/details/79084032)
* [Spring 如何自定义注解实现功能](https://www.jianshu.com/p/7c2948f64b1c)
* [Spring MVC 运行流程](https://www.jianshu.com/p/8a20c547e245)
* [Spring MVC 启动流程](https://www.jianshu.com/p/dc64d02e49ac)
* [Spring 的单例实现原理](https://juejin.im/post/594084fd61ff4b006cb425f1)
* [Spring 框架中用到了哪些设计模式](https://www.ibm.com/developerworks/cn/java/j-lo-spring-principle/index.html)
* Spring 其他产品（Srping Boot、Spring Cloud、Spring Secuirity、Spring Data、Spring AMQP 等）

### Netty
* 为什么选择 Netty
    > 1.API 使用简单，开发门槛低；<br>
      2.功能强大，预置了多种编解码功能，支持多种主流协议；<br>
      3.定制能力强，可以通过 ChannelHandler 对通信框架进行灵活的扩展；<br>
      4.性能高，通过与其它业界主流的 NIO 框架对比，Netty 的综合性能最优；<br>
      5.成熟、稳定，Netty 修复了已经发现的所有 JDK NIO BUG，业务开发人员不需要再为 NIO 的 BUG 而烦恼；<br>
      6.社区活跃，版本迭代周期短，发现的BUG可以被及时修复，同时，更多的新功能会被加入；<br>
      7.经历了大规模的商业应用考验，质量已经得到验证。在互联网、大数据、网络游戏、企业应用、电信软件等众多行业得到成功商用，证明了它可以完全满足不同行业的商业应用。<br>
      正是因为这些优点，Netty 逐渐成为 Java NIO 编程的首选框架。<br>
* 说说业务中，Netty 的使用场景
    > 1.构建高性能、低时延的各种 Java 中间件，例如 MQ、分布式服务框架、ESB 消息总线等，Netty 主要作为基础通信框架提供高性能、低时延的通信服务；<br>
      2.公有或者私有协议栈的基础通信框架，例如可以基于 Netty 构建异步、高性能的 WebSocket 协议栈；<br>
      3.各领域应用，例如大数据、游戏等，Netty 作为高性能的通信框架用于内部各模块的数据分发、传输和汇总等，实现模块之间高性能通信。<br>
* [原生的 NIO 在 JDK 1.7 版本存在 epoll bug](http://www.10tiao.com/html/308/201602/401718035/1.html)
    > 它会导致 Selector 空轮询，最终导致 CPU 100%。官方声称在 JDK 1.6 版本的 update18 修复了该问题，
    但是直到 JDK 1.7 版本该问题仍旧存在，只不过该 BUG 发生概率降低了一些而已，它并没有得到根本性解决。
* 什么是TCP 粘包/拆包
    > 1.要发送的数据大于 TCP 发送缓冲区剩余空间大小，将会发生拆包。<br>
      2.待发送数据大于 MSS（最大报文长度），TCP 在传输前将进行拆包。<br>
      3.要发送的数据小于 TCP 发送缓冲区的大小，TCP 将多次写入缓冲区的数据一次发送出去，将会发生粘包。<br>
      4.接收数据端的应用层没有及时读取接收缓冲区中的数据，将发生粘包。<br>
* TCP粘包/拆包的解决办法
    > 1.发送端给每个数据包添加包首部，首部中应该至少包含数据包的长度，这样接收端在接收到数据后，通过读取包首部的长度字段，便知道每一个数据包的实际长度了。<br>
      2.发送端将每个数据包封装为固定长度（不够的可以通过补 0 填充），这样接收端每次从接收缓冲区中读取固定长度的数据就自然而然的把每个数据包拆分开来。<br>
      3.可以在数据包之间设置边界，如添加特殊符号，这样，接收端通过这个边界就可以将不同的数据包拆分开。<br>
* [Netty 线程模型](https://www.jianshu.com/p/38b56531565d)
    > 首先，Netty 使用 EventLoop 来处理连接上的读写事件，而一个连接上的所有请求都保证在一个 EventLoop 中被处理，
    一个 EventLoop 中只有一个 Thread，所以也就实现了一个连接上的所有事件只会在一个线程中被执行。一个 
    EventLoopGroup 包含多个 EventLoop，可以把一个 EventLoop 当做是 Reactor 线程模型中的一个线程，而一个 
    EventLoopGroup 类似于一个 ExecutorService。<br>
* [说说 Netty 的零拷贝](https://segmentfault.com/a/1190000007560884)
    > “零拷贝”是指计算机操作的过程中，CPU 不需要为数据在内存之间的拷贝消耗资源。而它通常是指计算机在网络上发送文件时，
    不需要将文件内容拷贝到用户空间（User Space）而直接在内核空间（Kernel Space）中传输到网络的方式。<br>
    而需要注意的是, Netty 中的 Zero-copy 与上面我们所提到到 OS 层面上的 Zero-copy 不太一样, Netty的 
    Zero-coyp 完全是在用户态(Java 层面)的, 它的 Zero-copy 的更多的是偏向于 "优化数据操作" 这样的概念.<br>
* Netty 内部执行流程
    > 1.Netty 的接收和发送 ByteBuffer 采用 DIRECT BUFFERS，使用堆外直接内存进行 Socket 读写，不需要进行字节缓冲区的二次拷贝。如果使用传统的堆内存（HEAP BUFFERS）进行 Socket 读写，JVM 会将堆内存 Buffer 拷贝一份到直接内存中，然后才写入 Socket 中。相比于堆外直接内存，消息在发送过程中多了一次缓冲区的内存拷贝。<br><br>
      2.Netty 提供了组合 Buffer 对象，可以聚合多个 ByteBuffer 对象，用户可以像操作一个 Buffer 那样方便的对组合 Buffer 进行操作，避免了传统通过内存拷贝的方式将几个小 Buffer 合并成一个大的 Buffer。<br><br>
      3.Netty 的文件传输采用了 transferTo 方法，它可以直接将文件缓冲区的数据发送到目标 Channel，避免了传统通过循环 write 方式导致的内存拷贝问题。<br><br>
* Netty 重连实现
    > 1.心跳机制检测连接存活<br>
      2.启动时连接重试<br>
      3.运行中连接断开时重试<br>


## 微服务篇
### 微服务
* 前后端分离是如何做的
    > 在前后端分离架构中，后端只需要负责按照约定的数据格式向前端提供可调用的 API 服务即可。前后端之间通过 HTTP 请求进行交互，前端获取到数据后，进行页面的组装和渲染，最终返回给浏览器。<br>
* [如何解决跨域](http://www.funtl.com/2018/04/09/interview/Java-%E9%9D%A2%E8%AF%95%E5%AE%9D%E5%85%B8-%E5%A6%82%E4%BD%95%E8%A7%A3%E5%86%B3%E8%B7%A8%E5%9F%9F/)
* 微服务哪些框架
    > <h4>Dubbo</h4>
      是阿里巴巴服务化治理的核心框架，并被广泛应用于阿里巴巴集团的各成员站点。阿里巴巴近几年对开源社区的贡献不论在国内还是国外都是引人注目的，比如：JStorm 捐赠给 Apache 并加入 Apache 基金会等，为中国互联网人争足了面子，使得阿里巴巴在国人眼里已经从电商升级为一家科技公司了。<br>
      <h4>Spring Cloud</h4>
      从命名我们就可以知道，它是 Spring Source 的产物，Spring 社区的强大背书可以说是 Java 企业界最有影响力的组织了，除了 Spring Source 之外，还有 Pivotal 和 Netflix 是其强大的后盾与技术输出。其中 Netflix 开源的整套微服务架构套件是 Spring Cloud 的核心。<br>
* [你怎么理解 RPC 框架](http://www.funtl.com/2018/04/09/interview/Java-%E9%9D%A2%E8%AF%95%E5%AE%9D%E5%85%B8-%E4%BD%A0%E6%80%8E%E4%B9%88%E7%90%86%E8%A7%A3-RPC-%E6%A1%86%E6%9E%B6/)
* [说说 RPC 的实现原理](https://www.cnblogs.com/LBSer/p/4853234.html)
    > 首先需要有处理网络连接通讯的模块，负责连接建立、管理和消息的传输。其次需要有编解码的模块，因为网络通讯都是传输的字节码，需要将我们使用的对象序列化和反序列化。剩下的就是客户端和服务器端的部分，服务器端暴露要开放的服务接口，客户调用服务接口的一个代理实现，这个代理实现负责收集数据、编码并传输给服务器然后等待结果返回。<br>
* 说说 Dubbo 的实现原理
    > Dubbo 作为 RPC 框架，实现的效果就是调用远程的方法就像在本地调用一样。如何做到呢？<br>
      1.本地有对远程方法的描述，包括方法名、参数、返回值，在 Dubbo 中是远程和本地使用同样的接口。<br>
      2.要有对网络通信的封装，要对调用方来说通信细节是完全不可见的，网络通信要做的就是将调用方法的属性通过一定的协议（简单来说就是消息格式）传递到服务端。<br>
      3.服务端按照协议解析出调用的信息；执行相应的方法；在将方法的返回值通过协议传递给客户端；客户端再解析；在调用方式上又可以分为同步调用和异步调用。<br>
* [你怎么理解 RESTful](https://www.zhihu.com/question/28557115)
* [说说如何设计一个良好的 API](http://www.funtl.com/2018/04/09/interview/Java-%E9%9D%A2%E8%AF%95%E5%AE%9D%E5%85%B8-%E8%AF%B4%E8%AF%B4%E5%A6%82%E4%BD%95%E8%AE%BE%E8%AE%A1%E4%B8%80%E4%B8%AA%E8%89%AF%E5%A5%BD%E7%9A%84-API/)
* [如何理解 RESTful API 的幂等性](http://www.funtl.com/2018/04/09/interview/Java-%E9%9D%A2%E8%AF%95%E5%AE%9D%E5%85%B8-%E5%A6%82%E4%BD%95%E7%90%86%E8%A7%A3-RESTful-API-%E7%9A%84%E5%B9%82%E7%AD%89%E6%80%A7/)
* [如何保证接口的幂等性](https://blog.csdn.net/WANGYAN9110/article/details/70953273)
* 说说 CAP 定理、 BASE 理论
    > [CAP定理](https://juejin.im/post/5b26634b6fb9a00e765e75d1) <br>
      [BASE定理](https://juejin.im/post/5b2663fcf265da59a401e6f8)<br>
* 怎么考虑数据一致性问题
    > [2PC协议](https://juejin.im/post/5b2664446fb9a00e4a53136e)<br>
      [3PC协议](https://juejin.im/post/5b26648e5188257494641b9f)<br>
      [Paxos](https://juejin.im/post/5b2664bd51882574874d8a76)
      [raft](https://juejin.im/post/5b2664e2f265da59584d8c90)
* [说说最终一致性的实现方案](http://www.funtl.com/2018/04/10/interview/Java-%E9%9D%A2%E8%AF%95%E5%AE%9D%E5%85%B8-%E8%AF%B4%E8%AF%B4%E6%9C%80%E7%BB%88%E4%B8%80%E8%87%B4%E6%80%A7%E7%9A%84%E5%AE%9E%E7%8E%B0%E6%96%B9%E6%A1%88/)
* 你怎么看待微服务
* [微服务与 SOA 的区别](http://www.funtl.com/2018/04/10/interview/Java-%E9%9D%A2%E8%AF%95%E5%AE%9D%E5%85%B8-%E5%BE%AE%E6%9C%8D%E5%8A%A1%E4%B8%8E-SOA-%E7%9A%84%E5%8C%BA%E5%88%AB/)
* 如何拆分服务
* [微服务如何进行数据库管理](http://www.funtl.com/2018/04/10/interview/Java-%E9%9D%A2%E8%AF%95%E5%AE%9D%E5%85%B8-%E5%BE%AE%E6%9C%8D%E5%8A%A1%E5%A6%82%E4%BD%95%E8%BF%9B%E8%A1%8C%E6%95%B0%E6%8D%AE%E5%BA%93%E7%AE%A1%E7%90%86/)
* 如何应对微服务的链式调用异常
* 对于快速追踪与定位问题
* 微服务的安全
* [服务降级](http://fengfu.io/2017/04/23/%E6%9C%8D%E5%8A%A1%E5%8C%96%E6%9E%B6%E6%9E%84-%E6%9C%8D%E5%8A%A1%E9%99%8D%E7%BA%A7/)

### 分布式
* 谈谈业务中使用分布式的场景
* [一致性哈希](https://blog.csdn.net/lihao21/article/details/54193868)
* Session 分布式方案
* [ZooKeeper介绍及典型使用场景](https://blog.csdn.net/liuxinghao/article/details/42747625)
* 分布式锁的场景
* [分布式锁的实现方案](https://juejin.im/entry/5a502ac2518825732b19a595)
    > 基于数据库：一是基于数据库表(唯一约束性)，另一种是基于数据库排他锁(for update)。<br>
      [基于Redis的分布式锁](https://crossoverjie.top/2018/03/29/distributed-lock/distributed-lock-redis/)<br>
      [基于zookeeper临时有序节点](http://www.dengshenyu.com/java/%E5%88%86%E5%B8%83%E5%BC%8F%E7%B3%BB%E7%BB%9F/2017/10/23/zookeeper-distributed-lock.html)
* 分布式事务
* [集群与负载均衡的算法与实现](https://blog.csdn.net/i_chenjiahui/article/details/46419465)
* [说说分库与分表设计](http://www.infoq.com/cn/articles/key-steps-and-likely-problems-of-split-table)
* [分库与分表带来的分布式困境与应对之策](http://blog.720ui.com/2017/mysql_core_09_multi_db_table2/)
* [MySQL 主从分离原理和实践](http://techlog.cn/article/list/10182736)
* [高并发系统限流方式](http://jinnianshilongnian.iteye.com/blog/2305117)

## 安全&性能
### 安全问题
* 安全要素与 STRIDE 威胁
* 防范常见的 Web 攻击
* 服务端通信安全攻防
* HTTPS 原理剖析
* HTTPS 降级攻击
* 授权与认证
* 基于角色的访问控制
* 基于数据的访问控制

###性能优化
* 性能指标有哪些
* 如何发现性能瓶颈
* 性能调优的常见手段
* 说说你在项目中如何进行性能调优


## 工程篇
### 需求分析
* 你如何对需求原型进行理解和拆分
* 说说你对功能性需求的理解
* 说说你对非功能性需求的理解
* 你针对产品提出哪些交互和改进意见
* 你如何理解用户痛点

### 设计能力
* 说说你在项目中使用过的 UML 图
* 你如何考虑组件化
* 你如何考虑服务化
* 你如何进行领域建模
* 你如何划分领域边界
* 说说你项目中的领域建模
* 说说概要设计

### 设计模式
* 你项目中有使用哪些设计模式
* 说说常用开源框架中设计模式使用分析
* 说说你对设计原则的理解
* 23种设计模式的设计理念
* 设计模式之间的异同，例如策略模式与状态模式的区别
* 设计模式之间的结合，例如策略模式+简单工厂模式的实践
* 设计模式的性能，例如单例模式哪种性能更好。

### 业务工程
* 你系统中的前后端分离是如何做的
* 说说你的开发流程
* 你和团队是如何沟通的
* 你如何进行代码评审
* 说说你对技术与业务的理解
* 说说你在项目中经常遇到的 Exception
* 说说你在项目中遇到感觉最难Bug，怎么解决的
* 说说你在项目中遇到印象最深困难，怎么解决的
* 你觉得你们项目还有哪些不足的地方
* 你是否遇到过 CPU 100% ，如何排查与解决
* 你是否遇到过 内存 OOM ，如何排查与解决
* 说说你对敏捷开发的实践
* 说说你对开发运维的实践
* 介绍下工作中的一个对自己最有价值的项目，以及在这个过程中的角色

### 软实力
* 说说你的亮点
* 说说你最近在看什么书
* 说说你觉得最有意义的技术书籍
* 工作之余做什么事情
* 说说个人发展方向方面的思考
* 说说你认为的服务端开发工程师应该具备哪些能力
* 说说你认为的架构师是什么样的，架构师主要做什么
* 说说你所理解的技术专家

## HR 篇
* 你为什么离开之前的公司
* 你为什么要进我们公司
* 说说职业规划
* 你如何看待加班问题
* 谈一谈你的一次失败经历
* 你觉得你最大的优点是什么
* 你觉得你最大的缺点是什么
* 你在工作之余做什么事情
* 你为什么认为你适合这个职位
* 你觉得自己那方面能力最急需提高
* 你来我们公司最希望得到什么
* 你希望从这份工作中获得什么
* 你对现在应聘的职位有什么了解
* 您还有什么想问的
* 你怎么看待自己的职涯
* 谈谈你的家庭情况
* 你有什么业余爱好
* 你计划在公司工作多久