package contours;

import java.io.FileWriter;
import java.io.IOException;

public class ContoursGraph {
    private int m = 3;

    public ContoursGraph(int[][] graphArray, FileWriter writer) {
        int [] contour = new int[graphArray.length - m + 1];

        for (int i = 0; i < graphArray.length; i++) {
            int[] vertex = new int[graphArray.length];
            var(graphArray, contour, vertex, i, 0, -1);
        }
        for (int i = 0; i < contour.length; i++) {
            try {
                writer.write("Number of contours of length " + (i+m) + " : " + contour[i] + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
            // System.out.println("Количество контуров длины " + (i+m) + " : " + contour[i]);
        }

    }

    private void var(int[][] graphArray, int[] contour, int[] vertex, int a, int n, int k) {
        if (a == k) {
            contour[n-m] += 1;
        } else if (n < graphArray.length) {
            if (n == 0) k = a;
            if (vertex[k] < 2) {
                for (int i = a; i < graphArray.length; i++) {
                    if (graphArray[k][i] == 1) {
                        n += 1;
                        vertex[i] += 1;
                        var(graphArray, contour, vertex, a, n, i);
                        n -= 1;
                        vertex[i] -= 1;
                    }
                }
            }
        }
    }

}
