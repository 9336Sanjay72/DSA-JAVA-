class Solution {
    public boolean dfs(int r,int c,int[][]grid,boolean[][]visited){
        int n=grid.length;
        int m=grid[0].length;
        if(r>=n || r<0 || c>=m ||c<0 )return false ;
        if(visited[r][c] || grid[r][c]==1)return true;
        visited[r][c]=true;
        boolean down= dfs(r+1,c,grid,visited);
        boolean up=dfs(r-1,c,grid,visited);
        boolean right= dfs(r,c+1,grid,visited);
        boolean left= dfs(r,c-1,grid,visited);
        return left&& right && up&& down;

    }
    public int closedIsland(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int count=0;
        boolean[][]visited=new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==0 && !visited[i][j]){
                   if( dfs(i,j,grid,visited))count++;
                }
            }
        }
        return count;
    }
}