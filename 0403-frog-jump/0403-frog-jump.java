class Solution {
    public Boolean[][]dp;
    public boolean solve(int[]stones,int i,int lastJump){
        int n=stones.length;
        if(i==n-1)return true;
        if(dp[i][lastJump]!=null)return false;
        // u have three choices lastjump-1,0,+1 
        for(int jump=lastJump-1;jump<=lastJump+1;jump++){
            if(jump<=0)continue;
            int target=stones[i]+jump;
            // now we have to find target 
            for(int j=i+1;j<n;j++){
                if(target==stones[j]){// if we find target then start from that value
                    if(solve(stones,j,jump)){
                        return dp[i][lastJump]= true;
                    }
                    break;
                }
               if(target<stones[j]) break;
            }
        }
        return dp[i][lastJump]=false;
    }
    public boolean canCross(int[] stones) {
        int n=stones.length;
        dp=new Boolean[n+1][n+1];
        if(stones[1]!=1)return false;
        return solve(stones,1,1);
    }
}