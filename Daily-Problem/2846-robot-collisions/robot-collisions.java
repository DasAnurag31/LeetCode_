import java.util.*;

class Robot {
    int position;
    int health;
    char direction;
    int index;

    Robot(int position, int health, char direction, int index) {
        this.position = position;
        this.health = health;
        this.direction = direction;
        this.index = index;
    }
}

class Solution {

    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        Robot[] robots = new Robot[n];
        List<Integer> result = new ArrayList<>();
        Stack<Robot> stack = new Stack<>();

        for (int i = 0; i < n; ++i) {
            robots[i] = new Robot(positions[i], healths[i], directions.charAt(i), i);
        }

        Arrays.sort(robots, (lhs, rhs) -> Integer.compare(lhs.position, rhs.position));

        for (Robot current : robots) {
            if (current.direction == 'R') {
                stack.push(current);
            } else {
                while (!stack.isEmpty() && current.health > 0) {
                    Robot top = stack.pop();

                    if (top.health > current.health) {
                        top.health -= 1;
                        current.health = 0;
                        stack.push(top);
                    } else if (top.health < current.health) {
                        current.health -= 1;
                        top.health = 0;
                    } else {
                        current.health = 0;
                        top.health = 0;
                    }
                }
            }
        }

        Arrays.sort(robots, Comparator.comparingInt(r -> r.index));
        
        for (Robot robot : robots) {
            if (robot.health > 0) {
                result.add(robot.health);
            }
        }

        return result;
    }
}
