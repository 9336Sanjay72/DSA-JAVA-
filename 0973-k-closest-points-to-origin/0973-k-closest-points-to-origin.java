class Dis{
    int[]nums=new int[2];
    double distance;
    Dis(double distance,int[]nums){
        this.distance=distance;
        this.nums=nums;
    }

}
class Solution {
    public double findDistance(int[]nums){
        return Math.sqrt(Math.pow(nums[0],2)+Math.pow(nums[1],2));
    }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Dis> pq=new PriorityQueue<>((a,b)-> Double.compare(b.distance,a.distance));
        for(int []nums :points){
            pq.add(new Dis(findDistance(nums),nums));
            if(pq.size()>k)pq.poll();
        }
        int[][]result=new int[k][2];
        for(int i=0;i<k;i++){
            result[i]=pq.poll().nums;
        }
        return result;

    }
}