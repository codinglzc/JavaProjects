package java8.foreach;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

/**
 * @description: 定义了4个方法的Car这个类为例子，区分Java中支持的4种不同的方法引用。
 * @author: Liu Cong
 * @create: Created at 2018-06-08
 */
public class Car
{
    public static Car create(final Supplier<Car> supplier)
    {
        return supplier.get();
    }

    public static void collide(final Car car)
    {
        System.out.println("Collided " + car.toString());
    }

    public void follow(final Car another)
    {
        System.out.println("Following the " + another.toString());
    }

    public void repair()
    {
        System.out.println("Repaired " + this.toString());
    }

    public static void main(String[] args)
    {
        // 静态方法引用：语法是Class::static_method
        final Car car = Car.create(Car::new);
        final List<Car> cars = Arrays.asList(car);

        // 特定类的任意对象的方法引用：语法是Class::method
        cars.forEach(Car::collide);

        // 特定对象的方法引用：语法是instance::method
        cars.forEach(Car::repair);

        // 构造器引用：语法是Class::new, 或者更一般的Class<T>::new
        final Car police = Car.create(Car::new);
        cars.forEach(police::follow);

        List<String> names = new ArrayList<>();
        names.add("Google");
        names.add("W3CSchool");
        names.add("Taobao");
        names.add("Baidu");
        names.add("Sina");
        names.forEach(System.out::println);
    }
}
