// class Solution {
//     public int[] frequencySort(int[] nums) {
//         int[]freq=new int[202];
//         for(int i=0;i<nums.length;i++){
//             freq[nums[i]+100]++;
//         }
//         Arrays.sort(nums,(a,b)->{
//             if(freq[100+a]==freq[100+b]) return b-a;
//             else return freq[100+a]-freq[100+b];
//         });

//         return nums;
//     }
// }\\

class Solution {
    public int[] frequencySort(int[] nums) {

        int[] freq = new int[202];

        // Count frequency
        for (int num : nums) {
            freq[num + 100]++;
        }

        // Convert int[] to Integer[]
        Integer[] arr = new Integer[nums.length];

        for (int i = 0; i < nums.length; i++) {
            arr[i] = nums[i];
        }

        // Sort numbers
        Arrays.sort(arr, (a, b) -> {
            if (freq[a + 100] == freq[b + 100]) {
                return b - a;       // larger number first
            }
            return freq[a + 100] - freq[b + 100]; // lower frequency first
        });

        // Convert back to int[]
        for (int i = 0; i < nums.length; i++) {
            nums[i] = arr[i];
        }

        return nums;
    }
}