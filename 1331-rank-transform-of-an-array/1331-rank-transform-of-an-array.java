// now we solving it with the help of priorityQueue which will give us sorted order and use hashMap which i use to store rank 
class Solution {
    public int[] arrayRankTransform(int[] arr) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        Map<Integer,Integer> map=new HashMap<>();
        int n=arr.length;
        int[]result=new int[n];
        int rank=1;
        for(int num : arr){
            pq.add(num);
        }
        while(!pq.isEmpty()){
                int top=pq.poll();
                if(!map.containsKey(top)){
                    map.put(top,rank);
                    rank++;
                }
            }      
        for(int i=0;i<n;i++){
            result[i]=map.get(arr[i]);
        }
        return result;

    }
}
// method 1 with arrays sort and hashmap

// class Solution {
//     public int[] arrayRankTransform(int[] arr) {
//         int n=arr.length;
//         int[]nums=new int[n];
//         for(int i=0;i<n;i++){
//             nums[i]=arr[i];
//         }
//         Arrays.sort(nums);
//         Map<Integer,Integer> map=new HashMap<>();
//         // for(int i=0;i<n;i++){
//         //     map.put(nums[i],map.getOrDefault(nums[i],0)+1);
//         // }
//         int rank=1;
//         for(int num : nums){
//             if(!map.containsKey(num)){
//                 map.put(num,rank);
//                 rank++;
//             }
//         }
//         for(int i=0;i<n;i++){
//             nums[i]=map.get(arr[i]);
//         }
//         return nums;
//     }
// }
// this method give tle because i took 0(n2)
// class Solution {
//     public int[] arrayRankTransform(int[] arr) {
//         PriorityQueue<Integer> pq=new PriorityQueue<>();
//         int n=arr.length;
//         int[]result=new int[n];
//         int rank=1;
//         for(int num : arr){
//             pq.add(num);
//         }
//         while(!pq.isEmpty()){
//             int num=pq.poll();
//             for(int i=0;i<n;i++){
//                 if(arr[i]==num){
//                     result[i]=rank;
//                 }
//             }
//             while(!pq.isEmpty() && pq.peek()==num)pq.poll();
//             rank++;
//         }
//         return result;
//     }
// }