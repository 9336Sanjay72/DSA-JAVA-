class Solution {
    public boolean isValid(int row,int col,char[][]board,char ch){
        for(int i=0;i<9;i++){
            // if(board[row][i]==ch)return false;//isse kya ho rha hai jaise man suduko se 5 aaya row =0,col=0 par to yaha direct check kia row =0,col=0 jo ki hamesha present rahega islye hum usse nahi lenge 
            // if(board[i][col]==ch)return false;
             if(i!=col && board[row][i]==ch)return false;
             if(i!=row && board[i][col]==ch)return false;
        }
        int startRow=(row/3)*3;
        int startCol=(col/3)*3;
        for(int i=startRow;i<startRow+3;i++){
            for(int j=startCol;j<startCol+3;j++){
                if((i!=row ||j!=col) && board[i][j]==ch)return false;
            }
        }
        return true;
    }
    public boolean solve(char[][]board){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]!='.'){
                    if(!isValid(i,j,board,board[i][j]))return false;
                }
         } 
      }
    return true;
    }
    public boolean isValidSudoku(char[][] board) {
        return solve(board);
    }
}