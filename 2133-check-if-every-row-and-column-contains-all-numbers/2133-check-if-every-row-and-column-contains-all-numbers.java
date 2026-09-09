class Solution {
    public boolean isValid(int row,int col,int[][]nums,int k){
        for(int i=0;i<nums.length;i++){
            if(i!=col && nums[row][i]==k)return false;
            if(i!=row && nums[i][col]==k)return false;
        }
        return true;
    }
    public boolean solve(int[][]nums){
       for(int i=0;i<nums.length;i++){
        for(int j=0;j<nums.length;j++){          
                if(!isValid(i,j,nums,nums[i][j]))return false; 
        }
       }
       return true;
    }
    public boolean checkValid(int[][] matrix) {
        int n=matrix.length;
        return solve(matrix);
    }
}