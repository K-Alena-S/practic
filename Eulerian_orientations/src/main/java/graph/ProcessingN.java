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
        // new OddN(N, col);

        file_scan(N, col);

        // Matrix matr = new Matrix(col);
        // matr.deleteColumn(1185, 1188);


        int beg = 0;
        int end = col.get_list().size();

        for (int i = 1203; i < col.get_list().size(); i++) {
            beg = i - 8;

            while (Thread.activeCount() > 8) {
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            MyThr mt = new MyThr(col.get_list().get(i), col, i, beg, end);

            new Thread(mt).start();


            // ClassSearchOdd cso = new ClassSearchOdd(col.get_list().get(i), col, i, beg, end);
            // System.out.println("i = " + (i+1) + "  class = " + cso.getClassgraph());
            // if (i+1 !=  cso.getClassgraph()) {
            //     System.out.println("!!!!!!!!!!!!!!!!!!!!   " +  cso.getClassgraph());
            // }
        }

    //     // new Transition(col);

    //     // for (int i = 0; i < col.get_list().size(); i++) {
    //     //     // { int i = 54;
    //     //     System.out.println("class : " + (i+1));
    //     //     new Sum(col.get_list().get(i), (i+1));
    //     // }

        // new DynamicSystem(col.get_list().get(2));
        

    //     // System.out.println(Arrays.deepToString(col.get_list().get(0)).replace("], ", "\n")
    //     //         .replace("[", "").replace("]", "")
    //     //         .replace("-1", "0")
    //     // );

        // FileMatrix fm = new FileMatrix(col);
        // fm.outpud_file();
        
    }


    private void file_scan(int N, Collection col) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("Eulerian_orientations/src/main/resources/g11/matrix.txt"));
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

                // if (k != 1188 && k != 1207)
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
