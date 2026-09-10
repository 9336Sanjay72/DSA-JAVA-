class Solution {
    public int secondMin=Integer.MAX_VALUE;
    public int min=Integer.MAX_VALUE;
    boolean foundSec=false;
    public void solve(TreeNode root){
        if(root==null)return;
        if(min>root.val){
            secondMin=min;
            min=root.val;
        }
        else if(min<root.val &&( !foundSec ||secondMin>root.val)){
            secondMin=root.val;
            foundSec=true;
        }
        solve(root.left);
        solve(root.right);
    }
    public int findSecondMinimumValue(TreeNode root) {
        solve(root);
        if( !foundSec && secondMin==Integer.MAX_VALUE)return -1;
        return secondMin;
    }
}