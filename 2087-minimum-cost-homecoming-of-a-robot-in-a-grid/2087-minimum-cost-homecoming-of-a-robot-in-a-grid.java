class Solution {
    public int minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {
        int startRow=startPos[0];
        int startCol=startPos[1];
        int endRow=homePos[0];
        int endCol=homePos[1];
        int sum=0;
        while(startRow!=endRow){
            if(startRow<endRow){
                startRow++;
                sum+=rowCosts[startRow];
            }
            else {
                startRow--;
                sum+=rowCosts[startRow];
            }
        }
        while(startCol!=endCol){
            if(startCol<endCol){
                startCol++;
                sum+=colCosts[startCol];
            }
            else {
                startCol--;
                sum+=colCosts[startCol];
            }
        }
        return sum;
    }
}