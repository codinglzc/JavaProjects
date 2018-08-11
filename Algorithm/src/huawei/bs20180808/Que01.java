package huawei.bs20180808;

import java.util.Scanner;

/**
 * <p>
 *
 * </p>
 *
 * @author Liu Cong
 * @since 2018-08-08
 */
public class Que01
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        char[] chars = input.toCharArray();
        for (int i = 0; i < chars.length; i++)
        {
            if ((chars[i] >= 'a' && chars[i] <= 'z'))
                chars[i] = (char) (chars[i] - 'a' + 'A');
            else if ((chars[i] >= 'A' && chars[i] <= 'Z'))
                chars[i] = (char) (chars[i] - 'A' + 'a');
        }
        System.out.println(String.valueOf(chars));
    }
}
