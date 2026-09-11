/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> result=new ArrayList<>();
    Queue<Node> q=new LinkedList<>();
    public void solve(Node root){
        q.add(root);
        while(!q.isEmpty()){
            int size=q.size();
            List<Integer> list=new ArrayList<>();
            for(int i=0;i<size;i++){
                Node node=q.poll();
                list.add(node.val);
                if(node.children.size()>0){
                    for(int j=0;j<node.children.size();j++){
                        q.add(node.children.get(j));
                    }
                }
            }
            result.add(list);
        }
    }
    public List<List<Integer>> levelOrder(Node root) {
        if(root==null)return result;
        solve(root);
        return result;
    }
}