class Solution {
    public int solve(TreeNode root){
        if(root==null)return 0;
        int left=1+solve(root.left);
        int right=1+solve(root.right);
        return Math.max(left,right);
    }
    public int maxDepth(TreeNode root) {
        return solve(root);
    }
}