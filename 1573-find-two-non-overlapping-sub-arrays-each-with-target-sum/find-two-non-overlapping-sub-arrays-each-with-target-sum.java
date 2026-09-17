class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int INF = 1000000;
        int[] dp = new int[n + 1];
        java.util.Arrays.fill(dp, INF);

        java.util.HashMap<Integer, Integer> map = new java.util.HashMap<>();
        map.put(0, 0);

        int prefix = 0;
        int answer = INF;

        for (int i = 1; i <= n; i++) {
            prefix += arr[i - 1];
            dp[i] = dp[i - 1];

            if (map.containsKey(prefix - target)) {
                int start = map.get(prefix - target);
                int len = i - start;
                if (dp[start] != INF) {
                    answer = Math.min(answer, len + dp[start]);
                }

                dp[i] = Math.min(dp[i], len);
            }

            map.put(prefix, i);
        }

        return answer == INF ? -1 : answer;
    }
}