import java.util.*;

public class LeetCode {

    public static int[] direction = {1, 2, 3};
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int numLane = sc.nextInt(), startLane = sc.nextInt();
        int time = sc.nextInt();
        int[][] road = new int[time][numLane];

        for (int i = 0; i < time; i++) {
            for (int j = 0; j < numLane; j++) {
                road[i][j] = sc.nextInt();
            }
        }

        List<Integer> moves = new ArrayList<>();
        backtrack(0, time, road, numLane, startLane, moves);
        System.out.println(moves);


    }

    public static boolean backtrack(int i, int time, int[][] road, int numLane, int lane, List<Integer> moves) {
        if (i == time) {
            return true;
        }

        for (int move : direction) {
            if (checkPath(i, move, lane, road, numLane)) {
                int nextLane = lane;
                if (move == 1) {
                    nextLane -= 1;
                } else if (move == 2) {
                    nextLane += 1;
                }

                moves.add(move);

                if (backtrack(i + 1, time, road, numLane, nextLane, moves)) {
                    return true;
                }

                moves.removeLast();
            }
        }

        return false;
    }

    public static boolean checkPath(int i, int move, int currentLane, int[][] road, int numLane) {
        int nextLane = currentLane;
        if (move == 1) {
            nextLane -= 1;
        } else if (move == 2) {
            nextLane += 1;
        }

        return 1 <= nextLane && nextLane <= numLane && road[i][nextLane - 1] == 0;
    }
}