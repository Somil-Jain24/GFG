class Solution {
    public static int findXOR(int l, int r) {
        return xorUpto(r) ^ xorUpto(l - 1);
    }

    private static int xorUpto(int n) {
        int rem = n % 4;
        if (rem == 0) return n;
        if (rem == 1) return 1;
        if (rem == 2) return n + 1;
        return 0; // rem == 3
    }
}
