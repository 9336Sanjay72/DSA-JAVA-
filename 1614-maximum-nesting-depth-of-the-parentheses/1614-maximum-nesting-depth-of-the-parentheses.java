class Solution {
    public int maxDepth(String s) {
     int n=s.length();
     int result=0;
     int curr=0;
     for(int i=0;i<n;i++){
        if(s.charAt(i)=='(')curr++;
        else if(s.charAt(i)==')')curr--;
        result=Math.max(result,curr);
     }
     return result;   
    }
}