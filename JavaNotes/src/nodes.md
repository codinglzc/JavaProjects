### 1. 动态链接库和静态链接库的优劣点比较
#### 1.1 静态链接库的优点  
 (1) 代码装载速度快，执行速度略比动态链接库快；  
 (2) 只需保证在开发者的计算机中有正确的.LIB文件，在以二进制形式发布程序时不需考虑在用户的计算机上.LIB文件是否存在及版本问题，可避免DLL地狱等问题。  
#### 1.2 动态链接库的优点  
 (1) 更加节省内存并减少页面交换；  
 (2) DLL文件与EXE文件独立，只要输出接口不变（即名称、参数、返回值类型和调用约定不变），更换DLL文件不会对EXE文件造成任何影响，因而极大地提高了可维护性和可扩展性；   
 (3) 不同编程语言编写的程序只要按照函数调用约定就可以调用同一个DLL函数；  
 (4)适用于大规模的软件开发，使开发过程独立、耦合度小，便于不同开发者和开发组织之间进行开发和测试。  
#### 1.3 不足之处 
 (1) 使用静态链接生成的可执行文件体积较大，包含相同的公共代码，造成浪费；  
 (2) 使用动态链接库的应用程序不是自完备的，它依赖的DLL模块也要存在，如果使用载入时动态链接，程序启动时发现DLL不存在，系统将终止程序并给出错误信息。而使用运行时动态链接，系统不会终止，但由于DLL中的导出函数不可用，程序会加载失败；速度比静态链接慢。当某个模块更新后，如果新模块与旧的模块不兼容，那么那些需要该模块才能运行的软件，统统撕掉。这在早期Windows中很常见。

### 2.
以下哪种方式，在读取磁盘上多个顺序数据块时的效率最高？  
A.	中断控制方式  
B.	DMA方式  
C.	通道方式  
D.	程序直接访问方式  
E.	循环检查I/O方式  
F.	以上访问方式都一样  

答案选C，通道方式。  
I/O中断方式是以字节为单位，DMA控制方式是以一个连续的数据块为单位，I/O通道控制方式是DMA控制方式的发展，是以一组数据块为单位的，即可以连续读取多个数据块。   

### 3. 大小端计算
已知IBM的PowerPC是big-endian字节序列而Intel的X86是little-endian字节序，如果在地址啊存储的整形值时0x04030201，那么地址为a+3的字节内存储的值在PowerPC和Intel X86结构下的值分别是？

大端从大地址开始存储，小端相反，两者都是从数据低位开始存起；  
假设从上至下地址递增，则  

| PowerPC（大）： | Intel X86（小）：|       |
| :------------: | :-------------: | :---: |
|04              | 01              | 低    |
|03              | 02              |       |
|02              | 03              |       |  
|01              | 04              | 高    |
a+3指向最大的地址，所以分别为1 4

### 4.
* ICMP是网络层，  
* UDP是传输层，  
* FTP和HTTP是应用层   
* 目前VPN隧道协议主要有4种：点到点隧道协议PPTP、第二层隧道协议L2TP、网络层隧道协议IPSec以及SOCKS v5协议。其中，PPTP和L2TP工作在数据链路层，IPSec工作在网络层，SOCK v5工作在会话层。

### 5. HashMap、HashTable、ConcurrentHashMap
hashMap在单线程中使用大大提高效率，在多线程的情况下使用hashTable来确保安全。hashTable中使用synchronized关键字来实现安全机制，但是synchronized是对整张hash表进行锁定即让线程独享整张hash表，在安全同时造成了浪费。concurrentHashMap采用分段加锁的机制来确保安全。

ConcurrentHashMap使用segment来分段和管理锁，segment继承自ReentrantLock，因此ConcurrentHashMap使用ReentrantLock来保证线程安全。

### 6. Arrays.asList()
Arrays.asList()将一个数组转化为一个List对象，这个方法会返回一个ArrayList类型的对象， 这个ArrayList类并非java.util.ArrayList类，而是Arrays类的静态内部类！用这个对象对列表进行添加删除更新操作，就会报UnsupportedOperationException异常。

### 7. == 优先于 三目运算符，三目运算符从右向左执行
boolean b=true?false:true==true?false:true;

==  优先级高于 三目运算符，先判断   true == true，此时返回为  true,  
这时表达式为   boolean b = true?false:true?false:true  
此时三目运算符从右向左执行,true?false:true，返回false  
这时表达式为  boolean b = true?false:false;  
结果为：boolean b = false ;  

