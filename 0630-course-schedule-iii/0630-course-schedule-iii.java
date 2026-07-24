class Solution {
    public int scheduleCourse(int[][] courses) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        Arrays.sort(courses,(a,b)->a[1]-b[1]);
        int total=0;
        for(int arr[] : courses){
            int last=arr[1];
            int duration=arr[0];
            total+=duration;
            pq.add(duration);
            if(total>last){
                int n=pq.poll();
                total-=n;
            }

        }
        return pq.size();
    }
}