class Solution {
    int[] dp;
    public int helper(int n){
        if(n==0)return 0;
        if(n==1)return 1;
        if(n==2)return 1;
        if(dp[n]!=-1){
            return dp[n];
        }
        dp[n]=helper(n-1)+helper(n-2)+helper(n-3);
        return dp[n];
    }
    public int tribonacci(int n) {
        dp=new int[n+1];
        Arrays.fill(dp,-1);
        return helper(n);
    }
}