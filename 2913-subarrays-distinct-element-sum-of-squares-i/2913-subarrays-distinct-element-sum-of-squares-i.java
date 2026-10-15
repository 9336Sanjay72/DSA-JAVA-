class Solution {
    public int sumCounts(List<Integer> nums) {
        int sum=0;
        int n=nums.size();
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                Set<Integer> set=new HashSet<>();
                for(int k=i;k<=j;k++){
                    set.add(nums.get(k));
                }
                sum+=set.size()*set.size();
            }
            
        }
        return sum;
    }
}