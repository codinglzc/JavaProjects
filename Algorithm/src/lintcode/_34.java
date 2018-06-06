package lintcode;

/**
 * @Description: 34. N皇后问题 II
 * 根据n皇后问题，现在返回n皇后不同的解决方案的数量而不是具体的放置布局。
 * @Author: lc
 * @Date: Created in 2018/3/12
 */
public class _34
{
    /**
     * @param n: The number of queens.
     * @return: The total number of distinct solutions.
     */

    int count = 0;
    int[] arr;

    public int totalNQueens(int n) {
        // write your code here
        arr = new int[n];
        recur(n, 0);
        return count;
    }

    public void recur(int n, int row)
    {
        if (row == n)
        {
            count++;
            return ;
        }

        for (int i = 0; i < n; i++)
        {
            arr[row] = i;
            if (check(row, i)) recur(n, row+1);
        }
    }

    public boolean check(int row, int col)
    {
        for (int i = row-1; i>=0; i--)
        {
            if (arr[i] == col || Math.abs(i-row) == Math.abs(arr[i]-col)) return false;
        }
        return true;
    }
}
