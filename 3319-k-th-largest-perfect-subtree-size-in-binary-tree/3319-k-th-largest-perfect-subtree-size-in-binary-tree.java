class Node {
    int height;
    int size;
    boolean perfect;
    Node(int height,int size,boolean perfect){
        this.height=height;
        this.size=size;
        this.perfect=perfect;
    }
}
class Solution {
    public List<Integer> list=new ArrayList<>();
    public Node solve(TreeNode root){
        if(root == null){
            return new Node(-1, 0, true);
        }
        if(root.left==null && root.right==null){
            list.add(1);
            return new Node(0,1,true);
        }
        Node left=solve(root.left);
        Node right=solve(root.right);
        int height=1+Math.max(left.height ,right.height);
        int size=left.size+right.size+1;
        if(left.perfect && right.perfect && left.height==right.height ){
            list.add(size);
            return new Node(height,size,true);
        }
        return new Node(height,size,false);

    }
    public int kthLargestPerfectSubtree(TreeNode root, int k) {
        Node x=solve(root);
        Collections.sort(list);
        if(k>list.size())return -1;
        return list.get(list.size()-k);
    }
}