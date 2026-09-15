class Solution {

    boolean[][] isPalindrome;
    int[] t;

    public int maxPalindromes(String s, int k) {

        int n = s.length();

        isPalindrome = new boolean[n + 1][n + 1];

        // Blueprint: build palindrome table
        for (int L = 1; L <= n; L++) {

            for (int i = 0; i + L <= n; i++) {

                int j = i + L - 1;

                if (i == j) {
                    isPalindrome[i][j] = true;
                }
                else if (i + 1 == j) {
                    isPalindrome[i][j] = (s.charAt(i) == s.charAt(j));
                }
                else {
                    isPalindrome[i][j] =
                        (s.charAt(i) == s.charAt(j))
                        && isPalindrome[i + 1][j - 1];
                }
            }
        }

        t = new int[n + 1];
        Arrays.fill(t, -1);

        // For length < k, we cannot take any palindrome
        for (int len = 0; len < k; len++) {
            t[len] = 0;
        }

        // Bottom-up DP
        for (int len = k; len <= n; len++) {

            int result = t[len - 1];

            int j = len - 1;

            for (int i = 0; j - i + 1 >= k; i++) {

                if (isPalindrome[i][j]) {
                    result = Math.max(result, 1 + t[i]);
                }
            }

            t[len] = result;
        }

        return t[n];
    }
}