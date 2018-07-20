### 1.基础知识：
1. 算法和数据结构  
1.1 数组、链表、二叉树、队列、栈的各种操作（性能，场景）  
1.2 二分查找和各种变种的二分查找  
1.3 各类排序算法以及复杂度分析（快排、归并、堆）  
1.4 各类算法题（手写）  
1.5 理解并可以分析时间和空间复杂度。  
1.6 动态规划（笔试回回有。。）、贪心。  
1.7 红黑树、AVL树、Hash树、Tire树、B树、B+树。  
1.8 图算法（比较少，也就两个最短路径算法理解吧）  

2. 计算机网络  
2.1 OSI7层模型（TCP4层）  
· · ·每层的协议  
· · ·url到页面的过程  
2.2 HTTP  
· · ·http/https 1.0、1.1、2.0  
· · ·get/post 以及幂等性  
· · ·http 协议头相关   
· · ·网络攻击（CSRF、XSS）    
2.3. TCP/IP  
· · ·三次握手、四次挥手  
· · ·拥塞控制（过程、阈值）  
· · ·流量控制与滑动窗口  
· · ·TCP与UDP比较  
· · ·子网划分（一般只有笔试有）  
· · ·DDos攻击  
2.4. (B)IO/NIO/AIO
· · ·三者原理，各个语言是怎么实现的  
· · ·Netty  
· · ·Linux内核select poll epoll  

3. 数据库（最多的还是mysql，Nosql有redis）  
3.1 索引（包括分类及优化方式，失效条件，底层结构）  
3.2 sql语法（join，union，子查询，having，group by）  
3.3 引擎对比（InnoDB，MyISAM）  
3.4 数据库的锁（行锁，表锁，页级锁，意向锁，读锁，写锁，悲观锁，乐观锁，以及加锁的select sql方式）  
3.5 隔离级别，依次解决的问题（脏读、不可重复读、幻读）  
3.6 事务的ACID  
3.7 B树、B+树  
3.8 优化（explain，慢查询，show profile）  
3.9 数据库的范式。  
3.10 分库分表，主从复制，读写分离。  
3.11 Nosql相关（redis和memcached区别之类的，如果你熟悉redis，redis还有一堆要问的）  

4. 操作系统：  
4.1 进程通信IPC（几种方式），与线程区别  
4.2 OS的几种策略（页面置换，进程调度等，每个里面有几种算法）  
4.3 互斥与死锁相关的  
4.4 linux常用命令（问的时候都会给具体某一个场景）  
4.5 Linux内核相关（select、poll、epoll）  

5. 编程语言（这里只说Java）：  
5.1 把我之后的面经过一遍，Java感觉覆盖的就差不多了，不过下面还是分个类。  
5.2 Java基础（面向对象、四个特性、重载重写、static和final等等很多东西）  
5.3 集合（HashMap、ConcurrentHashMap、各种List，最好结合源码看）  
5.4 并发和多线程（线程池、SYNC和Lock锁机制、线程通信、volatile、ThreadLocal、CyclicBarrier、Atom包、CountDownLatch、AQS、CAS原理等等）  
5.5 JVM（内存模型、GC垃圾回收，包括分代，GC算法，收集器、类加载和双亲委派、JVM调优，内存泄漏和内存溢出）  
5.6 IO/NIO相关  
5.7 反射和代理、异常、Java8相关、序列化  
5.8 设计模式（常用的，jdk中有的）  
5.9 Web相关（servlet、cookie/session、Spring<AOP、IOC、MVC、事务、动态代理>、Mybatis、Tomcat、Hibernate等）  
5.10 看jdk源码  

6. 项目经历  
6.1 这个每个人的项目不同，覆盖的技术也不一样，所以不能统一去说。  
6.2 这里的技巧呢，在下面也会详细说明。  
6.3 无非是找到自己项目中的亮点，简历上叙述的简练并且吸引眼球，同时自己要很熟悉这个点（毕竟可以提前准备）  
6.4 最好自己多练，就像有个剧本或者稿子一样，保证面试中可以很熟练通俗地讲出，并且让人听着很舒服。  

7. 其他扩展技能（这个方方面面太多了，全部掌握基本上不可能，只是作为大家其他时间扩充技能的参考）  
7.1 分布式架构：（了解原理就行，如果真的有实践经验更好）  
· · ·CAP原理和BASE理论。  
· · ·Nosql与KV存储（redis，hbase，mongodb，memcached等）  
· · ·服务化理论（包括服务发现、治理等，zookeeper、etcd、springcloud微服务、）  
· · ·负载均衡（原理、cdn、一致性hash）  
· · ·RPC框架（包括整体的一些框架理论，通信的netty，序列化协议thrift，protobuff等）  
· · ·消息队列（原理、kafka，activeMQ，rocketMQ）  
· · ·分布式存储系统（GFS、HDFS、fastDFS）、存储模型（skipList、LSM等）  
· · ·分布式事务、分布式锁等  
7.2 脚本语言：（只是作为横向扩充，一般问到linux也会问问shell脚本）  
· · ·python  
· · ·php  
· · ·shell  
· · ·golang  
7.3 大数据与数据分析：  
· · ·hadoop生态圈(hive、hbase、hdfs、zookeeper、storm、kafka)  
· · ·spark体系  
· · ·语言：python、R、scala  
· · ·搜索引擎与技术  
7.4 机器学习算法：  
· · ·模型和算法很多。不细说了，如果很熟练就去投算法，国内很多公司都算法岗都很稀缺，其他岗可以大概了解下理论。
7.5 其他工具的理论和使用：
· · ·这个更多了，问的多的比如git、docker、maven/gradle、Jenkins等等，自己需要的话选择性地去学。