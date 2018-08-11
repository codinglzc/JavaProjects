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
public class Que02
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int n = Integer.valueOf(in.nextLine());
        int[] numArr = new int[n];
        for (int i = 0; i < n; i++)
        {
            numArr[i] = in.nextInt();
        }
        int m = in.nextInt();
        int[] queArr = new int[m];
        for (int i = 0; i < m; i++)
        {
            queArr[i] = in.nextInt();
        }

        long[] sumArr = new long[n];
        long sum = 0;
        for (int i = 0; i < n; i++)
        {
            sum += numArr[i];
            sumArr[i] = sum;
        }

        for (int i = 0; i < m; i++)
        {
            int left = 0, right = n;
            while (left < right)
            {
                int mid = (right - left) / 2 + left;
                if (queArr[i] <= sumArr[mid])
                {
                    right = mid;
                } else
                {
                    left = mid + 1;
                }
            }
            System.out.println(left + 1);
        }
    }

}
