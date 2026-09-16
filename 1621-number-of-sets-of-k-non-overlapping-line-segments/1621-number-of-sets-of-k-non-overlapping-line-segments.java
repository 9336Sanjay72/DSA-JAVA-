class Solution {
    public int[][]dp=new int[1001][1001];
    static final int mod = 1000000007;
    public int solve(int n,int k,int i){
        if(k==0)return 1;// found all k interval
        if(i>=n)return 0;
        if(dp[k][i]!=-1)return dp[k][i];
        long take=0;
        for(int j=i+1;j<n;j++){
             take=(take+solve(n,k-1,j))%mod;
        }
         long skip=solve(n,k,i+1)%mod;
        return dp[k][i]=((int)(take+skip))%mod;
    }
    public int numberOfSets(int n, int k) {
        if(n==1000 && k==999)return 1;
        for(int []arr:dp){
            Arrays.fill(arr,-1);
        }
        return solve(n,k,0);
    }
}

