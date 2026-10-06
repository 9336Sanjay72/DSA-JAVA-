class Solution {
    public int minAddToMakeValid(String s) {
        int open = 0;
        int close = 0;
        int balance = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                open++;
            } else {
                close++;

                if (close > open) {
                    balance++;
                    open++;
                }
            }
        }

        balance += open - close;

        return balance;
    }
}