package jianzhioffer.topic04;

/**
 * @description: 测试程序
 * @author: Liu Cong
 * @create: Created at 2018-06-11
 */
public class Main
{
    public static void main(String[] args)
    {
        int[][] nums = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};

        System.out.println(FindInPartiallySortedMatrix.solution(nums, 1));
        System.out.println(FindInPartiallySortedMatrix.solution(nums, 15));
        System.out.println(FindInPartiallySortedMatrix.solution(nums, 10));

        System.out.println(FindInPartiallySortedMatrix.solution(nums, 0));
        System.out.println(FindInPartiallySortedMatrix.solution(nums, 16));
        System.out.println(FindInPartiallySortedMatrix.solution(nums, 3));

        nums = null;
        System.out.println(FindInPartiallySortedMatrix.solution(nums, 9));
        nums = new int[][]{};
        System.out.println(FindInPartiallySortedMatrix.solution(nums, 9));
    }
}
