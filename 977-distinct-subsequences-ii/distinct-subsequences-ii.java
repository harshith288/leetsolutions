class Solution {
    public int distinctSubseqII(String s) {
        final long MOD = 1_000_000_007;
        
        int n = s.length();
        long[] dp = new long[n + 1];
        long[] last = new long[26];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            char c = s.charAt(i - 1);
            dp[i] = (2 * dp[i - 1]) % MOD;
            dp[i] = (dp[i] - last[c - 'a'] + MOD) % MOD;
            last[c - 'a'] = dp[i - 1];
        }
        return (int) ((dp[n] - 1 + MOD) % MOD);
    }
}