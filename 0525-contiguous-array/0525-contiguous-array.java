class Solution {
    public int findMaxLength(int[] nums) {
        int n=nums.length;
        Map<Integer,Integer>map=new HashMap<>();
       int max=0;
        for(int i=0;i<n;i++){
            if(nums[i]==0)nums[i]=-1;
        }
        
        int[]prefix=new int[n];
        prefix[0]=nums[0];
        for(int i=1;i<n;i++){
            prefix[i]=prefix[i-1]+nums[i];
        }
        map.put(0,-1);
        for(int i=0;i<n;i++ ){
            if(!map.containsKey(prefix[i])){
                map.put(prefix[i],i);
            }
        }
        for(int i=0;i<n;i++){
            if(map.containsKey(prefix[i])){
                max=Math.max(max,i-map.get(prefix[i]));
            }
        }
        return max;
        // int max=0;
        // int n=nums.length;
        // for(int i=0;i<n;i++){
        //     int one=0;
        //     int zero=0;
        //     for(int j=i;j<n;j++){
        //         if(nums[j]==0)zero++;
        //         else one++;
        //         if(zero==one)max=Math.max(max,j-i+1);
        //     }
        // }
        // return max;
    }
}