package jianzhioffer.topic03;

/**
 * @description: 主程序
 * @author: Liu Cong
 * @create: Created at 2018-06-11
 */
public class Main
{
    public static void main(String[] args)
    {
        int[] nums = {2, 3, 5, 4, 3, 2, 6, 7};

        System.out.println(DuplicationInArray.solution1(nums));
        System.out.println(DuplicationInArray.solution2(nums));
        System.out.println(DuplicationInArray.solution3(nums));

        System.out.println(Topic03Extends01.solution(nums));
    }
}
