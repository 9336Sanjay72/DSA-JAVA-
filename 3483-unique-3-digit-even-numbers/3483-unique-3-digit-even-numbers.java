// class Solution {
//     public int count=0;
//     public void solve(int[]digits,int idx,StringBuilder sb){
//         if(sb.length()==3 ){
//             if(sb.charAt(0)=='0' || (sb.charAt(2)-'0')%2!=0)return;
//             else count++;
//             return;
//         }
//         if(idx>=digits.length)return;
//         sb.append(digits[idx]);
//         solve(digits,idx+1,sb);
//         sb.deleteCharAt(sb.length()-1);
//         solve(digits,idx+1,sb);
//     }
//     public int totalNumbers(int[] digits) {
//         solve(digits,0,new StringBuilder());
//         return count;
//     }
// }

class Solution {
    public int totalNumbers(int[] digits) {
       Set<Integer> set=new HashSet<>();
       for(int i=0;i<digits.length;i++){
        for(int j=0;j<digits.length;j++){
            for(int k=0;k<digits.length;k++){
                    if(i==j || j==k || i==k)continue;
                    if(digits[i]!=0 && digits[k]%2==0 ){
                        int num=digits[i]*100+digits[j]*10+digits[k];
                        set.add(num);
                    }
            }
        }
       }
       return set.size();
    }
}
