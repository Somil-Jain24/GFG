
class Solution {
    public int getMaxWeight(String str) {
        int n = str.length();
        int[] dp = new int[n + 2];

        for (int i = n - 1; i >= 0; i--) {
            dp[i] = 1 + dp[i + 1];

            if (i + 1 < n) {
                int pairWeight = (str.charAt(i) != str.charAt(i + 1)) ? 4 : 3;
                dp[i] = Math.max(dp[i], pairWeight + dp[i + 2]);
            }
        }

        return dp[0];
    }
}
