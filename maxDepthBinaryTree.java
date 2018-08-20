package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

//求一棵二叉树的高度
//两种方法
//递归
//层次遍历
public class maxDepthBinaryTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    //层序遍历方法
    public int maxDepth2(TreeNode root) {
        if (root == null)
            return 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            depth++;
            for (int i = 0; i < queue.size(); i++) {//一次poll一层的数据
                TreeNode cur = queue.poll();
                if (cur.left != null)
                    queue.add(cur.left);
                if (cur.right != null)
                    queue.add(cur.right);
            }
        }
        return depth;
    }
}