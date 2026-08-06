class Solution {
    public int product(int n){
        int p=1;
        while(n>0){
            p=p*(n%10);
            n=n/10;
        }
        return p;
    }
    public int smallestNumber(int n, int t) {
        for(int i=n;i<=n*t;i++){
           int p= product(i);
           if(p%t==0)return i;
        }
        return -1;
    }
}