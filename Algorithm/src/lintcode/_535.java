package lintcode;

/**
 * @Description: 535. 打劫房屋 III
 * 在上次打劫完一条街道之后和一圈房屋之后，窃贼又发现了一个新的可以打劫的地方，但这次所有的房子组成的区域比较奇怪，聪明的窃贼考察地形之后，
 * 发现这次的地形是一颗二叉树。与前两次偷窃相似的是每个房子都存放着特定金额的钱。你面临的唯一约束条件是：相邻的房子装着相互联系的防盗系统，
 * 且当相邻的两个房子同一天被打劫时，该系统会自动报警。
 * <p>
 * 算一算，如果今晚去打劫，你最多可以得到多少钱，当然在不触动报警装置的情况下。
 * <p>
 * 样例：
 * ...3
 * ../ \
 * .2   3
 * ..\   \
 * ...3   1
 * 窃贼最多能偷窃的金钱数是 3 + 3 + 1 = 7.
 * <p>
 * .....3
 * ..../ \
 * ...4   5
 * ../ \   \
 * .1   3   1
 * 窃贼最多能偷窃的金钱数是 4 + 5 = 9.
 * @Author: lc
 * @Date: Created in 2018-03-21
 */
public class _535
{
    /**
     * @param root: The root of binary tree.
     * @return: The maximum amount of money you can rob tonight
     */
    public int houseRobber3(TreeNode root)
    {
        // write your code here
        int[] res = recur(root);
        return Math.max(res[0], res[1]);
    }

    private int[] recur(TreeNode node)
    {
        if (node == null) return new int[]{0, 0};

        int[] left = recur(node.left);
        int[] right = recur(node.right);

        int notRob = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        int rob = left[1] + right[1] + node.val;

        return new int[]{rob, notRob};
    }
}
