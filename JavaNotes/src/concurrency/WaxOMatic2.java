package concurrency;

import com.sun.xml.internal.bind.v2.model.annotation.RuntimeAnnotationReader;

import java.sql.Time;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description:
 * @Author: lzc
 * @Date: Created at 2018-06-06
 */
public class WaxOMatic2
{
    static class Car
    {
        private Lock lock = new ReentrantLock();
        private Condition condition = lock.newCondition();
        private boolean waxOn = false;

        public void waxed()
        {
            lock.lock();
            try
            {
                waxOn = true;
                condition.signalAll();
            } finally
            {
                lock.unlock();
            }
        }

        public void buffed()
        {
            lock.lock();
            try
            {
                waxOn = false;
                condition.signalAll();
            } finally
            {
                lock.unlock();
            }
        }

        public void waitForWaxing() throws InterruptedException
        {
            lock.lock();
            try
            {
                while (!waxOn)
                    condition.await();
            } finally
            {
                lock.unlock();
            }
        }

        public void waitForBuffing() throws InterruptedException
        {
            lock.lock();
            try
            {
                while (waxOn)
                    condition.await();
            } finally
            {
                lock.unlock();
            }
        }
    }

    static class WaxOn implements Runnable
    {
        private Car car;

        public WaxOn(Car car)
        {
            this.car = car;
        }

        @Override
        public void run()
        {
            try
            {
                while (!Thread.interrupted())
                {
                    System.out.println("Wax On! ");
                    TimeUnit.MILLISECONDS.sleep(200);
                    car.waxed();
                    car.waitForBuffing();
                }
            } catch (InterruptedException e)
            {
                System.out.println("Exiting via interrupt");
            }
            System.out.println("Ending Wax On task");
        }
    }

    static class WaxOff implements Runnable
    {
        private Car car;

        public WaxOff(Car car)
        {
            this.car = car;
        }

        @Override
        public void run()
        {
            try
            {
                while (!Thread.interrupted())
                {
                    car.waitForWaxing();
                    System.out.println("Wax Off!");
                    TimeUnit.MILLISECONDS.sleep(200);
                    car.buffed();
                }
            } catch (InterruptedException e)
            {
                System.out.println("Exiting via interrupt");
            }
            System.out.println("Ending Wax Off task");
        }
    }

    public static void main(String[] args) throws InterruptedException
    {
        Car car = new Car();
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new WaxOff(car));
        exec.execute(new WaxOn(car));
        TimeUnit.SECONDS.sleep(5);
        exec.shutdownNow();
    }
}
