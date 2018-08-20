package LeetCode;

import java.util.Stack;

//判断一个二叉树的镜像是否是它自己
//非递归先序  两个栈，判断先序和“根右左”遍历路径的值是否一模一样(序列化形式)
//递归 定义两个指针p,q，初始化均为根节点，判断这两个根节点的值是否一样，然后判断以p.left为根的子树和q.right为根的子树是否是对称的
//然后判断以p.right为根和q.left为根的子树是否是对称的
public class isSymmetricBinaryTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    //递归形式，判断两棵子树是否镜像
    public boolean isSymmetric0(TreeNode root) {
       return isSymmetricprocess(root,root);
    }
    public boolean isSymmetricprocess(TreeNode root1,TreeNode root2){
        if(root1==null&&root2==null)
            return true;
        if(root1==null)
            return false;
        if(root2==null)
            return false;
        if(root1.val!=root2.val)
            return false;
        return isSymmetricprocess(root1.left,root2.right)&&isSymmetricprocess(root1.right,root2.left);
    }
    //先序序列非递归实现1
    public boolean isSymmetric1(TreeNode root) {
        if (root == null)
            return true;
        Stack<TreeNode> stack1 = new Stack<>();//根右左
        Stack<TreeNode> stack2 = new Stack<>();//先序
        stack1.push(root);
        stack2.push(root);
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            TreeNode cur1 = stack1.pop();
            TreeNode cur2 = stack2.pop();
            if (cur1.val != cur2.val)
                return false;
            if (cur1.left == null && cur2.right != null)
                return false;
            if (cur1.left != null && cur2.right == null)
                return false;
            if (cur1.right == null && cur2.left != null)
                return false;
            if (cur1.right != null && cur2.left == null)
                return false;
            if (cur1.left != null) {
                stack1.push(cur1.left);
            }
            if (cur2.right != null) {
                stack2.push((cur2.right));
            }
            if (cur1.right != null) {
                stack1.push(cur1.right);
            }
            if (cur2.left != null) {
                stack2.push((cur2.left));
            }

        }
        return true;

    }

    //先序序列化的非递归版本2
    public boolean isSymmetric2(TreeNode root) {
        if (root == null)
            return true;
        Stack<TreeNode> stack1 = new Stack<>();//根右左
        Stack<TreeNode> stack2 = new Stack<>();//先序
        stack1.push(root);
        stack2.push(root);
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            TreeNode cur1 = stack1.pop();
            TreeNode cur2 = stack2.pop();
            if(cur1==null&&cur2==null)
                continue;
            if(cur1==null||cur2==null||cur1.val!=cur2.val)
                return false;
            stack1.push(cur1.left);
            stack2.push((cur2.right));
            stack1.push(cur1.right);
            stack2.push((cur2.left));
        }
        return true;

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(4);
//       root.right.right = new TreeNode(2);
        isSymmetricBinaryTree it = new isSymmetricBinaryTree();
        boolean res = it.isSymmetric0(root);
        System.out.print(res);
    }
}
