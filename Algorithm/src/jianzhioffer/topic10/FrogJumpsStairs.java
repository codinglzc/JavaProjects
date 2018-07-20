package jianzhioffer.topic10;

/**
 * @description: 题目二：青蛙跳台阶问题。
 * 一只青蛙一次可以跳上 1 级台阶，也可以跳上 2 级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 * <p>
 * 分析：
 * 首先我们考虑最简单的情况。如果只有 1 个台阶，那显然只有一种跳法。如果有 2 级台阶，那就有两种跳法：一种是分两次跳，每次跳 1 级；另一种
 * 就是一次跳 2 级。接着我们再来讨论一般情况。我们把 n 级台阶时的跳法看成 n 的函数，记为 f(n)。当 n > 2 时，第一次跳的时候就有两种不同
 * 的选择：一是第一次只跳 1 级，此时跳法数目等于后面剩下的 n - 1 级台阶的跳法数目，即为 f(n-1)；二是第一次跳 2 级，此时跳法数目等于后面
 * 剩下的 n-2 级台阶的跳法数目， 即为 f(n-2)。因此，n 级台阶的不同跳法的总数 f(n) = f(n-1) + f(n-2)。分析到这里，我们不难看出这实际
 * 上就是斐波那契数列。
 * @author: Liu Cong
 * @create: Created at 2018-06-15
 */
public class FrogJumpsStairs
{
    public static long solution(int n)
    {
        long[] res = {1, 2};
        if (n <= 0) return 0;
        if (n <= 2) return res[n - 1];

        long result = 0;
        for (int i = 3; i <= n; i++)
        {
            result = res[0] + res[1];
            res[0] = res[1];
            res[1] = result;
        }
        return result;
    }

    public static void main(String[] args)
    {
        System.out.println(solution(3));
        System.out.println(solution(5));
        System.out.println(solution(10));
        System.out.println(solution(0));
        System.out.println(solution(1));
        System.out.println(solution(2));
        System.out.println(solution(40));
        System.out.println(solution(50));
        System.out.println(solution(100));
    }
}
