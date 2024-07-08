class Solution {
    public int beautySum(String s) {
        int size = s.length();
        int total = 0;
        char[] ss = s.toCharArray();
        for (int left = 0; left < size; ++left) {
            int[] freqs = new int[26];
            freqs[ss[left] - 'a'] = 1;

            int[] freqFreq = new int[size + 1];
            freqFreq[1] = 1;

            int max = 1;
            int min = 1;

            for (int right = left + 1; right < size; ++right) {
                int i = ss[right] - 'a';

                ++freqs[i];

                max = Math.max(max, freqs[i]);

                --freqFreq[freqs[i] - 1];
                ++freqFreq[freqs[i]];

                if (freqs[i] == 1) {
                    min = 1;
                }
                else if (freqFreq[min] == 0) {
                    min = freqs[i];
                }

                total += max - min;
            }
        }

        return total;
    }
}