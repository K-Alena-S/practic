package dinamic;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class DynamicSystem {

    private int N;
    private int[][] graph;
    private int M = 2;
    private int NM = 512;

    

    public DynamicSystem(int[][] graph) {
        this.graph = graph;
        N = graph.length;
        int[][] matrix = new int[NM][NM];
        // int[] mat = new int[NM]; 


        // System.out.println(mm(153));
        // System.out.println(mm(212));

        for (int i = 0; i < NM; i++) {
            // if (mm(mm(i)) == i) System.out.println(i+1);

            matrix[i][mm(i)] = 1;
            
        }

        // // for (int i = 1; i < NM; i++) {
        // //     if (mm(i) != 0)
        // //     matrix[i-1][mm(i)-1] = 1;
        // // }
        outpud_file(matrix);

    //     System.out.println(Arrays.deepToString(matrix).replace("], ", "\n")
    //                                 .replace("[", "").replace("]", "")
    // //                .replace("-1", "0")
    //                 );


    }

    // какое состояние(номер) переходит в какое состояние(номер)
    private int mm(int number) {
        int[] str_prev = new int[graph.length];
        int[] str_new = new int[graph.length];

        str_prev = im(number);


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (graph[i][j] == 1) {
                    str_new[j] = (str_new[j] + str_prev[i]) % M; 
                }
            }
        }
        return mi(str_new);
    }

    // число в состояние
    private int[] im(int number) {
        int[] str = new int[graph.length];

        for (int i = 0; i < N; i++) {
            str[i] = number % M;
            number = (number - str[i]) / M;
        }

        return str;
    }

    // состояние в число
    private int mi(int[] str_prev) {
        int number = 0;
        for (int i = 0; i < N; i++) {
            number += str_prev[i] * Math.pow(2,i);
        }
        return number;
    }

    private String file = "Eulerian_orientations/src/main/resources/g9/g9_dinamic_c14.txt";

    public void outpud_file(int[][] matrix) {
        try(FileWriter writer = new FileWriter(file)){
            writer.write(Arrays.deepToString(matrix).replace("], ", "\n")
                                .replace("[", "").replace("]", ""));
            
        } catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
    
}
