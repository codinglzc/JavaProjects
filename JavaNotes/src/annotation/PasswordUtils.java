package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.List;

/**
 * @Description: 注解的元素在使用时表现为名——值对的形式，并需要置于@UseCase声明之后的括号内。
 * @Author: lzc
 * @Date: Created at 2018-06-04
 */
public class PasswordUtils
{
    /**
     * @Description: 下面可以用它来跟踪一个项目中的用例。
     * @Author: lzc
     * @Date: Created at 2018-06-04
     */
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    public static @interface UseCase
    {
        // id和description类似方法定义：
        public int id();

        public String description() default "no desciption";    // 如果在注解沐某个方法时没有给出description的值，则该注解的处理器就会使用此元素的默认值。
    }

    @UseCase(id = 47, description = "Passwords must contain at least one numeric")
    public boolean validatePassword(String password)
    {
        return (password.matches("\\w*\\d\\w*"));
    }

    @UseCase(id = 48)
    public String encryptPassword(String password)
    {
        return new StringBuilder(password).reverse().toString();
    }

    @UseCase(id = 49, description = "New password can't equal previously used ones")
    public boolean checkForNewPassword(List<String> prevPasswords, String password)
    {
        return !prevPasswords.contains(password);
    }
}
