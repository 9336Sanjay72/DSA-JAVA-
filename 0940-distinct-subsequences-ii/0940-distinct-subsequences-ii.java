

class Solution {
    int M = 1_000_000_007;

    public int distinctSubseqII(String s) {
        int n = s.length();

        long[] dp = new long[n + 1];
        int[] prev = new int[n + 1];

        // lastSeen[i] stores the last position of character i
        int[] lastSeen = new int[26];

        // Find the previous occurrence of every character
        for (int i = 1; i <= n; i++) {
            int idx = s.charAt(i - 1) - 'a';

            prev[i] = lastSeen[idx];
            lastSeen[idx] = i;
        }

        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            long total = (2 * dp[i - 1]) % M;

            // Remove duplicate subsequences
            if (prev[i] != 0) {
                long duplicates = dp[prev[i] - 1];
                total = (total - duplicates + M) % M;
            }

            dp[i] = total;
        }

        // Remove the empty subsequence
        return (int) ((dp[n] - 1 + M) % M);
    }
}