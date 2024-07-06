class Solution {
    public int passThePillow(int n, int time) {
        int q = time / (n - 1);
        int r = time % (n - 1);
        return q % 2 == 0?r + 1:n - r;
    }
}