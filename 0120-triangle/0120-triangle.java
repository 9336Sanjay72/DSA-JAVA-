class Solution {
    public int[][]dp;
    public int solve(List<List<Integer>> list,int r,int c){
        int n=list.size();
        int m=list.get(r).size();
        if(r==n-1 && c<m && c>=0)return list.get(r).get(c);
        if(r>=n || c>=m ||r<0 ||c<0)return Integer.MAX_VALUE;
        if(dp[r][c]!=Integer.MAX_VALUE)return dp[r][c];
        int first=list.get(r).get(c)+solve(list,r+1,c);
        int second=list.get(r).get(c)+solve(list,r+1,c+1);
        return dp[r][c]=Math.min(first,second);
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        dp=new int[201][201];
        for(int[]arr:dp)Arrays.fill(arr,Integer.MAX_VALUE);
        return solve(triangle,0,0);
    }
}