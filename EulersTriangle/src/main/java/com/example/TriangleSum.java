package com.example;

public class TriangleSum {

    public int findLargestSum(int[][] t) {
        if (t.length == 2) {
            // calculate sum and return
            int firstPathSum = t[0][0] + t[1][0];
            int secondPathSum = t[0][0] + t[1][1];
            return Math.max(firstPathSum, secondPathSum);
        } else {
            // reduce last two rows to one row and recur
            int[][] allButLastTwoRows = copyAllButLastTwoRows(t);

            int secondLastRow = t.length - 2;
            int lastRow = t.length - 1;
            int secondLastRowElements = t[secondLastRow].length;

            for (int i = 0; i < secondLastRowElements; i++) {
                int firstPathSum = t[secondLastRow][i] + t[lastRow][i];
                int secondPathSum = t[secondLastRow][i] + t[lastRow][i + 1];
                allButLastTwoRows[secondLastRow][i] = Math.max(firstPathSum, secondPathSum);
            }

//			printTrinagle(allButLastTwoRows);
            return findLargestSum(allButLastTwoRows);
        }
    }

    private int[][] copyAllButLastTwoRows(int[][] t) {
        int size = t.length;
        int reducedSize = size - 1;
        int[][] reducedT = new int[reducedSize][];
        for (int i = 0; i < reducedSize; i++) {
            reducedT[i] = new int[t[i].length];
        }
        for (int i = 0; i < size - 2; i++) {
            for (int j = 0; j < t[i].length; j++) {
                reducedT[i][j] = t[i][j];
            }
        }
        return reducedT;
    }

    private void printTrinagle(int[][] t) {
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[i].length; j++) {
                System.out.print(t[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

}
