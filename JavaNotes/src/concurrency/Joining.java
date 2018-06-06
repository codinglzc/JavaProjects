package concurrency;

/**
 * @Description:
 * @Author: lzc
 * @Date: Created at 2018-06-05
 */
public class Joining
{
    private static class Sleeper extends Thread
    {
        private int duration;

        Sleeper(String name, int duration)
        {
            super(name);
            this.duration = duration;
            start();
        }

        @Override
        public void run()
        {
            try
            {
                sleep(duration);
            } catch (InterruptedException e)
            {
                System.out.println(getName() + " was interrupted. isInterrupted(): " + isInterrupted());
                return;
            }
            System.out.println(getName() + " has awakened");
        }
    }

    private static class Joiner extends Thread
    {
        private Sleeper sleeper;

        Joiner(String name, Sleeper sleeper)
        {
            super(name);
            this.sleeper = sleeper;
            start();
        }

        @Override
        public void run()
        {
            try
            {
                sleeper.join();
            } catch (InterruptedException e)
            {
                System.out.println("Interrupted");
            }
            System.out.println(getName() + " join completed");
        }

        public static void main(String[] args)
        {
            Sleeper sleepy = new Sleeper("Sleepy", 1500);
            Sleeper grumpy = new Sleeper("Grumpy", 1500);
            Joiner dopey = new Joiner("Dopey", sleepy);
            Joiner doc = new Joiner("Doc", grumpy);
            grumpy.interrupt();
        }
    }
}
