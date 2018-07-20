package jianzhioffer.topic33;

/**
 * <p>
 * 面试题33：二叉搜索树的后序遍历序列（P.179）
 * 题目：输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。
 * 假设输入的数组的任意两个数字都互不相同。
 * </p>
 *
 * @author Liu Cong
 * @since 2018-07-11
 */
public class SquenceOfBST
{
    public static boolean solution(int[] sequence)
    {
        if (sequence == null || sequence.length <= 0) return false;

        return verifySquenceOfBST(sequence, 0, sequence.length - 1);
    }

    private static boolean verifySquenceOfBST(int[] sequence, int start, int end)
    {
        int root = sequence[end];

        // 在二叉搜索树中左子树节点的值小于根节点的值
        int i = start;
        for (; i < end; i++)
        {
            if (sequence[i] > root)
                break;
        }

        // 在二叉搜索树种右子树节点的值大于根节点的值
        for (int j = i; j < end; j++)
        {
            if (sequence[j] < root)
                return false;
        }

        // 判断左子树是不是二叉搜索树
        boolean left = true;
        if (i > 0 && start < i - 1)
            left = verifySquenceOfBST(sequence, start, i - 1);

        // 判断右子树是不是二叉搜索树
        boolean right = true;
        if (i < end && i < end - 1)
            right = verifySquenceOfBST(sequence, i, end - 1);


        return left && right;
    }

    public static void main(String[] args)
    {
        System.out.println(solution(new int[]{5, 7, 6, 9, 11, 10, 8}));
        System.out.println(solution(new int[]{7, 4, 6, 5}));
    }
}
