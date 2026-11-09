class Solution {
    int getCount(String s, int k) {
        int[] groupCount = new int[26];
        boolean[] countedInCurrentBlock = new boolean[26];

        int n = s.length();
        if (n == 0) return 0;

        // We can just iterate and track blocks
        for (int i = 0; i < n; i++) {
            // If it's the start of a new block (i == 0 or s.charAt(i) != s.charAt(i-1))
            if (i == 0 || s.charAt(i) != s.charAt(i - 1)) {
                groupCount[s.charAt(i) - 'a']++;
            }
        }

        int ans = 0;
        for (int i = 0; i < 26; i++) {
            if (groupCount[i] == k) {
                ans++;
            }
        }

        return ans;
    }
}