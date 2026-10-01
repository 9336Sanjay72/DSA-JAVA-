class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        Map<Integer,Integer> map=new TreeMap<>();
        int n=nums.length;
        for(int num :nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        for(int key : map.keySet()){
            int freq=map.get(key);
            if(freq==0)continue;
            for(int i=0;i<k;i++){
                if(!map.containsKey(key+i) || map.get(key+i)<freq){
                    return false;
                }
                map.put(key+i,map.get(key+i)-freq);
            }
        }
        return true;
    }
}