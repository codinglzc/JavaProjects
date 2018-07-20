package jianzhioffer.topic10;

/**
 * @description: 面试题10：斐波那契数列（P.74）
 * 题目一：求斐波那契数列的第 n 项。
 * @author: Liu Cong
 * @create: Created at 2018-06-15
 */
public class Fibonacci
{
    /**
     * 效率很低的解法。因为存在大量的重复计算，而且用递归方法计算的时间复杂度是以 n 的指数的方式递增。
     */
    @Deprecated
    public static long solution1(int n)
    {
        if (n <= 0) return 0;
        if (n == 1) return n;

        return solution1(n - 1) + solution1(n - 2);
    }

    /**
     * 避免重复计算。从下往上计算，首先根据 f(0) 和 f(1) 算出 f(2)，再根据 f(1) 和 f(2) 算出 f(3)······
     * <p>
     * 时间复杂度：O(n)
     */
    public static long solution2(int n)
    {
        long[] fibs = {0, 1};
        if (n < 2) return fibs[n];

        long res = 0;
        for (int i = 2; i <= n; i++)
        {
            res = fibs[0] + fibs[1];
            fibs[0] = fibs[1];
            fibs[1] = res;
        }
        return res;
    }

    /**
     * 时间复杂度 O(logn) 但不够实用的解法。
     * 根据数学公式：[f(n)   f(n-1)] = [1 1] 的 n-1 次方
     * ............[f(n-1) f(n-2)]   [1 0]
     * <p>
     * 但事实测试结果为：solution3 比 solution2 要慢
     */
    public static long solution3(int n)
    {
        int[][] matrix = {{1, 1}, {1, 0}};
        return recur(matrix, n - 1)[0][0];
    }

    private static int[][] recur(int[][] matrix, int n)
    {
        if (n == 1)
        {
            return matrix;
        }

        if (n % 2 == 0)
        {
            // 如果 n 为偶数
            return recur(calculateMatrixMulti(matrix, matrix), n / 2);
        } else
        {
            // 如果 n 为奇数
            return calculateMatrixMulti(recur(calculateMatrixMulti(matrix, matrix), (n - 1) / 2), matrix);
        }
    }

    /**
     * 矩阵乘法运算
     *
     * @param matrix1 矩阵1
     * @param matrix2 矩阵2
     * @return 结果矩阵
     */
    private static int[][] calculateMatrixMulti(int[][] matrix1, int[][] matrix2)
    {
        if (matrix1 == null || matrix2 == null) return null;
        if (matrix1.length <= 0 || matrix1[0].length <= 0 || matrix2.length <= 0 || matrix2[0].length <= 0) return null;
        if (matrix1[0].length != matrix2.length) return null;

        int[][] res = new int[matrix1.length][matrix2[0].length];
        for (int i = 0; i < res.length; i++)
        {
            for (int j = 0; j < res[0].length; j++)
            {
                for (int k = 0; k < matrix1[0].length; k++)
                {
                    res[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return res;
    }


    public static void main(String[] args)
    {
        long startTime = System.nanoTime();
        System.out.print(solution1(20));
        long endTime = System.nanoTime();
        System.out.println(" " + (endTime - startTime));

        startTime = System.nanoTime();
        System.out.print(solution2(20));
        endTime = System.nanoTime();
        System.out.println(" " + (endTime - startTime));

        startTime = System.nanoTime();
        System.out.print(solution3(20));
        endTime = System.nanoTime();
        System.out.println(" " + (endTime - startTime));
    }
}
