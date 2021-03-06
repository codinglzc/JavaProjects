package leetcode.array;

/**
 * @Description: 661. Image Smoother
 * Given a 2D integer matrix M representing the gray scale of an note, you need to design a smoother to make the gray
 * scale of each cell becomes the average gray scale (rounding down) of all the 8 surrounding cells and itself. If a
 * cell has less than 8 surrounding cells, then use as many as you can.
 * <p>
 * Example 1:
 * Input:
 * [[1,1,1],
 * [1,0,1],
 * [1,1,1]]
 * Output:
 * [[0, 0, 0],
 * [0, 0, 0],
 * [0, 0, 0]]
 * Explanation:
 * For the point (0,0), (0,2), (2,0), (2,2): floor(3/4) = floor(0.75) = 0
 * For the point (0,1), (1,0), (1,2), (2,1): floor(5/6) = floor(0.83333333) = 0
 * For the point (1,1): floor(8/9) = floor(0.88888889) = 0
 * <p>
 * Note:
 * 1. The value in the given matrix is in the range of [0, 255].
 * 2. The length and width of the given matrix are in the range of [1, 150].
 * @Author: lc
 * @Date: Created in 2018/2/26
 */
public class _661
{
    public int[][] imageSmoother(int[][] M)
    {
        int rows = M.length;
        int cols = M[0].length;
        int[][] result = new int[rows][cols];
        int[] arr = {-1, 0, 1};
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < cols; j++)
            {
                int count = 0;
                int sum = 0;
                for (int m : arr)
                {
                    for (int n : arr)
                    {
                        if ((i + m) >= 0 && (i + m) < rows && (j + n) >= 0 && (j + n) < cols)
                        {
                            count++;
                            sum += M[i + m][j + n];
                        }
                    }
                }
                result[i][j] = sum / count;
            }
        }
        return result;
    }
}
