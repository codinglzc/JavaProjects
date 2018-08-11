package huawei.bs20180808;

import java.util.*;

/**
 * <p>
 *
 * </p>
 *
 * @author Liu Cong
 * @since 2018-08-08
 */
public class Que02Error
{
    public static class Baby implements Comparable
    {
        int value;
        int weight;
        double valuePerWeight;

        public Baby(int value, int weight, double valuePerWeight)
        {
            this.value = value;
            this.weight = weight;
            this.valuePerWeight = valuePerWeight;
        }

        @Override
        public int compareTo(Object o)
        {
            if (this.valuePerWeight > ((Baby) o).valuePerWeight)
                return -1;
            else if (this.valuePerWeight < ((Baby) o).valuePerWeight)
                return 1;
            return 0;
        }
    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        String[] values = in.nextLine().split(",");
        String[] weights = in.nextLine().split(",");
        int capacity = Integer.valueOf(in.nextLine());

        // 单位重量的价值
        List<Baby> babyList = new ArrayList<>();
        for (int i = 0; i < values.length; i++)
        {
            babyList.add(new Baby(Integer.valueOf(values[i]), Integer.valueOf(weights[i]),
                    Double.valueOf(values[i]) / Double.valueOf(weights[i])));
        }

        // 根据 valuePerWeight 的值从大到小排序
        Collections.sort(babyList);

        int result = 0;
        for (int i = 0; i < babyList.size(); i++)
        {
            Baby tmp = babyList.get(i);
            if (tmp.weight <= capacity)
            {
                result += tmp.value;
                capacity -= tmp.weight;
            }
        }

        System.out.println(result);
    }
}
