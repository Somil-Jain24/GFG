class Solution {
    public int maxPackages(int[] arr, int totalTime) {
        // code here
        // Handle null or empty array
                if (arr == null || arr.length == 0) {
                    return 0;
                }

                // Handle non-positive time
                if (totalTime <= 0) {
                    return 0;
                }

                int n = arr.length;

                // Cannot visit more locations than exist
                int k = Math.min(totalTime, n);

                long windowSum = 0;

                // Calculate sum of the first window
                for (int i = 0; i < k; i++) {
                    windowSum += arr[i];
                }

                long maxPackages = windowSum;

                // Slide the window
                for (int i = k; i < n; i++) {
                    windowSum += (long) arr[i] - arr[i - k];

                    if (windowSum > maxPackages) {
                        maxPackages = windowSum;
                    }
                }

                return (int) maxPackages;
    }
}