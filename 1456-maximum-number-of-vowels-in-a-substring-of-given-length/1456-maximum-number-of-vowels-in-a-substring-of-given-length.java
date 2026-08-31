class Solution {
    public int maxVowels(String s, int k) {
        int n=s.length();
        int j=0;
        int max=0;
        int count=0;
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u')count++;
            while(i-j+1>k){
                char c=s.charAt(j);
                if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u')count--;
                j++;
            }
            max=Math.max(count,max);
        }
        return max;
    }
}