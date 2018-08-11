package wangyi.bs20180811;

import java.util.Scanner;

/**
 * <p>
 *
 * </p>
 *
 * @author Liu Cong
 * @since 2018-08-11
 */
public class Que01
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        String[] firstLine = in.nextLine().split(" ");
        int n = Integer.valueOf(firstLine[0]);
        int k = Integer.valueOf(firstLine[1]);
        String[] scores = in.nextLine().split(" ");
        String[] isWaked = in.nextLine().split(" ");

        int base = 0;
        for (int i = 0; i < n; i++)
        {
            if (isWaked[i].equals("1"))
            {
                base += Integer.valueOf(scores[i]);
            }
        }

        int result = base;
        for (int i = 0; i < n; i++)
        {
            if (isWaked[i].equals("0"))
            {
                int tmp = base;
                for (int j = 0, m = i; j < k && m < n; j++, m++)
                {
                    if (isWaked[m].equals("0"))
                        tmp += Integer.valueOf(scores[m]);
                }
                result = tmp > result ? tmp : result;
            }
        }

        System.out.println(result);
    }
}
