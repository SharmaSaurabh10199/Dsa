package dataStructures.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
You are given a chesboard, a source and the destination, you have to find the minimum no of moves for knight to reach
the destination for knight
 */
public class knigthsTour {
    class pair {
        int row;
        int col;

        public pair(int row, int col) {
            this.row = row;
            this.col = col;
        }

    }

    int[][] visited = new int[8][8];

    boolean isValid(int i, int j) {
        if (i < 0 || j < 0 || i >= 7 || j >= 7) {
            return false;
        }
        return true;
    }

    int findMoves(String source, String destination) {
        int sourceI = source.charAt(0) - '1';
        int sourceJ = source.charAt(1) - 'a';
        int destI = destination.charAt(0) - '1';
        int destJ = destination.charAt(1) - 'a';

        for (int[] a : visited) {
            Arrays.fill(a, -1);
        }

        int[] moves = { 1, -1, 2, -2 };
        Queue<pair> q = new LinkedList<>();
        q.add(new pair(sourceI, sourceJ));
        visited[sourceI][sourceJ] = 0;
        while (!q.isEmpty()) {
            pair currPosition = q.poll();
            for (int i : moves) {
                for (int j : moves) {
                    if (Math.abs(i) != Math.abs(j)) {
                        if (isValid(currPosition.row + i, currPosition.col + j)
                                && visited[currPosition.row + i][currPosition.col + j] == -1) {
                            q.add(new pair(currPosition.row + i, currPosition.col + j));
                            visited[currPosition.row + i][currPosition.col
                                    + j] = visited[currPosition.row][currPosition.col] + 1;
                        }
                    }
                }
            }
            if (visited[destI][destJ] != -1) {
                return visited[destI][destJ];
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        knigthsTour knight = new knigthsTour();
        System.out.println(knight.findMoves("1a", "4d"));

    }
}
