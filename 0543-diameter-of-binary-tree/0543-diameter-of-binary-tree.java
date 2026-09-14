class Solution {
    public int maxHeight=0;
    public int height (TreeNode root){
        if(root==null)return 0;
        return 1+Math.max(height(root.left),height(root.right));
    }
    public void solve(TreeNode root){
        if(root==null)return;
        int left=height(root.left);
        int right=height(root.right);
        solve(root.left);
        solve(root.right);
        maxHeight=Math.max(maxHeight,left+right);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        solve(root);
        return maxHeight;
    }
}