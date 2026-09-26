
class Solution {
    public TreeNode solve(int[]inorder,int inLow,int inHigh,int[]postorder,int postLow,int postHigh){
        if(inLow>inHigh ||  postLow>postHigh)return null;
        TreeNode root=new TreeNode(postorder[postHigh]);
        int i=inLow;
        while(postorder[postHigh]!=inorder[i])i++;
        int leftSize=i-inLow;
        root.left=solve(inorder,inLow,i-1,postorder,postLow,postLow+leftSize-1);
        root.right=solve(inorder,i+1,inHigh,postorder,postLow+leftSize,postHigh-1);
        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return solve(inorder,0,inorder.length-1,postorder,0,postorder.length-1);
    }
}