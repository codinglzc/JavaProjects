package lintcode;

/**
 * @Description: 123. 单词搜索
 * 给出一个二维的字母板和一个单词，寻找字母板网格中是否存在这个单词。
 * <p>
 * 单词可以由按顺序的相邻单元的字母组成，其中相邻单元指的是水平或者垂直方向相邻。每个单元中的字母最多只能使用一次。
 * <p>
 * 样例：
 * 给出board =
 * [
 * "ABCE",
 * "SFCS",
 * "ADEE"
 * ]
 * word = "ABCCED"， ->返回 true,
 * word = "SEE"，-> 返回 true,
 * word = "ABCB"， -> 返回 false.
 * @Author: lc
 * @Date: Created in 2018/3/15
 */
public class _123
{
    /**
     * @param board: A list of lists of character
     * @param word:  A string
     * @return: A boolean
     */
    public boolean exist(char[][] board, String word)
    {
        // write your code here
        if (word.length() <= 0) return true;
        if (board.length == 0) return false;

        boolean flag = false;
        int[][] flags = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++)
        {
            for (int j = 0; j < board[i].length; j++)
            {
                if (board[i][j] == word.charAt(0))
                {
                    flag = flag || recur(board, word, 0, word.length(), i, j, flags);
                }
            }
        }
        return flag;
    }

    public boolean recur(char[][] board, String word, int index, int len, int x, int y, int[][] flags)
    {
        if (index == len) return true;

        if (x >= 0 && x < board.length && y >= 0 && y < board[x].length && flags[x][y] != 1 && board[x][y] == word.charAt(index))
        {
            flags[x][y] = 1;
            boolean res = recur(board, word, index + 1, word.length(), x + 1, y, flags)
                    || recur(board, word, index + 1, word.length(), x - 1, y, flags)
                    || recur(board, word, index + 1, word.length(), x, y + 1, flags)
                    || recur(board, word, index + 1, word.length(), x, y - 1, flags);
            flags[x][y] = 0;
            return res;
        }
        return false;
    }

    public static void main(String[] args)
    {
        _123 obj = new _123();
        char[][] board = {
                {'A', 'B', 'C', 'E'}
                , {'S', 'F', 'C', 'S'}
                , {'A', 'D', 'E', 'E'}
        };
        boolean res = obj.exist(board, "SEE");
        System.out.println(res);
    }
}
