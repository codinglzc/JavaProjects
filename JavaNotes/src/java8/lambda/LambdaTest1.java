package java8.lambda;

/**
 * @description: Lambda 表达式实例
 * 使用 Lambda 表达式需要注意以下两点：
 * 1. Lambda 表达式主要用来定义行内执行的方法类型接口，例如，一个简单方法接口。在下面例子中，我们使用各种类型的Lambda表达式来定义
 * MathOperation接口的方法。然后我们定义了sayMessage的执行。
 * 2. Lambda 表达式免去了使用匿名方法的麻烦，并且给予Java简单但是强大的函数化的编程能力。
 * @author: Liu Cong
 * @create: Created at 2018-06-08
 */
public class LambdaTest1
{
    interface MathOperation
    {
        int operation(int a, int b);
    }

    interface GreetingService
    {
        void sayMessage(String msg);
    }

    private int operate(int a, int b, MathOperation mathOperation)
    {
        return mathOperation.operation(a, b);
    }

    public static void main(String[] args)
    {
        LambdaTest1 tester = new LambdaTest1();

        // 类型声明
        MathOperation addition = (int a, int b) -> a + b;

        // 不用类型声明
        MathOperation subtraction = (a, b) -> a - b;

        // 大括号中的返回语句
        MathOperation multiplication = (int a, int b) ->
        {
            return a * b;
        };

        // 没有大括号及返回语句
        MathOperation division = (a, b) -> a / b;

        System.out.println("10 + 5 = " + tester.operate(10, 5, addition));
        System.out.println("10 - 5 = " + tester.operate(10, 5, subtraction));
        System.out.println("10 x 5 = " + tester.operate(10, 5, multiplication));
        System.out.println("10 / 5 = " + tester.operate(10, 5, division));

        // 不用括号
        GreetingService greetingService1 = msg -> System.out.println("Hello " + msg);

        // 用括号
        GreetingService greetingService2 = msg -> System.out.println("Hello " + msg);

        greetingService1.sayMessage("W3CSchool");
        greetingService2.sayMessage("Google");
    }
}
