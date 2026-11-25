class Solution {
    static final long MOD = 1000000007L;

    long c;

    long getTime(long x, long a, long b) {
        long k = 0;

        if (x > a) {
            k = (x - a + c - 1) / c;
        }

        return k * (a + b) + x - k * c;
    }

    long sum(long first, long last) {
        if (first > last) return 0;

        long n = last - first + 1;
        return (first + last) * n / 2;
    }

    long prefixSum(long n, long a, long b) {
        if (n <= 0) return 0;

        if (n <= a) {
            return n * (n + 1) / 2;
        }

        long q = (n - a) / c;
        long rem = (n - a) % c;

        long ans = a * (a + 1) / 2;
        long last = a + q * c;

        ans += sum(a + 1, last);
        ans += b * c * q * (q + 1);

        ans += sum(last + 1, n);
        ans += 2 * b * (q + 1) * rem;

        return ans % MOD;
    }

    public int minTime(int a, int b, int d, int l, int r) {
        c = a - b;

        long normalTime = getTime(d, a, b);
        long limit = normalTime - 1;

        long L = d - r;
        long R = d - l;

        long low = L - 1;
        long high = R;

        while (low < high) {
            long mid = low + (high - low + 1) / 2;

            if (getTime(mid, a, b) <= limit) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }

        long ans = 0;

        if (low >= L) {
            ans = (prefixSum(low, a, b)
                  - prefixSum(L - 1, a, b) + MOD) % MOD;
        }

        long remaining = R - Math.max(low, L - 1);

        ans = (ans + (remaining % MOD) * (limit % MOD)) % MOD;
        ans = (ans + (r - l + 1L)) % MOD;

        return (int) ans;
    }
}