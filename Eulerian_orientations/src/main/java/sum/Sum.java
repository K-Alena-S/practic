package sum;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class Sum {

    private String file = "Eulerian_orientations/src/main/resources/g9/g9_m2_8.txt";
    private int M = 2;
    private int N;

    private int pos = 8;

    public Sum(int[][] graph, int n_class) {
        N = graph.length;
        int[] str0 = new int[graph.length];
        int[] str1 = new int[graph.length];
        int[] str2 = new int[graph.length];
        int[] str3 = new int[graph.length];
        int[] str4 = new int[graph.length];
        int[] str_prev = new int[graph.length];
        int[] str_new = new int[graph.length];
        str0[pos] = 1;
        str_prev[pos] = 1;
        // System.out.println(1);

        // System.out.println(Arrays.toString(str_prev));
        int count = 0;
        int rev = 0;

        try{
            FileWriter writer = new FileWriter(file, true);
            BufferedWriter bufferWriter = new BufferedWriter(writer);
            // bufferWriter.write(writer);
            
            bufferWriter.write("Class: " + n_class + "\n");
            bufferWriter.write(Arrays.toString(str_prev) + "     " + (count) + "\n");

            while (count < 1500 && rev < 20) {

                // if (count == 499) { // обнуление и поиск цикла начинающегося на 1 операцию дальше
                //     rev = 4;
                //     for (int i = 0; i < graph.length; i++) {
                //         // str[i] = 0;
                //         str_prev[i] = 0;
                //         str_new[i] = 0;
                //     }
                //     // str[0] = 1;
                //     str_prev[0] = 1;
                //     count = 0;
                // }
                for (int i = 0; i < graph.length; i++) {
                    for (int j = 0; j < graph.length; j++) {
                        if (graph[i][j] == 1) {
                            str_new[j] = (str_new[j] + str_prev[i]) % M; 
                        }
                    }
                }
                
                for (int i = 0; i < graph.length; i++) {
                    str_prev[i] = str_new[i];
                    str_new[i] = 0;
                }
                count++;

                bufferWriter.write(Arrays.toString(str_prev) + "     " + (count) + "\n");
                // System.out.println(Arrays.toString(str_prev) + "     " +(count));
                // int number = 0;
                // for (int i = 0; i < graph.length; i++) {
                //     number += str_prev[i] * Math.pow(2,i);
                // }
                // System.out.println(number);

                if (Arrays.equals(str0, str_prev)) break;

                // if (count == rev) {
                //     for (int i = 0; i < graph.length; i++) {
                //         str[i] = str_prev[i];
                //     }
                // }
                if (count == 1) {
                    for (int i = 0; i < N; i++) str1[i] = str_prev[i]; 
                }
                if (count == 2) {
                    for (int i = 0; i < N; i++) str2[i] = str_prev[i]; 
                }
                if (count == 3) {
                    for (int i = 0; i < N; i++) str3[i] = str_prev[i]; 
                }
                if (count == 4) {
                    for (int i = 0; i < N; i++) str4[i] = str_prev[i]; 
                }
                if (count > 1 && Arrays.equals(str1, str_prev)) {
                    rev = 1;
                    break;
                } 
                if (count > 2 && Arrays.equals(str2, str_prev)) {
                    rev = 2;
                    break;
                }     
                if (count > 3 && Arrays.equals(str3, str_prev)) {
                    rev = 3;
                    break;
                }   
                if (count > 4 && Arrays.equals(str4, str_prev)) {
                    rev = 4;
                    break;
                }          
            }

            bufferWriter.write("\nClass " + n_class + " : start and end of the cycle: " + rev + ", " + count + "\n\n\n");
            if (rev > count || count == 1500) {
                System.out.println("Не досчитано");
                bufferWriter.write("Not counted");
            }
            // System.out.println();
            // System.out.println(rev + " ^ " + count);
            bufferWriter.close();
            writer.close();
        } catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
    
}
