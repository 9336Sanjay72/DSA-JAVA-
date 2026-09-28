class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n=nums.length;
        if(n==1)return nums;
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->{
            return freq.get(b)-freq.get(a);
        });
        for(int num :freq.keySet())pq.add(num);
        int[]result=new int[k];
        for(int i=0;i<k;i++){
            result[i]=pq.poll();
        }
        return result;
    }
}