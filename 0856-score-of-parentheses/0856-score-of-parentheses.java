class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> st=new Stack<>();
        st.push(0);
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='('){
                st.push(0);// iska mtlb abhi tak koi valid paranthis nahi bana
            }
            else{
                int x=st.pop();
                if(x==0){// iska mtlb ye char tha "(" ab match karana hai ise ) isse se ab jaise hi tumhe ) miljayega iska mtlb ek tumhe valid () string ho gaya hai isliye tum x=1 rakhoge
                     x=1;

                }
                else {// iska mtlb tumhara x=1/2 ho sakta hai // mtlb tumhara nested hoga suppose (()) kyuki iska score 2* nested hai 
                    x=x*2;

                }
                // at the end hum push kar denge 
                st.push(st.pop()+x);
            }
        }
        return st.pop();
    }
}