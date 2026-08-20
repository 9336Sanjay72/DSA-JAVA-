class Solution {
    public boolean divideArray(int[] nums) {
        int n=nums.length;
        int pairs=n/2;
        Map<Integer,Integer>map=new HashMap<>();
        for(int num: nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        ;
        for(int num : map.keySet()){
            if(map.get(num)%2!=0)return false;
            
        }
        
        return true;
    }
}