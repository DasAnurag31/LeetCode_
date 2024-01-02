class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums){
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        List<List<Integer>> result = new ArrayList<>();
        while (map.size() > 0) {
            Set<Integer> keySet = new HashSet(map.keySet());
            List<Integer> subResult = new ArrayList<>();
            for (int n : keySet) {
                subResult.add(n);
                if (map.get(n) == 1)
                    map.remove(n);
                else
                    map.put(n, map.get(n) - 1);
            }
            if (subResult.size() > 0)
                result.add(subResult);
        }
        return result;
    }
}