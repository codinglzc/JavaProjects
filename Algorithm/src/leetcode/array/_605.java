package leetcode.array;

/**
 * @Description: 605. Can Place Flowers
 * Suppose you have a long flowerbed in which some of the plots are planted and some are not. However, flowers cannot be
 * planted in adjacent plots - they would compete for water and both would die.
 * <p>
 * Given a flowerbed (represented as an array containing 0 and 1, where 0 means empty and 1 means not empty), and a number
 * n, return if n new flowers can be planted in it without violating the no-adjacent-flowers rule.
 * <p>
 * Example 1:
 * Input: flowerbed = [1,0,0,0,1], n = 1
 * Output: True
 * <p>
 * Example 2:
 * Input: flowerbed = [1,0,0,0,1], n = 2
 * Output: False
 * <p>
 * Note:
 * 1. The input array won't violate no-adjacent-flowers rule.
 * 2. The input array size is in the range of [1, 20000].
 * 3. n is a non-negative integer which won't exceed the input array size.
 * @Author: lc
 * @Date: Created in 2018/2/2
 */
public class _605
{
    public boolean canPlaceFlowers(int[] flowerbed, int n)
    {
        int count = 0;
        for (int i = 0; i < flowerbed.length; i++)
        {
            if (flowerbed[i] == 0)
            {
                int next = (i == flowerbed.length - 1) ? 0 : flowerbed[i + 1];
                int pre = (i == 0) ? 0 : flowerbed[i - 1];
                if (next == 0 && pre == 0)
                {
                    flowerbed[i] = 1;
                    count++;
                }
            }
        }
        return count >= n;
    }
}
