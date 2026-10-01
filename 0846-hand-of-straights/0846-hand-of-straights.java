class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n=hand.length;
        if(n%groupSize!=0)return false;
        Map<Integer,Integer> map=new TreeMap<>();// kyuki mujhe sorted order chahiye 
        for(int num : hand){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        for(int key :map.keySet()){
            int freq=map.get(key);
            if(freq==0) continue;
            for(int i=0;i<groupSize;i++){
                if(!map.containsKey(key+i))return false; 

                map.put(key+i,map.get(key+i)-freq);
                
            }
        }
        return true;
    }
}