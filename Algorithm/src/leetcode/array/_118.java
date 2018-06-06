package leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 118. Pascal's Triangle I
 * Given numRows, generate the first numRows of Pascal's triangle.
 * <p>
 * For example, given numRows = 5,
 * Return
 * [
 * [1],
 * [1,1],
 * [1,2,1],
 * [1,3,3,1],
 * [1,4,6,4,1]
 * ]
 * @Author: lc
 * @Date: Created in 2018/1/21
 */
public class _118
{
    public List<List<Integer>> generate(int numRows)
    {
        List<List<Integer>> result = new ArrayList<>();

        if (numRows <= 0)
            return result;

        List<Integer> preRow = new ArrayList<Integer>();
        preRow.add(1);
        result.add(preRow);

        if (numRows == 1)
            return result;

        for (int i = 2; i <= numRows; i++)
        {
            List<Integer> row = new ArrayList<Integer>();
            row.add(1);
            for (int j = 0; j < preRow.size() - 1; j++)
            {
                row.add(preRow.get(j) + preRow.get(j + 1));
            }
            row.add(1);
            result.add(row);
            preRow = row;
        }
        return result;
    }
}
