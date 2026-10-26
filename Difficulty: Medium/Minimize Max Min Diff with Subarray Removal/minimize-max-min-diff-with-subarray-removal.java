class Solution {
    public int minDiff(int k, int[] arr) {
        
        int n = arr.length;

        int[] prefixMin = new int[n];
        int[] prefixMax = new int[n];
        int[] suffixMin = new int[n];
        int[] suffixMax = new int[n];

        prefixMin[0] = arr[0];
        prefixMax[0] = arr[0];

        for (int i = 1; i < n; i++) {
            prefixMin[i] = Math.min(prefixMin[i - 1], arr[i]);
            prefixMax[i] = Math.max(prefixMax[i - 1], arr[i]);
        }

        suffixMin[n - 1] = arr[n - 1];
        suffixMax[n - 1] = arr[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            suffixMin[i] = Math.min(suffixMin[i + 1], arr[i]);
            suffixMax[i] = Math.max(suffixMax[i + 1], arr[i]);
        }

        int ans = Integer.MAX_VALUE;

        for (int i = 0; i <= n - k; i++) {
            int minVal = Integer.MAX_VALUE;
            int maxVal = Integer.MIN_VALUE;

            // Elements remaining on the left
            if (i > 0) {
                minVal = Math.min(minVal, prefixMin[i - 1]);
                maxVal = Math.max(maxVal, prefixMax[i - 1]);
            }

            // Elements remaining on the right
            if (i + k < n) {
                minVal = Math.min(minVal, suffixMin[i + k]);
                maxVal = Math.max(maxVal, suffixMax[i + k]);
            }

            ans = Math.min(ans, maxVal - minVal);
        }

        return ans;
    }
}
