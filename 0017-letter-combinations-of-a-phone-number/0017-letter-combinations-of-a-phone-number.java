class Solution {
    public List<String> result=new ArrayList<>();
    public void solve(StringBuilder sb ,String[]arr,String digits,int idx){
        if(idx==digits.length()){
            result.add(sb.toString());
            return;
        }
        int digit=digits.charAt(idx)-'0';
        String s=arr[digit];
        for(int i=0;i<s.length();i++){
            sb.append(s.charAt(i));
            solve(sb,arr,digits,idx+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    public List<String> letterCombinations(String digits) {
        String[]arr=new String [10];
        arr[2]="abc";
        arr[3]="def";
        arr[4]="ghi";
        arr[5]="jkl";
        arr[6]="mno";
        arr[7]="pqrs";
        arr[8]="tuv";
        arr[9]="wxyz";
        solve(new StringBuilder(),arr,digits,0);
        return result;
    }
}