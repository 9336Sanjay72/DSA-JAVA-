class Solution {
    public static int n,m;
    public static void dfs(int row,int col,char [][]board){
        if(row>=n || row<0||col<0 ||col>=m || board[row][col]!='O')return ;
        board[row][col]='#';
        dfs(row+1,col,board);
        dfs(row-1,col,board);
        dfs(row,col+1,board);
        dfs(row,col-1,board);
    }
    public void solve(char[][] board) {
         n=board.length;
         m=board[0].length;
        // first collect 0 from  all the edge of board 
            // First row
        for (int i = 0; i < m; i++) {
            if (board[0][i] == 'O') {
                dfs(0, i, board);
            }
        }

        // Last row
        for (int i = 0; i < m; i++) {
            if (board[n - 1][i] == 'O') {
                dfs(n - 1, i, board);
            }
        }

        // First column
        for (int i = 0; i < n; i++) {
            if (board[i][0] == 'O') {
                dfs(i, 0, board);
            }
        }

        // Last column
        for (int i = 0; i < n; i++) {
            if (board[i][m - 1] == 'O') {
                dfs(i, m - 1, board);
            }
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]=='#'){
                    board[i][j]='O';
                }
                else board[i][j]='X';
            }
        }
       

    }
}