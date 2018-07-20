package java8.defaultFuntion;

/**
 * @description:
 * @author: Liu Cong
 * @create: Created at 2018-06-09
 */
public class DefaultFunctionTest1
{
    interface Vehicle
    {
        default void print()
        {
            System.out.println("我是一辆车!");
        }

        static void blowHorn()
        {
            System.out.println("按喇叭!!!");
        }
    }

    interface FourWheeler
    {
        default void print()
        {
            System.out.println("我是一辆四轮车!");
        }
    }

    static class Car implements Vehicle, FourWheeler
    {
        public void print()
        {
            Vehicle.super.print();
            FourWheeler.super.print();
            Vehicle.blowHorn();
            System.out.println("我是一辆汽车!");
        }
    }

    public static void main(String args[]){
        Vehicle vehicle = new Car();
        vehicle.print();
    }
}
