package concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Author: lzc
 * @Date: Created at 2018-06-05
 */
public class OrnamentalGarden
{
    private static class Count
    {
        private int count = 0;
        private Random rand = new Random(47);

        public synchronized int increment()
        {
            int temp = count;
            if (rand.nextBoolean())
                Thread.yield();
            return (count = ++temp);
        }

        public synchronized int value()
        {
            return count;
        }
    }

    private static class Entrance implements Runnable
    {
        private static Count count = new Count();
        private static List<Entrance> entrances = new ArrayList<>();
        private int number = 0;
        private final int id;
        private static volatile boolean canceled = false;

        static void cancel()
        {
            canceled = true;
        }

        Entrance(int id)
        {
            this.id = id;
            entrances.add(this);
        }

        @Override
        public void run()
        {
            while (!canceled)
            {
                synchronized (this)
                {
                    number++;
                }
                System.out.println(this + " Total: " + count.increment());
                try
                {
                    TimeUnit.MILLISECONDS.sleep(100);
                } catch (InterruptedException e)
                {
                    System.out.println("sleep interrupted");
                }
            }
            System.out.println("Stopping " + this);
        }

        synchronized int getValue()
        {
            return number;
        }

        @Override
        public String toString()
        {
            return "Entrance " + id + ": " + getValue();
        }

        static int getTotalCount()
        {
            return count.value();
        }

        static int sumEntrances()
        {
            int sum = 0;
            for (Entrance e : entrances)
                sum += e.getValue();
            return sum;
        }
    }

    public static void main(String[] args) throws InterruptedException
    {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++)
        {
            exec.execute(new Entrance(i));
        }
        TimeUnit.SECONDS.sleep(3);
        Entrance.cancel();
        if (!exec.awaitTermination(250, TimeUnit.MILLISECONDS))
            System.out.println("Some tasks were not terminated!");
        System.out.println("Total: " + Entrance.getTotalCount());
        System.out.println("Sum of Entrances: " + Entrance.sumEntrances());
    }
}
