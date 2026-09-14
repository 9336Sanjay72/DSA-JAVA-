class Solution {
    public int maxSum=0;
    public void solve(TreeNode root,int sum){
        if(root==null)return;
        if(root.left==null && root.right==null){
            maxSum=maxSum+sum+root.val;
            return;
        }
        sum=(sum+root.val)*10;
        solve(root.left,sum);
        solve(root.right,sum);
    }
    public int sumNumbers(TreeNode root) {
        solve(root,0);
        return maxSum;
    }
}