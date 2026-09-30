class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[]freq=new int[26];
        for(char ch : tasks){
            freq[ch-'A']++;
        }
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a);
        for(int num : freq){
           if(num>0) pq.add(num);
        }
        int time=0;
        while(!pq.isEmpty()){
            List<Integer> temp=new ArrayList<>();
            for(int i=1;i<=n+1;i++){
                if(!pq.isEmpty()){
                int top=pq.poll();
                top--;
                temp.add(top);
                }
            }
            for(int num : temp){
                if(num>0)pq.add(num);
            }
            
            if(pq.isEmpty()){
                time+=temp.size();
            }
            else if(!pq.isEmpty())time+=n+1;
        }
        return time;
    }
}