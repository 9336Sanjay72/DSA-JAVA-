class Solution {
    public int minSwaps(String s) {
        // key observation is that for every swap we balance two char thats formula become 
        // (mismatch+1)/2;
        // we do +1 because of odd number  suppose if mismatch value is 3 than we can not take it as 1.5 thats why we take its ceil value
        int misMatch=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='[') misMatch++;// it means now we need ] to make it valid 
            else {
                if(misMatch>0){
                    misMatch--;
                }
            }
        }
        return (misMatch+1)/2;
    }
}