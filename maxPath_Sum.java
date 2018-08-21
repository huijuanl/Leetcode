package LeetCode;
//找到整棵树中，值最大的一条路径
//对于一个节点而言，值最大的路径其实就等于，左边的节点的值最大路径+右边节点的值最大路径+自己的值
//（当然前提条件是这些值都大于0，小于0的应该被舍弃）。
//与常规path sum不同，这题的path sum可以不起始于root，也可以不终止于leaf
//采用bottom-up的递归方法
public class maxPath_Sum {
    int maxSUM = Integer.MIN_VALUE;

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //深度优先搜索
    public int maxPathSum(TreeNode root) {
        if (root == null)
            return 0;
        maxPathSumInSubTree(root);
        return maxSUM;
    }

    public int maxPathSumInSubTree(TreeNode root) {//返回值为:以root为根的子树上，以root节点开始到某个节点的最大路径
        if (root == null)
            return Integer.MIN_VALUE;
        int leftSum = maxPathSumInSubTree(root.left);
        int rightSum = maxPathSumInSubTree(root.right);
        int Sum = root.val + Math.max(0, leftSum) + Math.max(0, rightSum);
        maxSUM = Math.max(maxSUM, Sum);//可能路径的最大值是左子树路径+右子树路径+根（但是最大值并不是返回值）
        return Math.max(root.val + Math.max(0, leftSum), root.val + Math.max(0, rightSum));//返回的路径长度是根到左子树路径或根到右子树路径的最大值(只能返回其中一条)
    }
}
