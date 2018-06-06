package leetcode.array;

/**
 * @Description: 48. Rotate Image
 * You are given an n x n 2D matrix representing an image.
 * <p>
 * Rotate the image by 90 degrees (clockwise).
 * <p>
 * Note:
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
 * <p>
 * Example 1:
 * Given input matrix =
 * [
 * [1,2,3],
 * [4,5,6],
 * [7,8,9]
 * ],
 * rotate the input matrix in-place such that it becomes:
 * [
 * [7,4,1],
 * [8,5,2],
 * [9,6,3]
 * ]
 * <p>
 * Example 2:
 * Given input matrix =
 * [
 * [ 5, 1, 9,11],
 * [ 2, 4, 8,10],
 * [13, 3, 6, 7],
 * [15,14,12,16]
 * ],
 * rotate the input matrix in-place such that it becomes:
 * [
 * [15,13, 2, 5],
 * [14, 3, 4, 1],
 * [12, 6, 8, 9],
 * [16, 7,10,11]
 * ]
 * @Author: lc
 * @Date: Created in 2017/12/16
 */
public class _48
{
    /**
     * 此题是让输入方阵顺时针旋转90°，做好旋转前和旋转后的映射关系：matrix[x][y] = matrix[n - 1 - y][x]。
     */
    public void rotate(int[][] matrix)
    {
        int n = matrix.length;
        // 以矩阵环为单位循环，每次循环都是只操作矩阵环的元素
        for (int i = 0; i < n / 2; i++)
        {
            // 每一个环分成 n - 2 * i - 1 组
            for (int k = 0; k < n - 2 * i - 1; k++)
            {
                int x = i;
                int y = i + k;
                int temp = matrix[x][y];
                // 每组都有四个元素需要旋转
                for (int j = 0; j < 3; j++)
                {
                    matrix[x][y] = matrix[n - 1 - y][x];
                    int t = x;
                    x = n - 1 - y;
                    y = t;
                }
                matrix[x][y] = temp;
            }
        }
    }

    public static void main(String[] args)
    {
        _48 obj = new _48();
        int[][] matrix = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        obj.rotate(matrix);
    }
}
