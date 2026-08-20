class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
       
            Integer[]nums=new Integer[names.length];// yaa par Integer isliye liya kyuki comparator sirf Integer par laagta int par nahi kyuki int primitive data type hai integer object hai
            for(int i=0;i<names.length;i++){
                nums[i]=i;
            }
            Arrays.sort(nums,(a,b)->heights[b]-heights[a]);
            String result[]=new String[names.length];
            for(int i=0;i<names.length;i++){
                result[i]=names[nums[i]];
            }
            return result;
    }
}