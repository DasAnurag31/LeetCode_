class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        List<List<Integer>> ans = new ArrayList<>();
        Set<Integer> a = new HashSet<>(); // Undefeated
        Set<Integer> b = new HashSet<>(); // Single Defeats
        Set<Integer> c = new HashSet<>(); // Multiple Defeats

        for(int[] match:matches){
            int winner = match[0];
            int looser = match[1];

            if(!a.contains(winner)){
                if(!c.contains(winner) && !b.contains(winner)){
                    a.add(winner);
                }
            }



            if(a.contains(looser)){
                a.remove(looser);
                b.add(looser);
            }
            else if(b.contains(looser)){
                b.remove(looser);
                c.add(looser);
            }
            else if(!c.contains(looser)){
                b.add(looser);
            }

            
        }

        List<Integer> undef = new ArrayList<>(a);
        List<Integer> singdef = new ArrayList<>(b);

        Collections.sort(undef);
        Collections.sort(singdef);

        ans.add(undef);
        ans.add(singdef);
        return ans;
    }
}

// Optimal 
class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        int[] counts = new int[100001];
        Arrays.fill(counts, -1);
        for (int[] match : matches) {
            int winner = match[0];
            int loser = match[1];
            if (counts[winner] == -1) {
                counts[winner] = 0;
            }
            
            if (counts[loser] == -1) {
                counts[loser] = 1;
            } else {
                counts[loser]++;
            }
        }
        
        List<List<Integer>> res = Arrays.asList(new ArrayList<>(), new ArrayList<>());
        for (int i = 1; i < 100001; i++) {
            if (counts[i] == 0) {
                res.get(0).add(i);
            }
            if (counts[i] == 1) {
                res.get(1).add(i);
            }
        }
        
        return res;
        
    }
}