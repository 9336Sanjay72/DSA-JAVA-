class Solution {
    public String largestOddNumber(String num) {
        int n=num.length();
        // peeche se odd digit mil gaya wahi larget odd number hga

        for(int i=n-1;i>=0;i--){
            if((num.charAt(i)-'0')%2!=0){
                return num.substring(0,i+1);
            }
        }
        return "";
    }
}