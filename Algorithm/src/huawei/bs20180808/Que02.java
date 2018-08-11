package huawei.bs20180808;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * <p>
 *
 * </p>
 *
 * @author Liu Cong
 * @since 2018-08-08
 */
public class Que02
{
    public static int result = 0;

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        String[] values = in.nextLine().split(",");
        String[] weights = in.nextLine().split(",");
        int capacity = Integer.valueOf(in.nextLine());
        int length = values.length;

        recur(values, weights, 0, length, capacity, 0);

        System.out.println(result);
    }

    private static void recur(String[] values, String[] weights, int index, int length, int capacity, int curRes)
    {
        if (index >= length)
        {
            result = result > curRes ? result : curRes;
            return;
        }

        for (int i = index; i < length; i++)
        {
            int weight;
            if ((weight = Integer.valueOf(weights[i])) <= capacity)
            {
                capacity -= weight;
                curRes += Integer.valueOf(values[i]);
                recur(values, weights, i + 1, length, capacity, curRes);
                curRes -= Integer.valueOf(values[i]);
                capacity += weight;
            }
        }
    }
}
