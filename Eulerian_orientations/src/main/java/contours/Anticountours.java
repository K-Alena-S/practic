package contours;

import java.io.FileWriter;
import java.io.IOException;

public class Anticountours {
    private int m = 3; // сдвиг в массиве
    int num = 0;
    int conto = 1;
    // private int or = 1;

    public Anticountours(int[][] graphArray, FileWriter writer) {
        System.out.println();
        int [] contour = new int[graphArray.length - m + 1]; // 

        for (int i = 0; i < graphArray.length; i++) {
            // if ((i%2) == 0) 
            {
                int[] vertex = new int[graphArray.length];
                var(graphArray, contour, vertex, i, 0, -1, conto);
                conto *= -1;
                int[] vertex1 = new int[graphArray.length];
                var(graphArray, contour, vertex1, i, 0, -1, conto);
                conto *= -1;
            }
        }

        try {
            for (int i = 0; i < contour.length; i++) {
                if (i % 2 == 1)
                writer.write(contour[i]/2 + " ");
                // writer.write("Number of contours of length " + (i+m) + " : " + contour[i] + "\n"); //
            }
            writer.write("\n");
        } catch (IOException e) {
                e.printStackTrace();
            }
            // System.out.println("Количество контуров длины " + (i+m) + " : " + contour[i]);

    }

    // нужна проверка, чтобы вершины не повторялись!
    private void var(int[][] graphArray, int[] contour, int[] vertex, int a, int n, int k, int or) {
        // System.out.println("n = " + n + " vertex[i] = " + vertex[0] + "  " + vertex[1] + " " + vertex[2] + " " + vertex[3]);
        if (a == k) {
            if (n > 3 && or == conto) 
            {
                num++;
                contour[n-m] += 1; //
                // for(int i = 0; i < vertex.length; i++) {
                //         System.out.print(vertex[i]);
                // }
                // System.out.println();
            }
           
        } else if (n < graphArray.length) {
            if (n == 0) k = a;
            if (vertex[k] < 2) {
                for (int i = a; i < graphArray.length; i++) {
                    //if (vertex[k] == 0 || vertex[k] == 1 && (vertex[i] == 0 || a == i)) // проверка на повтор до конца цикла
                    if (graphArray[k][i] == or && vertex[i] < 2) { 
                        n += 1;
                        vertex[i] += 1;
                        // System.out.println("num = " + num + " ^ " + (k+1) + " ^ " + (i+1) + " ^ " + graphArray[k][i]);
                        or *= -1;
                        var(graphArray, contour, vertex, a, n, i, or);
                        n -= 1;
                        vertex[i] -= 1;
                        or *= -1;
                    }
                }
            }
        }
    }

}

