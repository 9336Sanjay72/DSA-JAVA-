class Solution {
    public int minimumRecolors(String blocks, int k) {
        int n=blocks.length();
        int ans=Integer.MAX_VALUE;
        // for(int i=0;i<n;i++){
        //     C
        //     int black=0;
        //     for(int j=i;j>=0;j--){
        //         char ch=blocks.charAt(j);
        //         if(ch=='W')white++;
        //         else black++;
        //         if((white+black)==k){
        //             ans=Math.min(ans,white);
        //         }
        //     }
        // }
        int white=0;
        
        int j=0;
        for(int i=0;i<n;i++){
            char ch=blocks.charAt(i);
            if(ch=='W')white++;
           
            while(i-j+1>k){
                char c=blocks.charAt(j);
                if(c=='W')white--;
                j++;
            }
            if((i-j+1)==k){
                ans=Math.min(ans,white);
            }
        }
        return ans;
    }
}