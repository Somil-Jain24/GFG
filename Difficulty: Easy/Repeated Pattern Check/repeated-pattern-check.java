class Solution {
    public boolean findPattern(String s) {
        int n = s.length();
        int i = 0;

        while (i < n) {
            int countX = 0;
            int countY = 0;

            // Count consecutive 'x's
            while (i < n && s.charAt(i) == 'x') {
                countX++;
                i++;
            }

            // A valid block must start with at least one 'x'
            if (countX == 0) {
                return false;
            }

            // Count consecutive 'y's immediately following the 'x's
            while (i < n && s.charAt(i) == 'y') {
                countY++;
                i++;
            }

            // The number of 'x's and 'y's in this segment must match
            if (countX != countY) {
                return false;
            }
        }

        return true;
    }
}