class Solution {
    public long countCommas(long n) {
        long count=1;
        long ans=0;
        for(long i=1000;i<=n;i*=1000){
            long upperBound=Math.min(n,i*1000-1);
            long lowerBound=i;
            ans+=(upperBound-lowerBound+1)*count;
            count++;
        }
        return ans;

    }
}