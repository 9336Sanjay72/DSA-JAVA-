class Solution {
    public int reverseDegree(String s) {
        int sum=0;
        int idx=1;
        for(char ch : s.toCharArray()){
            int x=ch-'a';
            sum+=((26-x)*idx);
            idx++;
        }
        return sum;
    }
}