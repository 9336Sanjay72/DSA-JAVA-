class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int[]result=new int[seq.length()];
        int depth=0;
        for(int i=0;i<seq.length();i++){
            char ch=seq.charAt(i);
            if(ch=='('){
                depth++;
                result[i]=(depth%2==0)? 0 :1;
            }
            else if(ch==')'){
                result[i]=(depth%2==0) ? 0:1;
                depth--;
            }
        }
        return result;
    }
}