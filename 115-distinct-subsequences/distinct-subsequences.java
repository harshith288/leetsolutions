class Solution {

    int[][] dp;

    public int numDistinct(String s, String t) {

        int n = s.length();
        int m = t.length();

        dp = new int[n][m];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(s, t, 0, 0);
    }

    private int solve(String s, String t, int i, int j) {
        if (j == t.length()) {
            return 1;
        }

 
        if (i == s.length()) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (s.charAt(i) == t.charAt(j)) {
            dp[i][j] = solve(s, t, i + 1, j + 1)
                      + solve(s, t, i + 1, j);

        } else {
            dp[i][j] = solve(s, t, i + 1, j);
        }

        return dp[i][j];
    }
}