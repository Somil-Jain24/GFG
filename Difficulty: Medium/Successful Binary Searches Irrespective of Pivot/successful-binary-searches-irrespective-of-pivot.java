class Solution {
    public int countAlwaysFound(int[] arr) {
        int n = arr.length;
        int[] suffixMin = new int[n + 1];
        suffixMin[n] = Integer.MAX_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            suffixMin[i] = Math.min(arr[i], suffixMin[i + 1]);
        }

        int count = 0;
        int prefixMax = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (arr[i] > prefixMax && arr[i] < suffixMin[i + 1]) {
                count++;
            }
            prefixMax = Math.max(prefixMax, arr[i]);
        }
        return count;
    }
}