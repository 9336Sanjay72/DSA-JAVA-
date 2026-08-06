class Solution {
    public  boolean[][]visited;
    public int n,m;
    public void dfs(int i,int j,char [][]grid){
        if(i>=n || i<0 ||j>=m ||j<0 || visited[i][j]||grid[i][j]!='1'){return ;}
        visited[i][j]=true;
        dfs(i+1,j,grid);
        dfs(i,j+1,grid);
        dfs(i-1,j,grid);
        dfs(i,j-1,grid);

    }
    public int numIslands(char[][] grid) {
         n=grid.length;
         m=grid[0].length;
       visited=new boolean[n][m];
       int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1' && !visited[i][j]){
                    dfs(i,j,grid);
                    count++;
                }
            }
        }
        return count;
    }
}