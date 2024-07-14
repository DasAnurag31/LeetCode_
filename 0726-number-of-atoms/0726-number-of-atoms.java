class Solution {

    public String countOfAtoms(String formula) {
        Stack<Map<String, Integer>> stack = new Stack<>();
        stack.push(new HashMap<>());

        int index = 0;

        while (index < formula.length()) {
            if (formula.charAt(index) == '(') {
                stack.push(new HashMap<>());
                index++;
            }
           
            else if (formula.charAt(index) == ')') {
                Map<String, Integer> currMap = stack.pop();
                index++;
                StringBuilder multiplier = new StringBuilder();
                while (index < formula.length() && Character.isDigit(formula.charAt(index))) {
                    multiplier.append(formula.charAt(index));
                    index++;
                }
                if (multiplier.length() > 0) {
                    int mult = Integer.parseInt(multiplier.toString());
                    for (String atom : currMap.keySet()) {
                        currMap.put(atom, currMap.get(atom) * mult);
                    }
                }

                for (String atom : currMap.keySet()) {
                    stack 
                        .peek()
                        .put(
                            atom,
                            stack.peek().getOrDefault(atom, 0) +
                            currMap.get(atom)
                        );
                }
            }
            else {
                StringBuilder currAtom = new StringBuilder();
                currAtom.append(formula.charAt(index));
                index++;
                while (
                    index < formula.length() &&
                    Character.isLowerCase(formula.charAt(index))
                ) {
                    currAtom.append(formula.charAt(index));
                    index++;
                }

                StringBuilder currCount = new StringBuilder();
                while (
                    index < formula.length() &&
                    Character.isDigit(formula.charAt(index))
                ) {
                    currCount.append(formula.charAt(index));
                    index++;
                }

                int count = currCount.length() > 0
                    ? Integer.parseInt(currCount.toString())
                    : 1;

                stack
                    .peek()
                    .put(
                        currAtom.toString(),
                        stack.peek().getOrDefault(currAtom.toString(), 0) +
                        count
                    );
            }
        }

        TreeMap<String, Integer> finalMap = new TreeMap<>(stack.peek());

        StringBuilder ans = new StringBuilder();
        for (String atom : finalMap.keySet()) {
            ans.append(atom);
            if (finalMap.get(atom) > 1) {
                ans.append(finalMap.get(atom));
            }
        }

        return ans.toString();
    }
}