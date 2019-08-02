package home;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Task04CountNumOfIslands {


    //Complexity O(constant + n) -> because iterating only once and place visited elems to visited set(no extra visits happened)
    //Space O(constant + n) - using extra set to place visited nodes, in worst case all elems will be in that set.
    //constant represent overhead for supply variables
    public int countIslandsNum(int[][] input) {
        Set<Point> visited = new HashSet<>();
        int count = 0;
        int yLength = input.length;
        for (int y = 0; y < yLength; y++) {
            int xLength = input[y].length;
            for (int x = 0; x < xLength; x++) {
                Point coord = new Point(x, y);
                if (!visited.contains(coord)) {
                    int elem = input[y][x];
                    if (elem == 1) {
                        visitIsland(visited, coord, input);
                        count++;
                    }
                }
            }
        }
        return count;
    }

    private void visitIsland(Set<Point> visited, Point coord, int[][] input) {
        int x = coord.x;
        int y = coord.y;
        if (x > -1 && y > -1 && y < input.length && x < input[y].length) {
            if (!visited.contains(coord) && input[y][x] == 1) {
                visited.add(coord);
                //go left
                visitIsland(visited, new Point(x - 1, y), input);
                //go right
                visitIsland(visited, new Point(x + 1, y), input);
                //go up
                visitIsland(visited, new Point(x, y - 1), input);
                //go down
                visitIsland(visited, new Point(x, y + 1), input);
            }
        }
    }

    public static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj instanceof Point) {
                Point objPoint = (Point) obj;
                return x == objPoint.x && y == objPoint.y;
            }
            return false;
        }
    }

}
