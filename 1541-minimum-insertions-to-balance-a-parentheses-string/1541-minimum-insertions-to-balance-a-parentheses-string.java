class Solution {
    public int minInsertions(String s) {
        int n=s.length();
        int ans=0;
        int open=0;
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='(')open++;// count of open bracket
            else {// for )
                if(i+1<n && s.charAt(i+1)==')'){
                    i+=1;// iska mtlb tumhare do '))'hai 
                }
                else {
                    ans++;// iska mtlb jab tumhe ')' ek hi mila mtlb tumhe chahiye tha har 1 open par 2 close
                }

                if(open>0){
                    open--;// agar open jayda hai 0 se upar dono step se uske dono case se solve kar diya ek step jab ek hi close jo handle kia else se agar 2 close hai toh handle kia use if se kyu har ekk open par 2 close ()) 
                }
                else{
                    ans++;// jab open tumhar 0 se kam ho us case mai tumhe open toh lagana hi padega 
                }

            }
        }
        return ans+open*2;
    }
}