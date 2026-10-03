// class Solution {
//     public int nthUglyNumber(int n) {
//         PriorityQueue<Long> pq=new PriorityQueue<>();
//         Set<Long> set=new HashSet<>();
//         int count =0;
//         pq.add(1L);
//         set.add(1L);
//         while(!pq.isEmpty()){
//             long num=pq.poll();
//             count++;
//             if(count==n)return (int) num;
//             if(!set.contains(num*2)){
//                 pq.add(num*2);
//                 set.add(num*2);
//             }
//             if(!set.contains(num*3)){
//                 pq.add(num*3);
//                 set.add(num*3);
//             }
//             if(!set.contains(num*5)){
//                 pq.add(num*5);
//                 set.add(num*5);
//             }
//         }
//         return 0;  
//     }
// }


// is code mai integer over flow ho jaa raha hai 
class Solution {
    public int nthUglyNumber(int n) {
        PriorityQueue<Long> pq=new PriorityQueue<>();
        int count =0;
        pq.add(1L);
        while(!pq.isEmpty()){
            long num=pq.poll();
            count++;
            if(count==n)return (int) num;
            if(!pq.contains(num*2)){
                pq.add(num*2);
            }
            if(!pq.contains(num*3)){
                pq.add(num*3);
            }
            if(!pq.contains(num*5)){
                pq.add(num*5);
            }
        }
        return 0;
    }
}