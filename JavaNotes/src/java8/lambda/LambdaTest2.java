package java8.lambda;

/**
 * @description: 变量作用域
 * lambda 表达式只能引用 final 或 final 局部变量，这就是说不能再 lambda 内部修改定义在域外的变量，否则会编译报错。
 * @author: Liu Cong
 * @create: Created at 2018-06-08
 */
public class LambdaTest2
{
    static final String salutation = "Hello!";

    interface GreetingService
    {
        void sayMessage(String msg);
    }

    public static void main(String[] args)
    {
        GreetingService greetingService = msg -> System.out.println(salutation + msg);
        greetingService.sayMessage("W3CSchool");
    }
}
