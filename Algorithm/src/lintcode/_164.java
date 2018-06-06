package lintcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 164. 不同的二叉查找树 II
 * 给出n，生成所有由1...n为节点组成的不同的二叉查找树
 * <p>
 * 样例：
 * 给出n = 3，生成所有5种不同形态的二叉查找树：
 * 1         3     3       2    1
 * .\       /     /       / \    \
 * ..3     2     1       1   3    2
 * ./     /       \                \
 * 2     1         2                3
 * @Author: lc
 * @Date: Created in 2018/3/20
 */
public class _164
{
    /**
     * @paramn n: An integer
     * @return: A list of root
     */
    public List<TreeNode> generateTrees(int n)
    {
        // write your code here
        if (n < 0) return null;
        return recur(1, n);
    }

    public List<TreeNode> recur(int start, int end)
    {
        List<TreeNode> res = new ArrayList<>();
        if (start > end)
        {
            res.add(null);
            return res;
        }

        for (int i = start; i <= end; i++)
        {
            List<TreeNode> lefts = recur(start, i - 1);
            List<TreeNode> rights = recur(i + 1, end);
            for (int j = 0; j < lefts.size(); j++)
            {
                for (int k = 0; k < rights.size(); k++)
                {
                    TreeNode root = new TreeNode(i);
                    root.left = lefts.get(j);
                    root.right = rights.get(k);
                    res.add(root);
                }
            }
        }
        return res;
    }
}
