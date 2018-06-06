package concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * @Description: 使用CyclicBarrier模拟马赛跑过程
 * 1.CyclicBarrier初始化时规定一个数目，然后计算调用了CyclicBarrier.await()进入等待的线程数。当线程数达到了这个数目时，所有进入等待状态的线程被唤醒并继续。
 * 2.CyclicBarrier就象它名字的意思一样，可看成是个障碍， 所有的线程必须到齐后才能一起通过这个障碍。
 * 3.CyclicBarrier初始时还可带一个Runnable的参数， 此Runnable任务在CyclicBarrier的数目达到后，所有其它线程被唤醒前被执行。
 * @Author: lzc
 * @Date: Created at 2018-06-06
 */
public class CyclicBarrierHorseRace
{
    static final int FINISH_LINE = 75;
    private List<Horse> horses = new ArrayList<>();
    private ExecutorService exec = Executors.newCachedThreadPool();
    private CyclicBarrier barrier;

    public CyclicBarrierHorseRace(int nHorses, final int pause)
    {
        barrier = new CyclicBarrier(nHorses, new Runnable()
        {
            @Override
            public void run()
            {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < FINISH_LINE; i++)
                {
                    sb.append("="); // The fence on the racetrack
                }
                System.out.println(sb);
                for (Horse horse : horses)
                    System.out.println(horse.tracks());
                for (Horse horse : horses)
                {
                    if (horse.getStrides() >= FINISH_LINE)
                    {
                        System.out.println(horse + " won!");
                        exec.shutdownNow();
                        return;
                    }
                }
                try
                {
                    TimeUnit.MILLISECONDS.sleep(pause);
                } catch (InterruptedException e)
                {
                    System.out.println("barrier-action sleep interrupted");
                }
            }
        });

        for (int i = 0; i < nHorses; i++)
        {
            Horse horse = new Horse(barrier);
            horses.add(horse);
            exec.execute(horse);
        }
    }

    public static void main(String[] args)
    {
        int nHorses = 7;
        int pause = 200;
        new CyclicBarrierHorseRace(nHorses, pause);
    }

    static class Horse implements Runnable
    {
        private static int counter = 0;
        private final int id = counter++;
        private int strides = 0;
        private static Random rand = new Random(47);
        private static CyclicBarrier barrier;

        public Horse(CyclicBarrier barrier)
        {
            this.barrier = barrier;
        }

        public synchronized int getStrides()
        {
            return strides;
        }

        @Override
        public void run()
        {
            try
            {
                while (!Thread.interrupted())
                {
                    synchronized (this)
                    {
                        strides += rand.nextInt(3); // Produces 0, 1 or 2
                    }
                    barrier.await();
                }
            } catch (InterruptedException | BrokenBarrierException e)
            {
                e.printStackTrace();
            }
        }

        @Override
        public String toString()
        {
            return "Horse " + id + " ";
        }

        public String tracks()
        {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < getStrides(); i++)
            {
                sb.append("*");
            }
            sb.append(id);
            return sb.toString();
        }
    }
}
