package concurrency;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description:
 * @Author: lzc
 * @Date: Created at 2018-06-05
 */
public class AttemptLocking
{
    private ReentrantLock lock = new ReentrantLock();

    private void untimed()
    {
        boolean captured = lock.tryLock();
        try
        {
            System.out.println("tryLock(): " + captured);
        } finally
        {
            if (captured) lock.unlock();
        }
    }

    private void timed()
    {
        boolean captured = false;
        try
        {
            captured = lock.tryLock(2, TimeUnit.SECONDS);
            System.out.println("tryLock(2, TimeUnit.SECONDS): " + captured);
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        } finally
        {
            if (captured) lock.unlock();
        }
    }

    public static void main(String[] args)
    {
        final AttemptLocking al = new AttemptLocking();
        al.untimed();
        al.timed();
        // Now create a separate task to grab the lock:
        new Thread()
        {
            {
                setDaemon(true);
            }

            @Override
            public void run()
            {
                al.lock.lock();
                System.out.println("acquired");
            }
        }.start();
        Thread.yield();
        al.untimed();
        al.timed();
    }
}
