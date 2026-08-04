class Solution {
    public boolean dfs(int[][]graph,int []color,int curr ){
        for(int num : graph[curr]){
           if(color[num]==-1){
                color[num]=1-color[curr];
                if(!dfs(graph,color,num))return false;
           }
           else if(color[num]==color[curr])return false;//agar khali nhai toh color same nahi hona chahiye

        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        // List<List<Integer>>adj=new ArrayList<>();
        
        // for(int i=0;i<n;i++){
        //     adj.add(new ArrayList<>());
        // }
        // for(int i=0;i<n;i++){
        //     for(int num : graph[i]){
        //         adj.get(i).add(num);
        //     }
        // }
        int []color=new int[n];
        Arrays.fill(color,-1);
        // //red =0 //yellow =1    isme kya hai ki abhi graph connected nahi hai agar disconnected graph ke liye bhi karna hai to uske liye alag se loop lagana padega
        //     color[0]=0;
        //     if(!dfs(adj,color,0)) return false;
        for(int i=0;i<n;i++){
 
            if(color[i]==-1){
                 color[i]=0;
                if(!dfs(graph,color,i))return false;
            }
        }
            return true; 

    }
}
//class Solution {
//     public boolean dfs(int start,List<List<Integer>> list,int[] color){   
//        for(int num : list.get(start)){
//         if(color[num]==-1){
//             color[num]=1-color[start];
//             if(!dfs(num,list,color))return false;
//         }
//         else if(color[num]==color[start])return false;
//        }
//        return true;
//        }
    
//     public boolean isBipartite(int[][] graph) {
//         int n=graph.length;
//         List<List<Integer>> list=new ArrayList<>();
//         for(int i=0;i<n;i++){
//             list.add(new ArrayList<>());
//         }
//         for(int i=0;i<n;i++){
//         for( int num: graph[i]){
//             list.get(i).add(num);
//         } 
//     }
//     int[] color=new int[n];
//     Arrays.fill(color,-1);
//     for(int i=0;i<n;i++){
//         if(color[i]==-1){
//             color[i]=0;
//         if(!dfs(i,list,color))return false;
//     }
//     }
//     return true;
//     }
// }