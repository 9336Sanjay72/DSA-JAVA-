// class Node{
//     TreeNode root;
//     int idx;
//     Node(TreeNode root,int idx){
//         this.root=root;
//         this.idx=idx;
//     }
// }
// class Solution {
//     public int low=0,high=0;
//     public void solve(TreeNode root,int pos){
//         if(root==null)return;
//         low=Math.min(pos,low);// ye sabse left point nikal kar dega left ka
//         high=Math.max(pos,high);// ye  sabse right point hai
//         solve(root.left,pos-1);// left mai jaa raha huu toh negative 
//         solve(root.right,pos+1);// right mai jaa raha huu toh positive
//     }

//     public List<List<Integer>> verticalTraversal(TreeNode root) {
//         List<List<Integer>> result=new ArrayList<>();
//         if(root==null)return result;
//         solve(root,0);// isse hum nikal rahe hai ki ,left mai kitne index tak jaa raha hai aur right mai bhi kitne index tak jaa raha hai
//         List<Integer>  negative[]= new List[Math.abs(low)];
//         List<Integer>  positive[]= new List[high+1];
//         for(int i=0;i<negative.length;i++){
//             negative[i]=new ArrayList<>();
//         }
//         for(int i=0;i<positive.length;i++){
//             positive[i]=new ArrayList<>();
//         }
//         Queue<Node>q=new LinkedList<>();
//         q.add(new Node (root,0));
//         while(!q.isEmpty()){
//             int size=q.size();
//             for(int i=0;i<size;i++){
//                 Node node=q.poll();
//                 if(node.idx>=0){
//                     positive[node.idx].add(node.root.val);
//                 }
//                 else if(node.idx<0){
//                     negative[negative.length + node.idx].add(node.root.val);
//                 }

//                 if(node.root.left!=null){
//                     q.add(new Node(node.root.left,node.idx-1));
//                 }
//                 if(node.root.right!=null){
//                     q.add(new Node(node.root.right,node.idx+1));
//                 }
//             }
//         }
        
//         // for(int i=0;i<high+Matn.abs(low)+1;i++){
//         //     result.add(new ArrayList<>());
//         // }
//         for(List<Integer> list: negative){
//             List<Integer> temp=new ArrayList<>();
//             for(int i=0;i<list.size();i++){
//                 temp.add(list.get(i));
//             }
//             Collections.sort(temp.subList(1,temp.size()));
//             result.add(temp);
//         }
//         for(List<Integer> list: positive){
//             List<Integer> temp=new ArrayList<>();
//             for(int i=0;i<list.size();i++){
//                 temp.add(list.get(i));
//             }
//             Collections.sort(temp.subList(1,temp.size()));
//             result.add(temp);
//         }
//         return result;

//     }
// }


// class Node {
//     TreeNode root;
//     int row;
//     int col;

//     Node(TreeNode root, int row, int col) {
//         this.root = root;
//         this.row = row;
//         this.col = col;
//     }
// }

// class Solution {

//     public List<List<Integer>> verticalTraversal(TreeNode root) {

//         List<Node> list = new ArrayList<>();

//         solve(root, 0, 0, list);

//         // Sort by column, then row, then value
//         Collections.sort(list, (a, b) -> {

//             if (a.col != b.col)
//                 return a.col - b.col;

//             if (a.row != b.row)
//                 return a.row - b.row;

//             return a.root.val - b.root.val;
//         });

//         List<List<Integer>> ans = new ArrayList<>();
//         List<Integer> current = new ArrayList<>();

//         int prevCol = list.get(0).col;

//         for (Node node : list) {

//             if (node.col != prevCol) {
//                 ans.add(current);
//                 current = new ArrayList<>();
//                 prevCol = node.col;
//             }

//             current.add(node.root.val);
//         }

//         ans.add(current);

//         return ans;
//     }

//     public void solve(TreeNode root, int row, int col, List<Node> list) {
//         if (root == null)
//             return;
//         list.add(new Node(root, row, col));

//         solve(root.left, row + 1, col - 1, list);
//         solve(root.right, row + 1, col + 1, list);
//     }
// }

class Node{
    int val, row,col;
    Node(int val,int row,int col){
        this.val=val;
        this.row=row;
        this.col=col;
    }
}
class Solution {
    public List<Node> list=new ArrayList<>();
    public List<List<Integer>> result=new ArrayList<>();
    public void solve(TreeNode root,int row,int col){
        if(root==null)return;
        list.add(new Node(root.val,row,col));
        solve(root.left,row+1,col-1);
        solve(root.right,row+1,col+1);
    }
    public void sort(){
        Collections.sort(list,(a,b)->{
            if(a.col!=b.col)return a.col-b.col;
            if(a.row!=b.row)return a.row-b.row;
            return a.val-b.val;
        });
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        if(root==null)return result;
        solve(root,0,0);
        sort();
        List<Integer> temp=new ArrayList<>();// temp list to build result array like if having col -1,-1 -1 then we put these in single list thats why we are using it 
        int prevCol=list.get(0).col;// dusri nayi banani ke kaam mai aayega

        for(Node node : list){
            if(node.col!=prevCol){// col:   -1  -1   0   0   1   1 suppose these are columns first prevCol is on -1 and when node col became 0 it means we have to build new temp list to store in result arraylist
                result.add(temp);// purani list add kar deni hai fir fresh new arrayList banayi hai 
                temp=new ArrayList<>();
                prevCol=node.col;

            }
            temp.add(node.val);// when prevcol=current col  -1  -1 
        }
        result.add(temp);// akhiri list add karne ke liye
        return result;
    }
}
