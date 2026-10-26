class Solution {
    public long  dfs(int r,int c,int [][]grid,boolean[][]visited){
        int n=grid.length;
        int m=grid[0].length;
        if(r>=n || r<0 ||c>=m ||c<0 || visited[r][c] || grid[r][c]<=0)return 0;
        // if(grid[r][c]>0 && !visited[r][c])return true;
        visited[r][c]=true;
        long sum=grid[r][c];
        sum+=dfs(r-1,c,grid,visited);
        sum+=dfs(r+1,c,grid,visited);
        sum+=dfs(r,c+1,grid,visited);
        sum+=dfs(r,c-1,grid,visited);
        return sum;
    }
    public int countIslands(int[][] grid, int k) {
        int n=grid.length;
        int m=grid[0].length;
        int count=0;
        boolean[][]visited=new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]>0 && !visited[i][j]){
                    if(dfs(i,j,grid,visited)%k==0)count++;
                 }

            }
        }
        return count;
    }
}