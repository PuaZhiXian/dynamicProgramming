import java.util.*;

public class No2751 {
    public static void main(String[] args) {
//        System.out.println(new No2751().survivedRobotsHealths(new int[]{5, 4, 3, 2, 1}, new int[]{2, 17, 9, 15, 10}, "RRRRR")); //[2,17,9,15,10]
//        System.out.println(new No2751().survivedRobotsHealths(new int[]{1, 2, 5, 6}, new int[]{10, 10, 11, 11}, "RLRL"));
        System.out.println(new No2751().survivedRobotsHealths(new int[]{4, 43, 80}, new int[]{14, 287, 42}, "LLR"));
    }


    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        "s".toUpperCase(Locale.ROOT);
        PriorityQueue<Robot> pq = new PriorityQueue<>(Comparator.comparingInt(Robot::getPosition));
        for (int i = 0; i < positions.length; i++) {
            int direction = 1;
            if (directions.charAt(i) == 'L') {
                direction = -1;
            }
            pq.add(new Robot(healths[i], positions[i], i, direction));
        }

        return asteroidCollisionV2(pq);
    }

    public List<Integer> asteroidCollisionV2(PriorityQueue<Robot> pq) {
        Stack<Robot> stack = new Stack<>();
        while (!pq.isEmpty()) {
            Robot cur = pq.poll();
            if (stack.isEmpty()) {
                stack.add(cur);
            } else {
                if (isPositive(cur.health)) {
                    stack.add(cur);
                } else {
                    if (isPositive(stack.peek().health)) {
                        if (Math.abs(cur.health) > stack.peek().health) {
                            stack.pop();
                            if (isPositive(cur.health)) {
                                cur.health = cur.health - 1;
                            } else {
                                cur.health = cur.health + 1;
                            }
                            pq.add(cur);
                        } else if (Math.abs(cur.health) == stack.peek().health) {
                            stack.pop();
                        } else {
                            if (isPositive(stack.peek().health)) {
                                stack.peek().health = stack.peek().health - 1;
                            } else {
                                stack.peek().health = stack.peek().health + 1;
                            }
                        }
                    } else {
                        stack.add(cur);
                    }
                }
            }
        }

        List<Integer> temp = new ArrayList<>();
        PriorityQueue<Robot> result = new PriorityQueue<>(Comparator.comparingInt(Robot::getIndex));
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }
        while (!result.isEmpty()) {
            temp.add(result.poll().getAbsVal());
        }
        return temp;
    }

    public boolean isPositive(int val) {
        return val > 0;
    }

    class Robot {
        int health;
        int position;
        int index;
        int direction;

        public Robot(int health, int position, int index, int direction) {
            this.health = health;
            this.position = position;
            this.index = index;
            this.direction = direction;
        }

        public int getHealth() {
            return health;
        }

        public void setHealth(int health) {
            this.health = health;
        }

        public int getPosition() {
            return position;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public void setPosition(int position) {
            this.position = position;
        }

        public int getAbsVal() {
            return Math.abs(this.health);
        }

        public int getDirection() {
            return direction;
        }

        public void setDirection(int direction) {
            this.direction = direction;
        }

        @Override
        public String toString() {
            return "Model{" +
                    "val=" + health +
                    ", position=" + position +
                    ", index=" + index +
                    '}';
        }
    }
}
