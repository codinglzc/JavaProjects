package leetcode.array;

import java.util.Arrays;

/**
 * @Description: 566. Reshape the Matrix
 * <p>
 * In MATLAB, there is a very useful function called 'reshape', which can reshape a matrix into a new one with different
 * size but keep its original data.
 * <p>
 * You're given a matrix represented by a two-dimensional array, and two positive integers r and c representing the row
 * number and column number of the wanted reshaped matrix, respectively.
 * <p>
 * The reshaped matrix need to be filled with all the elements of the original matrix in the same row-traversing order
 * as they were.
 * <p>
 * If the 'reshape' operation with given parameters is possible and legal, output the new reshaped matrix; Otherwise,
 * output the original matrix.
 * <p>
 * Example 1:
 * Input:
 * nums = [[1,2], [3,4]]
 * r = 1, c = 4
 * Output:
 * [[1,2,3,4]]
 * Explanation:
 * The row-traversing of nums is [1,2,3,4]. The new reshaped matrix is a 1 * 4 matrix, fill it row by row by using the previous list.
 * @Author: lc
 * @Date: Created in 2017/12/11
 */
public class _566
{
    /**
     * （1）origin_r * origin_c 的矩阵 reshape为 r*c的矩阵，需要满足：
     * origin_r * origin_c=r*c
     * （2）元素位置对应的关系
     * 如果将矩阵横向展开为一维数组，元素个数为n=origin_r * origin_c
     * 在元素在一维数组中对应的位置i：
     * 原矩阵位置[i/origin_c,i%origin_c]
     * 新矩阵位置[i/c,i%c]
     */
    public int[][] matrixReshape(int[][] nums, int r, int c)
    {
        if (nums.length < 1 || r * c != nums.length * nums[0].length)
            return nums;

        int[][] result = new int[r][c];
        for (int i = 0; i < r * c; i++)
        {
            result[i / c][i % c] = nums[i / nums[0].length][i % nums[0].length];
        }
        return result;
    }

    public static void main(String[] args)
    {
        int[][] nums = {{1, 2}, {3, 4}};
        _566 obj = new _566();
        System.out.println(Arrays.toString(obj.matrixReshape(nums, 1, 4)[0]));
    }
}
