class Solution {
    // public String findString(String newString,List<List<String>> knowledge){
    //     for(int i=0;i<knowledge.size();i++){
    //         if(knowledge.get(i).get(0).equals(newString)){
    //             return knowledge.get(i).get(1);
    //         }
    //     }
    //     return "?";
    // }
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String,String> map=new HashMap<>();
        int  length=knowledge.size();
        for(int i=0;i<length;i++){
            if(map.containsKey(knowledge.get(i).get(0))){
                continue;
            }
            else {
               map.put(knowledge.get(i).get(0),knowledge.get(i).get(1));
            }
        }
        int n=s.length();
        StringBuilder result=new StringBuilder();
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='('){
                StringBuilder sb=new StringBuilder();
                int j=i+1;
                while(s.charAt(j)!=')'){
                    sb.append(s.charAt(j));
                    j++;
                }
                i=j;
                // StringBuilder newString=new StringBuilder();
                if(map.containsKey(sb.toString())){
                    result.append(map.get(sb.toString()));
                }
                else result.append("?");
            }
            if(s.charAt(i)==')')continue;
            result.append(s.charAt(i));
        }
        return result.toString();
    }
}