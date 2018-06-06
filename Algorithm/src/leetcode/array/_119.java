package leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 119. Pascal's Triangle II
 * Given an index k, return the kth row of the Pascal's triangle.
 * <p>
 * For example, given k = 3,
 * Return [1,3,3,1].
 * <p>
 * Note:
 * Could you optimize your algorithm to use only O(k) extra space?
 * @Author: lc
 * @Date: Created in 2018/1/21
 */
public class _119
{
    public List<Integer> getRow(int rowIndex)
    {
        List<Integer> row = new ArrayList<Integer>();
        if (rowIndex < 0)
            return row;
        row.add(1);
        for (int i = 1; i <= rowIndex; i++)
        {
            row.add(0);
            for (int j = i; j > 0; j--)
            {
                row.set(j, row.get(j) + row.get(j - 1));
            }
        }
        return row;
    }
}
