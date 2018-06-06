package concurrency;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @Description: CountDownLatch使用例子
 * CountDownLatch可以控制线程的执行，他可以让所有持有他的多个线程同时执行，也可以控制单个线程执行。
 * 他初始化的时候会传出一个int类型的参数i，调用一次countDown(）方法后i的值会减1。
 * 在一个线程中如果调用了await()方法，这个线程就会进入到等待的状态，当参数i为0的时候这个线程才继续执行。
 * <p>
 * 例子：
 * TaskPortion是准备工作，WaitingTask需要等待准备工作全部做完后才开始运行。
 * @Author: lzc
 * @Date: Created at 2018-06-06
 */
public class CountDownLatchDemo
{
    static final int SIZE = 100;

    public static void main(String[] args)
    {
        ExecutorService exec = Executors.newCachedThreadPool();
        // All must share a single CountDownLatch object:
        CountDownLatch latch = new CountDownLatch(SIZE);
        for (int i = 0; i < 10; i++)
        {
            exec.execute(new WaitingTask(latch));
        }
        for (int i = 0; i < SIZE; i++)
        {
            exec.execute(new TaskPortion(latch));
        }
        System.out.println("Launched all tasks");
        exec.shutdown(); // Quit when all tasks complete
    }

    static class TaskPortion implements Runnable
    {
        private static int counter = 0;
        private final int id = counter++;
        private static Random rand = new Random(47);
        private final CountDownLatch latch;

        public TaskPortion(CountDownLatch latch)
        {
            this.latch = latch;
        }

        @Override
        public void run()
        {
            try
            {
                doWork();
                latch.countDown();
            } catch (InterruptedException e)
            {
                System.out.println("TaskPortion interrupted");
            }
        }

        public void doWork() throws InterruptedException
        {
            TimeUnit.MILLISECONDS.sleep(rand.nextInt(2000));
            System.out.println(this + "completed");
        }

        @Override
        public String toString()
        {
            return String.format("%1$-3d ", id);
        }
    }

    static class WaitingTask implements Runnable
    {
        private static int counter = 0;
        private final int id = counter++;
        private final CountDownLatch latch;

        public WaitingTask(CountDownLatch latch)
        {
            this.latch = latch;
        }

        @Override
        public void run()
        {
            try
            {
                latch.await();
                System.out.println("Latch barrier passed for " + this);
            } catch (InterruptedException e)
            {
                System.out.println(this + " interrupted");
            }
        }

        @Override
        public String toString()
        {
            return String.format("WaitingTask %1$-3d", id);
        }
    }
}
