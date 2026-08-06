class Solution {
    public static int n,m;
    public static boolean visited[][];
    public static void dfs(int row,int col,char [][]board){
        if(row>=n||row<0 || col>=m ||col<0 || board[row][col]!='X' || visited[row][col])return ;
        visited[row][col]=true;
        dfs(row+1,col,board);
        dfs(row-1,col,board);
        dfs(row,col+1,board);
        dfs(row,col-1,board);

    }
    public int countBattleships(char[][] board) {
         n=board.length;
         m=board[0].length;
        int count=0;
        visited=new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]=='X' && !visited[i][j]){
                    dfs(i,j,board);
                    count++;
                }
            }
        }
        return count;
    }
}