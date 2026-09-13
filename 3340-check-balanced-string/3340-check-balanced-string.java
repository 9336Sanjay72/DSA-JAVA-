class Solution {
    public boolean isBalanced(String num) {
        int n=num.length();
        int even=0;
        int odd=0;
        int x=0;
        for(int i=0;i<n;i++){
            if(x==0){
                even+=num.charAt(i)-'0';
            }
            else {
                odd+=num.charAt(i)-'0';
            }
            x=1-x;           
        }
        if(even!=odd)return false;
        return true;
    }
}