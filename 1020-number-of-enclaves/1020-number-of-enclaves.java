class Solution {
    public static boolean [][]visited;
    public static int dfs(int row ,int col,int[][]grid){
        int n=grid.length;
        int m=grid[0].length;
        if(row>=n || col>=m|| row<0 ||col<0 || grid[row][col]!=1 || visited[row][col])return 0;
        visited[row][col]=true;
        return 1+dfs(row+1,col,grid)+dfs(row-1,col,grid)+dfs(row,col+1,grid)+dfs(row,col-1,grid);

    }
    public int numEnclaves(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int totalLand=0;
        int boundryLand=0;
        visited=new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1)totalLand++;
            }
        }
        // sabse connected island ke 1's nikalna hai jo edges se connected hai 
        //first  row ke liye 
        for(int i=0;i<n;i++){
            if(grid[i][0]==1){
                boundryLand+=dfs(i,0,grid);
            }
        }
        // last row
        for(int i=0;i<n;i++){
            if(grid[i][m-1]==1){
               boundryLand+= dfs(i,m-1,grid);
            }
        }
        // first column
        for(int i=0;i<m;i++){
            if(grid[0][i]==1){
               boundryLand+= dfs(0,i,grid);
            }
        }  
        // last column
        for(int i=0;i<m;i++){
            if(grid[n-1][i]==1){
               boundryLand+= dfs(n-1,i,grid);
            }
        }
        return totalLand-boundryLand;
    }
}