// class Solution {
//     public static int n,m,count;
//     public static boolean[][] visited;
//     public static void dfs(int row,int col,int [][]grid){
//         if(row>=n || row<0 || col<0 ||col>=m || grid[row][col]!=1 || visited[row][col])return;
//         visited[row][col]=true;
//         count++;
//         dfs(row+1,col,grid);
//         dfs(row-1,col,grid);
//         dfs(row,col+1,grid);
//         dfs(row,col-1,grid);
        
//     }
//     public int maxAreaOfIsland(int[][] grid) {
//          n=grid.length;
//          m=grid[0].length;
//          visited=new boolean[n][m];
//          int max=0;
//          for(int i=0;i<n;i++){
//             for(int j=0;j<m;j++){
//                 if(grid[i][j]==1 && !visited[i][j]){
//                     count=0;
//                     dfs(i,j,grid);
//                     max=Math.max(max,count);
//                 }
//             }
//          }
//          return max;
//     }
// }

// another approach
class Solution {
    public static int n,m,count;
    public static boolean[][] visited;
    public static int dfs(int row,int col,int [][]grid){
        if(row>=n || row<0 || col<0 ||col>=m || grid[row][col]!=1 || visited[row][col])return 0;
        visited[row][col]=true;
       return 1+dfs(row+1,col,grid)+dfs(row-1,col,grid)+ dfs(row,col+1,grid)+ dfs(row,col-1,grid);
        
    }
    public int maxAreaOfIsland(int[][] grid) {
         n=grid.length;
         m=grid[0].length;
         visited=new boolean[n][m];
         int max=0;
         for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1 && !visited[i][j]){
                    max=Math.max(max, dfs(i,j,grid));
                }
            }
         }
         return max;
    }
}