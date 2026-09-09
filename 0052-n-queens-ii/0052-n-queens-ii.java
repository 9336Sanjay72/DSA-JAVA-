class Solution {
    public int count=0;
    public boolean isSafe(int row,int col,int n,char[][]board){
        for(int i=row-1;i>=0;i--){// ussse ek phele row mai jakar col check karna 
            if(board[i][col]=='Q')return false;
        }
        for(int i=row-1,j=col-1;i>=0 && j>=0;i--,j--){
            if(board[i][j]=='Q')return false;// left diagonal ke liye
        }
        for(int i=row-1,j=col+1;i>=0 && j<n;i--,j++){
            if(board[i][j]=='Q')return false;// right daigonal
        }
        return true;
    }
    public void solve(int row,int n,char[][]board){
        if(row==n){   
           count++;
            return;
        }
        for(int col=0;col<n;col++){
            if(isSafe(row,col,n,board)){
                board[row][col]='Q';
                solve(row+1,n,board);
                board[row][col]='.';
            }
        }
    }
     public int totalNQueens(int n) { 
        char [][]board=new char[n][n];
        for(char []ch: board){
            Arrays.fill(ch,'.');
        }
        solve(0,n,board);
        return count;
    }
}