class Solution {

    public int longestValidParentheses(String s) {
        int max=0;
        int close=0,open=0;
        for(int i=0;i<s.length();i++){          
            if(s.charAt(i)=='('){
                open++;
            }
            else close++;
            if(close>open){
                close=0;
                open=0;
            }
            if(close==open) max=Math.max(close+open,max);
        }
        int closeR=0,openR=0;
        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i)==')')closeR++;
            else openR++;
            if(openR>closeR){
                openR=0;
                closeR=0;
            }
            if(openR==closeR){
                max=Math.max(max,closeR+openR);
            }
        }
        return max;
    }
}
// class Solution {
//     public int max=0;
//     public int dp[][]=new int[]
//     public boolean isValid(String s,int i,int j){
//         int count=0;
//         for(int k=i;k<=j;k++){
//             char ch=s.charAt(k);
//             if(ch=='(')count++;
//             else count--;
//             if(count<0)return false;
//         }
//         return count==0;
//     }
//     public void solve(String s,int i,int j){
//         if(i>=s.length())return ;
//         if(j>=s.length()){
//              solve(s,i+1,i+1);// j ko i ke sath reset kar dena hai 
//              return ;
//         }
//         if(isValid(s,i,j)){
//             max=Math.max(max,j-i+1);
//         }
//         solve(s,i,j+1);
//     }
//     public int longestValidParentheses(String s) {
//         if(s.length()==0 || s.length()==1)return 0;
//         solve(s,0,0);
//         return max;
//     }
// }
