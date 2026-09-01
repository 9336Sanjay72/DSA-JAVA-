class Solution {
    public long mod=1000000007;
    public long solve(long n,long x){
        if(x==0)return 1;
        else if(x%2==0)return solve((n*n)%mod,x/2)%mod;
        else return (n*solve((n*n)%mod,(x-1)/2))%mod;
    }
    public int countGoodNumbers(long n) {
        // first calculate how many number are even bw 1-n
        // suppose n=4 it means 4 digit how many are even _ _ _ _ at how many indices we can fill with even number thats why we are counting even and odd as we know that we have to put even number on even indices and prime number on odd indices how many digits are even 2,4,6,8,0 and how many are prime 2,3,5,7 for n=4 on 0 indices we can put 2,4,6,8,0 and on 1 indices we can put 2,3,5,7 similarly for 2 and 3 indices see u are seeing a pattern like for even idices u have 5 choices and for odd indices 4 choices u are seeing it like 5*4*5*4 => we can write it as 5^2 *4^2
        long even=((n+1)/2);
        long odd=(n/2);
        return (int)(solve(5,even)*solve(4,odd)%mod);


    }
}