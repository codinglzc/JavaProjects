package lintcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: N皇后问题
 * http://blog.csdn.net/tianyaleixiaowu/article/details/50945054
 * @Author: lc
 * @Date: Created in 2018/3/12
 */
public class _33
{
    List<List<String>> res = new ArrayList<>();
    int[] arr;  // arr[row] = col
    String str = "";

    /*
     * @param n: The number of queens
     * @return: All distinct solutions
     */
    public List<List<String>> solveNQueens(int n)
    {
        // write your code here
        arr = new int[n + 1];
        for (int i = 1; i <= n; i++)
            str += ".";

        recur(n, 1);
        return res;
    }

    // 递归函数
    public void recur(int n, int row)
    {
        if (row > n)
        {
            // 即找到一个解，添加入list
            List<String> item = new ArrayList<>();
            for (int i = 1; i <= n; i++)
            {
                String s = new String(str);
                char[] cs = s.toCharArray();
                cs[arr[i] - 1] = 'Q';
                item.add(String.valueOf(cs));
            }
            res.add(item);
            return;
        }

        for (int i = 1; i <= n; i++)
        {
            arr[row] = i;
            if (check(row, i))
            {
                recur(n, row + 1);
            }
        }

    }

    // 判断是否可以放置女王
    public boolean check(int row, int col)
    {
        for (int i = 1; i < row; i++)
        {
            if (arr[i] == col || Math.abs(i - row) == Math.abs(arr[i] - col)) return false;
        }
        return true;
    }

    public static void main(String[] args)
    {
        _33 obj = new _33();
        obj.solveNQueens(7);
        System.out.println();
    }
}
