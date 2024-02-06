package graph;

import classification.ClassSearchOdd;
import classification.Collection;
import contours.ContoursGraph;
import dinamic.DynamicSystem;
import sum.Sum;
import transition_to_class.Transition;
import transition_to_class.FileMatrix;
import transition_to_class.Matrix;
import transition_to_class.MyThread;

import static java.lang.Thread.sleep;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Arrays;

public class ProcessingN {
    public ProcessingN(int N){
        Collection col = new Collection();
        // Collection col0 = new Collection();
        // new OddN(N, col);

        file_scan(N, col);

        // new Circulant(N, col);

        // file_scan0(N, col0);

        // Matrix matr = new Matrix(col);
        // matr.deleteColumn(1215, 1216);

        // int self_dual = 0;
        // int dual = 0;

        // int[] dual = new int[2]; // 0 - кол-во самодвойственных, 1 - кол-во двойственных
        // dual[0] = 0;
        // dual[1] = 0;
        // int beg = 0;
        // int end = col.get_list().size();

        // for (int i = 0; i < col.get_list().size(); i++) {
        //     System.out.println(dual[0] + "   ^   " + dual[1]);
        //     while (Thread.activeCount() > 8) {
        //         try {
        //             sleep(5000);
        //         } catch (InterruptedException e) {
        //             e.printStackTrace();
        //         }
        //     }
        //     Dual mt = new Dual(col.get_list().get(i), col, dual, i, beg, end);

        //     new Thread(mt).start();


        // }


        // int beg = 0;
        // int end = col.get_list().size();

        // for (int i = 1220; i < col.get_list().size(); i++) {
        //     beg = i - 8;

        //     while (Thread.activeCount() > 8) {
        //         try {
        //             sleep(1000);
        //         } catch (InterruptedException e) {
        //             e.printStackTrace();
        //         }
        //     }
        //     MyThr mt = new MyThr(col.get_list().get(i), col, i, beg, end);

        //     new Thread(mt).start();


        //     // ClassSearchOdd cso = new ClassSearchOdd(col.get_list().get(i), col, i, beg, end);
        //     // System.out.println("i = " + (i+1) + "  class = " + cso.getClassgraph());
        //     // if (i+1 !=  cso.getClassgraph()) {
        //     //     System.out.println("!!!!!!!!!!!!!!!!!!!!   " +  cso.getClassgraph());
        //     // }
        // }

    //     // new Transition(col);

    //     // for (int i = 0; i < col.get_list().size(); i++) {
    //     //     // { int i = 54;
    //     //     System.out.println("class : " + (i+1));
    //     //     new Sum(col.get_list().get(i), (i+1));
    //     // }

        new DynamicSystem(col.get_list().get(2));
        


        // ClassSearchOdd cso = new ClassSearchOdd(col0.get_list().get(0), col, 0, 0, 15);
        //     System.out.println("  class = " + cso.getClassgraph());

        // System.out.println(Arrays.deepToString(col.get_list().get(0)).replace("], ", "\n")
        //         .replace("[", "").replace("]", "")
        //         .replace("-1", "0")
        // );

    // while (Thread.activeCount() > 1) {
    //     try {
    //         sleep(1000);
    //     } catch (InterruptedException e) {
    //         e.printStackTrace();
    //     }
    // }

        // FileMatrix fm = new FileMatrix(col);
        // fm.outpud_file();
        
    }


    private void file_scan(int N, Collection col) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("Eulerian_orientations/src/main/resources/g7/matrix.txt"));
            int num = Integer.parseInt(reader.readLine());
            System.out.println("Количество классов " + num);
            // for (int i = 0; i < 3; i++)
            reader.readLine();

            for (int k = 0; k < num; k++) {
                int[][] matrix = new int[N][N];
                for (int i = 0; i < N; i++) {
                    String[] line;
                    line = reader.readLine().split(", ");
        
                    for (int j = 0; j < N; j++) {
                        matrix[i][j] = Integer.parseInt(line[j]);
                    }
        
                }
                int[][] a = Arrays.stream(matrix).map(int[]::clone).toArray(int[][]::new);

                // if (k != 1216)
                col.set_list(a);

                // for (int i = 0; i < 13; i++)
                reader.readLine();
                reader.readLine();
            }
            reader.close();            

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void file_scan0(int N, Collection col) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("Eulerian_orientations/src/main/resources/g9/g0.txt"));
            int num = Integer.parseInt(reader.readLine());
            System.out.println("Количество классов " + num);
            reader.readLine();

            for (int k = 0; k < num; k++) {
                int[][] matrix = new int[N][N];
                for (int i = 0; i < N; i++) {
                    String[] line;
                    line = reader.readLine().split(", ");
        
                    for (int j = 0; j < N; j++) {
                        matrix[i][j] = Integer.parseInt(line[j]);
                    }
        
                }
                int[][] a = Arrays.stream(matrix).map(int[]::clone).toArray(int[][]::new);

                // if (k != 1216)
                col.set_list(a);

                reader.readLine();
                reader.readLine();
            }
            reader.close();            

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
