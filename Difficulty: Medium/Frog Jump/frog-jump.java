class Solution {
    int frog(int n, int[] height, int[] dp){
        
        if(n == 0) return 0;
        if(dp[n] != -1) return dp[n];
        int left = frog((n-1), height, dp) +  Math.abs(height[n] - height[n-1]);
        int right = Integer.MAX_VALUE;
        if(n > 1) right = frog((n-2), height, dp) +  Math.abs(height[n] - height[n-2]);
    
        return dp[n] = Math.min(left, right);
    
    }
    
    int minCost(int[] height) {
        
        int n = height.length-1;
        
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        
        return frog(n, height, dp);
    }
}