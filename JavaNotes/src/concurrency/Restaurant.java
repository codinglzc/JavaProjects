package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Author: lzc
 * @Date: Created at 2018-06-06
 */
public class Restaurant
{
    Meal meal;
    ExecutorService exec = Executors.newCachedThreadPool();
    final WaitPerson waitPerson = new WaitPerson(this);
    final Chef chef = new Chef(this);

    private Restaurant()
    {
        exec.execute(chef);
        exec.execute(waitPerson);
    }

    private static class Meal
    {
        private final int orderNum;

        Meal(int orderNum)
        {
            this.orderNum = orderNum;
        }

        @Override
        public String toString()
        {
            return "Meal " + orderNum;
        }
    }

    private static class WaitPerson implements Runnable
    {
        private Restaurant restaurant;

        WaitPerson(Restaurant restaurant)
        {
            this.restaurant = restaurant;
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
                        while (restaurant.meal == null)
                        {
                            wait(); // ... for the chef to produce a meal
                        }
                    }
                    System.out.println("Waitperson got " + restaurant.meal);
                    synchronized (restaurant.chef)
                    {
                        restaurant.meal = null;
                        restaurant.chef.notifyAll(); // Ready for another
                    }
                }
            } catch (InterruptedException e)
            {
                System.out.println("WaitPerson interrupted");
            }
        }
    }

    private static class Chef implements Runnable
    {
        private Restaurant restaurant;
        private int count = 0;

        Chef(Restaurant restaurant)
        {
            this.restaurant = restaurant;
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
                        while (restaurant.meal != null)
                        {
                            wait();
                        }
                    }
                    if (++count == 10)
                    {
                        System.out.println("Out of food, closing");
                        restaurant.exec.shutdownNow();
                    }
                    System.out.println("Order up!");
                    synchronized (restaurant.waitPerson)
                    {
                        restaurant.meal = new Meal(count);
                        restaurant.waitPerson.notifyAll();
                    }
                    TimeUnit.MILLISECONDS.sleep(100);
                }
            } catch (InterruptedException e)
            {
                System.out.println("Chef interrupted");
            }
        }
    }

    public static void main(String[] args)
    {
        new Restaurant();
    }
}
