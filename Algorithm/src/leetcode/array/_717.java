package leetcode.array;

/**
 * @Description: 717. 1-bit and 2-bit Characters
 * We have two special characters. The first character can be represented by one bit 0. The second character can be represented by two bits (10 or 11).
 * <p>
 * Now given a string represented by several bits. Return whether the last character must be a one-bit character or not. The given string will always end with a zero.
 * <p>
 * Example 1:
 * Input:
 * bits = [1, 0, 0]
 * Output: True
 * Explanation:
 * The only way to decode it is two-bit character and one-bit character. So the last character is one-bit character.
 * <p>
 * Example 2:
 * Input:
 * bits = [1, 1, 1, 0]
 * Output: False
 * Explanation:
 * The only way to decode it is two-bit character and two-bit character. So the last character is NOT one-bit character.
 * @Author: lc
 * @Date: Created in 2017/12/27
 */
public class _717
{
    public boolean isOneBitCharacter1(int[] bits)
    {
        int i = 0;
        while (i < bits.length - 1)
        {
            if (bits[i] == 1)
                i += 2;
            else
                i++;
        }
        return i == bits.length - 1;
    }

    public boolean isOneBitCharacter2(int[] bits)
    {
        for (int i = bits.length - 2; i >= 0; i--)
        {
            if (bits[i] == 0)
                return (bits.length - i) % 2 == 0;
        }
        return (bits.length + 1) % 2 == 0;
    }
}
