class Solution {
    public void dfs(int[][]image,int r,int c,int color,int orgColor){
         int n=image.length;
        int m=image[0].length;
        if(r<0||r>=n||c<0||c>=m||image[r][c]!=orgColor)return;//ya to graph se bahar jaa rha ho ya phir orginalcolor ke barabar nahi ho toh return kar do 
        image[r][c]=color;
        dfs(image,r+1,c,color,orgColor);
        dfs(image,r-1,c,color,orgColor);
        dfs(image,r,c+1,color,orgColor);
        dfs(image,r,c-1,color,orgColor);

    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n=image.length;
        int m=image[0].length;
        int orgColor=image[sr][sc];
        if(color==orgColor)return image;
        dfs(image,sr,sc,color,orgColor);
        return image;

    }
}