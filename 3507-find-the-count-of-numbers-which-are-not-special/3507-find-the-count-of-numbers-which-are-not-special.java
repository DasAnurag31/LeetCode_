class Solution {
    public int nonSpecialCount(int l, int r) {
        int maxRoot = (int) Math.sqrt(r);
        boolean[] primes = new boolean[maxRoot + 1];
        Arrays.fill(primes, true);

        for (int i = 2; i * i <= maxRoot; i++) {
            if (primes[i]) {
                for (int j = i * i; j <= maxRoot; j += i) {
                    primes[j] = false;
                }
            }
        }

        int sp = 0;
        int cnt = 0;

        for (int i = 2; i <= maxRoot; i++) {
            if (primes[i]) {
                int square = i * i;
                if (square >= l && square <= r) {
                    sp++;
                }
            }
        }

        cnt = r - l + 1 - sp;
        return cnt;
    }
}