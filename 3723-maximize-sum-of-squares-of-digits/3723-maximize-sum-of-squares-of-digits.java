class Solution {
    public String maxSumOfSquares(int num, int sum) {
        StringBuilder sb=new StringBuilder();
        int remaining=sum;
        for(int i=0;i<num;i++){
            int min=Math.min(9,remaining);
            sb.append(min);
            remaining-=min;          
        }
        if(remaining>0)return "";
        return sb.toString();
    }
}