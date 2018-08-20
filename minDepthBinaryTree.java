package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

//求二叉树的最小深度
//(1)递归方法
//求二叉树的最小深度和二叉树的最大深度的求法类似
//但是有一点特别需要注意
//求最小深度的时候，不能直接用return Math.min(LeftMinDepth,RightMinDepth)+1;
//可能存在左子树为空或右子树为空，若左子树为空，最小深度应该是右子树最小深度+1,
//若右子树为空，最小深度应该是左子树最小深度+1
//(2)层序遍历
//一次性输出每一层
//如果pop时，发现某一层中的某个节点既没有左节点也没有右节点，那么跳出遍历，返回当前的深度,即为最小深度
public class minDepthBinaryTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    //递归实现
    public int minDepth1(TreeNode root) {
       if(root==null)
           return 0;
       int LeftMinDepth = minDepth1(root.left);
       int RightMinDepth = minDepth1(root.right);
       if(LeftMinDepth==0)  //特别注意！！！
           return RightMinDepth+1;
       if(RightMinDepth == 0)//特别注意！！！
           return LeftMinDepth+1;
       return Math.min(LeftMinDepth,RightMinDepth)+1;
    }
    //层序遍历
    //一次性输出每一层
    //如果pop时，发现某一层中的某个节点既没有左节点也没有右节点，那么跳出遍历，返回当前的深度,即为最小深度
    public int minDepth2(TreeNode root) {
        if(root==null)
            return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            depth++;
            for (int i = 0;i<size;i++){
                TreeNode cur = queue.poll();
                if(cur.left==null&&cur.right==null)
                    return depth;
                if(cur.left !=null)
                    queue.add(cur.left);
                if(cur.right!=null)
                    queue.add(cur.right);
            }
        }
        return depth;
    }
}
