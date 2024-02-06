package contours;


import java.io.FileWriter;
import java.io.IOException;

public class ContoursGraph {
    private int m = 3;

    public ContoursGraph(int[][] graphArray, FileWriter writer, int k) {
        int [] contour = new int[graphArray.length-m+1];

        for (int i = 0; i < graphArray.length; i++) {
            int[] vertex = new int[graphArray.length];
            var(graphArray, contour, vertex, i, 0, -1);
        }
        
        for (int i = 0; i < contour.length; i++) {
            // System.out.println("Количество контуров длины " + (i+m) + " : " + contour[i]);
            try {
                if (i == 0) {
                    System.out.print("\n" + k + "     ");
                    writer.write(k + "     ");
                } 
                // writer.write("Number of contours of length " + (i+m) + " : " + contour[i] + "\n");
                System.out.print(contour[i] + " ");
                writer.write(contour[i] + " ");
            } catch (IOException e) {
                e.printStackTrace();
            }
            // System.out.println("Количество контуров длины " + (i+m) + " : " + contour[i]);
        }
        try {
            writer.write("\n");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
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
                        if (n < graphArray.length - 15)
                            var(graphArray, contour, vertex, a, n, i);
                        n -= 1;
                        vertex[i] -= 1;
                    }
                }
            }
        }
    }
}

// import java.io.FileWriter;
// import java.io.IOException;

// public class ContoursGraph {
//     private int m = 3; // сдвиг в массиве
//     private int or = 1;

//     public ContoursGraph(int[][] graphArray, FileWriter writer) {
//         int [] contour = new int[graphArray.length - m + 1]; // 

//         for (int i = 0; i < graphArray.length; i++) {
//             // if ((i%2) == 0) 
//             {
//                 int[] vertex = new int[graphArray.length];
//                 var(graphArray, contour, vertex, i, 0, -1);
//             }
//         }

//         try {

//             for (int i = 0; i < contour.length; i++) {
            
//                 // writer.write(contour[i] + " ");
//                 writer.write("Number of contours of length " + (i+m) + " : " + contour[i] + "\n"); //
            
//             }
//             writer.write("\n");
//         } catch (IOException e) {
//                 e.printStackTrace();
//             }
//             // System.out.println("Количество контуров длины " + (i+m) + " : " + contour[i]);

//     }

//     // нужна проверка, чтобы вершины не повторялись!
//     private void var(int[][] graphArray, int[] contour, int[] vertex, int a, int n, int k) {
//         // System.out.println("n = " + n + " vertex[i] = " + vertex[0] + "  " + vertex[1] + " " + vertex[2] + " " + vertex[3]);
//         if (a == k) {
//             if (n > 3 && n%2 == 0) {
//                 contour[n-m] += 1; //
//                 for(int i = 0; i < vertex.length; i++) {
//                         System.out.print(vertex[i]);
//                 }
//                 System.out.println();
//             }
           
//         } else if (n < graphArray.length) {
//             if (n == 0) k = a;
//             if (vertex[k] < 2) {
//                 for (int i = a; i < graphArray.length; i++) {
//                     //if (vertex[k] == 0 || vertex[k] == 1 && (vertex[i] == 0 || a == i)) // проверка на повтор до конца цикла
//                     if (graphArray[k][i] == or && vertex[i] < 2) { 
//                         n += 1;
//                         vertex[i] += 1;
//                         or *= -1;
//                         var(graphArray, contour, vertex, a, n, i);
//                         n -= 1;
//                         vertex[i] -= 1;
//                         or *= -1;
//                     }
//                 }
//             }
//         }
//     }

// }
