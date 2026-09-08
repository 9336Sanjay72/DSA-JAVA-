class Solution {
    public static boolean solve(char[][] board, String s,int row,int col,int idx){
        int n=board.length;
        int m=board[0].length;
        if(idx==s.length())return true;
        if(row<0 || row>=n ||col<0|| col>=m || s.charAt(idx)!=board[row][col]||board[row][col]=='$'|| idx>=s.length() )return false;
        char temp=board[row][col];
        board[row][col]='$';
        if(solve(board,s,row+1,col,idx+1))return true;
        if(solve(board,s,row,col+1,idx+1))return true;
        if(solve(board,s,row-1,col,idx+1))return true;
        if(solve(board,s,row,col-1,idx+1))return true;
        board[row][col]=temp;
        return false;
        
    }
    public boolean exist(char[][] board, String word) {
        int n=board.length;
        int m=board[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]==word.charAt(0)){
                    if(solve(board,word,i,j,0))return true;
                }
            }
        }
        return false;

    }
}