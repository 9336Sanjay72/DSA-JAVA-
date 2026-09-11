class Solution {
    public List<List<Integer>> result=new ArrayList<>();
    public Queue<TreeNode> q=new LinkedList<>();
    public void solve(TreeNode root){
        q.add(root);
        boolean leftToRight=true;
        while(!q.isEmpty()){
            int size=q.size();
            int[]arr=new int[size];
            int start=0;
            int end=size-1;
            for(int i=0;i<size;i++){
                TreeNode node=q.poll();
                if(leftToRight){
                    arr[start]=node.val;
                    start++;
                }
                else{
                   arr[end]=node.val;
                    end--;
                }
                
                if(node.left!=null)q.add(node.left);
                if(node.right!=null)q.add(node.right);
                
            }
            // if(!leftToRight){
            //     Collections.reverse(list);
            // }
            List<Integer> list=new ArrayList<>();
            for(int num : arr){
                list.add(num);
            }
            leftToRight=!leftToRight;
            result.add(list);
            
        }
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root==null)return result;
        solve(root);
        return result;
    }
}