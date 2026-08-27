class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int n=nums.length;
        int result=0;
        int[]prefix=new int[n];
        prefix[0]=nums[0];//hum log prefix sum bhi nikalenge aur uska remender bhi usi mai store karenge 
        for(int i=1;i<n;i++){
            prefix[i]=prefix[i-1]+nums[i];
        }//humne kaise socha ki remainder nikalna kyu accoridng to ques usme likha hai sum divisible by k ilsiye sum ka remiander sstore kar liya 
        for(int i=0;i<n;i++){
            prefix[i]=prefix[i]%k;
            if(prefix[i] < 0)
                prefix[i] += k;;// agar remainder -2%5 kar raha huu toh java mai -2 hota hai lekin mathematically 3 hota hai isliye -2+5 =3
        }
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,1);//kyuki agar remainder zero hai uska matlab waha sum completely divisible by k hai
        for(int i=0;i<n;i++){
            if(map.containsKey(prefix[i])){
                result+=map.get(prefix[i]);
            }
               map.put(prefix[i],map.getOrDefault(prefix[i],0)+1);
            
        }
        return result;

    }
}