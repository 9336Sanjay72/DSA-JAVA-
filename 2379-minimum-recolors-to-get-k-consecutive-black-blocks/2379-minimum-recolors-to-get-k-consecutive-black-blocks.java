class Solution {
    public int minimumRecolors(String blocks, int k) {
        int n=blocks.length();
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int white=0;
            int black=0;
            for(int j=i;j>=0;j--){
                char ch=blocks.charAt(j);
                if(ch=='W')white++;
                else black++;
                if((white+black)==k){
                    ans=Math.min(ans,white);
                }
            }
        }
        return ans;
    }
}