package jianzhioffer.topic12;

/**
 * @description: 面试题12：矩阵中的路径（P.89）
 * 题目：请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一格开始，每一步可以在矩阵中
 * 向左、右、上、下移动一格。如果一条路径经过了矩阵的某一格，那么该路径也不能再次进入该格子。
 * @author: Liu Cong
 * @create: Created at 2018-06-20
 */
public class StringPathInMatrix
{
    /**
     * 回朔法求解
     * <p>
     * 分析：
     * 1.当矩阵中坐标为(row, col)的格子和路径字符串中下标为 pathLength 的字符一样时，从4个相邻的格子(row-1, col)、(row+1, col)、
     * (row, col+1)、(row, col-1)中去定位路径字符串中下标为 pathLength+1 的字符；
     * 2.如果4个相邻的格子都没有匹配字符串中下标为 pathLength+1 的字符，则表明当前路径字符串中下标为 pathLength 的字符在矩阵中的定位不
     * 正确，我们需要回到前一个字符 (pathLength-1)，然后重新定位；
     * 3.一直重复这个过程，直到路径字符串上的所有字符都在矩阵中找到合适的位置。
     *
     * @param matrix 字符矩阵
     * @param str    字符路径
     * @return boolean
     */
    public static boolean solution1(char[][] matrix, String str)
    {
        if (matrix == null || matrix.length <= 0 || matrix[0].length <= 0 || str == null)
            return false;

        boolean[][] isVisited = new boolean[matrix.length][matrix[0].length];

        int pathLength = 0;
        for (int i = 0; i < matrix.length; i++)
        {
            for (int j = 0; j < matrix[0].length; j++)
            {
                if (hasPathCore(matrix, i, j, str, pathLength, isVisited))
                {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean hasPathCore(char[][] matrix, int row, int col, String str, int pathLength, boolean[][] isVisited)
    {
        if (pathLength >= str.length()) return true;

        boolean hasPath = false;
        if (row >= 0 && row < matrix.length && col >= 0 && col < matrix[0].length && matrix[row][col] == str.charAt(pathLength) && !isVisited[row][col])
        {
            pathLength++;
            isVisited[row][col] = true;

            hasPath = hasPathCore(matrix, row + 1, col, str, pathLength, isVisited)
                    || hasPathCore(matrix, row - 1, col, str, pathLength, isVisited)
                    || hasPathCore(matrix, row, col + 1, str, pathLength, isVisited)
                    || hasPathCore(matrix, row, col - 1, str, pathLength, isVisited);

            if (!hasPath)
            {
                isVisited[row][col] = false;
            }
        }
        return hasPath;
    }
}
