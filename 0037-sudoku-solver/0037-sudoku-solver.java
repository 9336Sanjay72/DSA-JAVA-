class Solution {
    public boolean isValid(int row,int col,char ch,char[][]board){
        // check for col first nad row 
        for(int i=0;i<9;i++){
            if(board[row][i]==ch)return false;// check all the column of ith row 
            if(board[i][col]==ch)return false;
        }
        // check for small grid 3*3 gird
        int startRow=(row/3)*3;
        int startCol=(col/3)*3;
        for(int i=startRow;i<startRow+3;i++){
            for(int j=startCol;j<startCol+3;j++){
                if(board[i][j]==ch)return false;
            }
        }
        return true;
    }
    public boolean solve(char[][]board){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.'){
                    for(char ch='1' ;ch<='9';ch++){
                        if(isValid(i,j,ch,board)){
                            board[i][j]=ch;
                            if(solve(board))return true;
                            else board[i][j]='.';
                    }
                  }
                  return false;
                }
                
                
            }
            
        }
        return true;
    }
    public void solveSudoku(char[][] board) {
        solve(board);
        
    }
}