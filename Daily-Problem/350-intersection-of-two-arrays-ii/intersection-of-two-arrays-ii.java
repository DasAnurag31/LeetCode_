class Solution {
    private Map<Integer, Integer> getFreq(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return map;
    }

    public int[] intersect(int[] a, int[] b) {
        int n = a.length;
        int m = b.length;
        Map<Integer, Integer> map;
        List<Integer> ans = new ArrayList<>();
        if (n <= m) {
            map = getFreq(a);
            for (int num : b) {
                if (map.containsKey(num) && map.get(num) > 0) {
                    ans.add(num);
                    map.put(num, map.get(num) - 1);
                }
            }
        } else {
            map = getFreq(b);
            for (int num : a) {
                if (map.containsKey(num) && map.get(num) > 0) {
                    ans.add(num);
                    map.put(num, map.get(num) - 1);
                }
            }
        }
        return ans.stream().mapToInt(i -> i).toArray();
    }
}
