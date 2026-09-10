class Solution {
    public int count=0; 
    public int countNodes(TreeNode root){
        if(root==null)return 0;
        return 1+countNodes(root.left)+countNodes(root.right);
    }   
    public int  solve(TreeNode root,int nodeCount){
        if(root==null)return  0;
        int leftSum=solve(root.left,nodeCount+ 1);
        int rightSum=solve(root.right,nodeCount+1);
        int totalSum=leftSum+rightSum+root.val;
        if(totalSum/countNodes(root)==root.val)count++;
        return totalSum;
        
    }
    public int averageOfSubtree(TreeNode root) {
        int x=solve(root,0);
        return count;
    }
}