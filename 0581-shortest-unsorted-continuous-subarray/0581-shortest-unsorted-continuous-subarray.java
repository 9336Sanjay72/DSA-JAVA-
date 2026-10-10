class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n=nums.length;
        Stack<Integer> st=new Stack<>();
        int start=n;
        int end =-1;
        for(int i=0;i<n;i++){
            // boolean found=false;
            while(!st.isEmpty() && nums[st.peek()]>nums[i]){
                start=Math.min(start,st.pop());
                // found=true;
            }
            // if(found)break;
            st.push(i);
        }
        if(start==n)return 0;
        while(!st.isEmpty())st.pop();
        for(int i=n-1;i>=0;i--){
            // boolean found=false;
            while(!st.isEmpty() && nums[st.peek()]<nums[i]){
                end=Math.max(end,st.pop());
                // found=true;
            }
            // if(found)break;
            st.push(i);
        }
        if(end==-1)return 0;
        return end-start+1;
    }
}