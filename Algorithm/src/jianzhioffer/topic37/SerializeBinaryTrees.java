package jianzhioffer.topic37;

/**
 * <p>
 * 面试题37：序列化二叉树（P.194）
 * 题目：请实现两个函数，分别用来序列化和反序列化二叉树。
 * </p>
 *
 * @author Liu Cong
 * @since 2018-07-12
 */
public class SerializeBinaryTrees
{
    private class BinaryTreeNode
    {
        public int value;
        public BinaryTreeNode left;
        public BinaryTreeNode right;

        public BinaryTreeNode(int value)
        {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    /**
     * 序列化
     */
    public String serialize(BinaryTreeNode root)
    {
        if (root == null) return "$";

        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    private void serialize(BinaryTreeNode node, StringBuilder sb)
    {
        if (node == null)
        {
            sb.append("$");
            return;
        }

        sb.append(node.value);

        serialize(node.left, sb.append(","));

        serialize(node.right, sb.append(","));
    }

    /**
     * 反序列化
     */
    private int index;

    public BinaryTreeNode deserialize(String str)
    {
        if (str == null) return null;

        String[] nums = str.split(",");
        index = 0;
        return deserialize(nums);
    }

    private BinaryTreeNode deserialize(String[] nums)
    {
        if (index >= nums.length) return null;

        if (nums[index].equals("$"))
        {
            index++;
            return null;
        }

        BinaryTreeNode root = new BinaryTreeNode(Integer.valueOf(nums[index]));

        root.left = deserialize(nums);

        root.right = deserialize(nums);

        return root;
    }
}
