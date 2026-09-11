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
    //    Set<Integer> set=new HashSet<>();
    //    for(int i=0;i<digits.length;i++){
    //     for(int j=0;j<digits.length;j++){
    //         for(int k=0;k<digits.length;k++){
    //                 if(i==j || j==k || i==k)continue;
    //                 if(digits[i]!=0 && digits[k]%2==0 ){
    //                     int num=digits[i]*100+digits[j]*10+digits[k];
    //                     set.add(num);
    //                 }
    //         }
    //     }
    //    }
    //    return set.size();

    Set<Integer> set=new HashSet<>();
    int[]freq=new int[10];// freq to store the frequency of all element
    for(int num : digits){
        freq[num]++;
    }
       for(int i=1;i<=9;i++){// first digit can be from 1 to 9
        // suppose we have duplicate element 2 we have used it for 1st digit so we reduce its frequency so that we cannot that particular element of particular index
        if(freq[i]==0)continue;
        else freq[i]--;
        for(int j=0;j<=9;j++){//second digit can be from 0 to 9 
            // similiar for this 
            if(freq[j]==0)continue;
            else freq[j]--;
            for(int k=0;k<=8;k+=2){// last digit can only be 0 ,2,4,6,8
                    if(freq[k]==0)continue;
                    else freq[k]--;
                    int num=i*100+j*10+k;
                    set.add(num);
                    freq[k]++;// suppose we have 3 times 2 digits suppose we have have used it for last digit and frequency became zero but we can also use 2 as 1st digit that's why we revive its frequency not only for this loop for 2nd and 1st digit too
                    
            }
            freq[j]++;
        }
        freq[i]++;
       }
       return set.size();
    }
}
