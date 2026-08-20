class Solution {
    public int[] resultArray(int[] nums) {
        int n=nums.length;
         List<Integer> list1=new ArrayList<>();
         List<Integer>list2=new ArrayList<>();
         list1.add(nums[0]);
         list2.add(nums[1]);
         int i=2;
         int j=1,k=1;
         while(i<n){
            if(list1.get(j-1)>list2.get(k-1)){
                list1.add(nums[i]);
                    i++;
                    j++;
                }
            else{
                list2.add(nums[i]);
                i++;
                k++;
            }
         }
         i=0;
         while(i<list1.size()){
            nums[i]=list1.get(i);
            i++;
         }
         j=0;
         while(j<list2.size()){
            nums[i+j]=list2.get(j);
            j++;
            
         }
         return nums;
    }
}