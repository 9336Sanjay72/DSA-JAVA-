class Solution {
    public int[] dailyTemperatures(int[] nums) {
        int n=nums.length;
        Stack<Integer>st=new Stack<>();
        int[]ans=new int[n];
        for(int i=n-1;i>=0;i--){          
            while(st.size()>0 && nums[i]>=nums[st.peek()]){           
                st.pop();
            }
           if(st.size()>0)ans[i]=st.peek()-i;
            st.push(i);
        }
        return ans;
        // is approach 
        // int n=nums.length;
        // Stack<Integer>st=new ArrayList<>();
        // for(int i=n-1;i>=0;i--){
        //     int count=0;
        //     while(st.size()>0 && nums[i]>=st.peek()){
        //         count++;
        //         st.pop();
        //     }
        //     nums[i]=count;
        //     st.push(nums[i]);
        // }
        // return nums;
    }
}