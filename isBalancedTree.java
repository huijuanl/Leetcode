package LeetCode;
//判断一棵树是不是二叉平衡树
//后序遍历在返回到该节点时已经判断了左右子树是否平衡，以及拿到了左右子树的高度
public class isBalancedTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public boolean isBalanced(TreeNode root) {
       if(root==null)
           return true;
       return isBalancedTree(root,new int[1]);
    }
    public boolean isBalancedTree(TreeNode root,int[] length){
        if(root==null)
            return true;
        int[]leftLength =new int[1];
        boolean leftIsBalanced = isBalancedTree(root.left,leftLength);
        int[]rightLength =new int[1];
        boolean rightIsBalanced = isBalancedTree(root.right,rightLength);
        if(!leftIsBalanced||!rightIsBalanced)
            return false;
        if(Math.abs(rightLength[0]-leftLength[0])>1)
            return false;
        length[0] = Math.max(leftLength[0],rightLength[0])+1;
        return true;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(4);
        root.right = new TreeNode(2);
        isBalancedTree it = new isBalancedTree();
        boolean res = it.isBalanced(root);
        System.out.print(res);
    }
}
