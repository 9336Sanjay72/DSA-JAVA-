class Solution {
    public int maxSum=Integer.MIN_VALUE;
    public int solve(TreeNode root){
        if(root==null)return 0;
        int leftSum=Math.max(0,solve(root.left));
        int rightSum=Math.max(0,solve(root.right));
        maxSum=Math.max(leftSum+rightSum+root.val,maxSum);
        return Math.max(leftSum,rightSum)+root.val;
    }
    public int maxPathSum(TreeNode root) {
        int x=solve(root);
        return maxSum;
    }
}