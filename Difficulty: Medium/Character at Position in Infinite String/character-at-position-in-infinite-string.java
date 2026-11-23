class Solution {
    public char posInfinite(String s, int pos) {

        long len = s.length();
        long k = pos;

        int level = 1;

        // Find the expansion level
        while (len < k) {
            len = 2 * len + level;
            level++;
        }

        // Reverse the expansion
        level--;

        while (level >= 1) {

            long prevLen = (len - level) / 2;

            if (k > prevLen + level) {
                // Position is in reversed string
                k = len - k + 1;
            }
            else if (k > prevLen) {
                // Position is in '$' section
                return '$';
            }

            len = prevLen;
            level--;
        }

        return s.charAt((int) k - 1);
    }
}