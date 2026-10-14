class Solution {
    public String findRollOut(String s, int[] roll) {
        int n = s.length();
        int[] diff = new int[n + 1];

        for (int num : roll) {
            diff[0]++;
            diff[num]--;
        }

        StringBuilder sb = new StringBuilder(s);
        int count = 0;

        for (int i = 0; i < n; i++) {
            count += diff[i];
            int shift = count % 26;
            char ch = s.charAt(i);
            sb.setCharAt(i, (char) ('a' + (ch - 'a' + shift) % 26));
        }

        return sb.toString();
    }
}