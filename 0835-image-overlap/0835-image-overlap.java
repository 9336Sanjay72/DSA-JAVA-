class Solution {
    public int checkOverlap(int rowoff,int coloff,int[][] img1, int[][] img2,int n){
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int r_o=i+rowoff;
                int c_o=j+coloff;
                if(r_o<0 || c_o<0 || r_o>=n ||c_o>=n)continue;
                if(img1[i][j]==1 && img2[r_o][c_o]==1 )count++;
            }
        }
        return count;
    }
    public int largestOverlap(int[][] img1, int[][] img2) {
        int maxCount=0;
        int n=img1.length;
        for(int rowOffset=-n+1 ;rowOffset<n;rowOffset++){
            for(int colOffset=-n+1;colOffset<n;colOffset++){
                int count=checkOverlap(rowOffset,colOffset,img1,img2,n);
                maxCount=Math.max(maxCount,count);
            }
        }
        return maxCount;
    }
}