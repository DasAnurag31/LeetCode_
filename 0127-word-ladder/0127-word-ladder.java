import java.util.*;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0;
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int level = 1;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                String currentWord = queue.poll();

                Iterator<String> it = wordSet.iterator();
                while (it.hasNext()) {
                    String word = it.next();

                    if (isAdjacent(currentWord, word)) {
                        if (word.equals(endWord)) {
                            return level + 1;
                        }

                        queue.offer(word);
                        it.remove();
                    }
                }
            }

            level++;
        }

        return 0;
    }

    private boolean isAdjacent(String word1, String word2) {
        int diffCount = 0;

        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                diffCount++;
                if (diffCount > 1) {
                    return false;
                }
            }
        }

        return diffCount == 1;
    }
}
