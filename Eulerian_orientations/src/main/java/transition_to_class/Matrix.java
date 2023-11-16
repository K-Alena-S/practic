package transition_to_class;

import classification.Collection;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Matrix {
    private int[][] repres;
    private int size;

    public Matrix (Collection col) {
        size = col.get_list().size();
        repres = new int[size][size];
        scan_file();
        // код ниже нужен для нахождения обратной матрицы
//        for (int i = 0; i < repres.length; i++) {
//            for (int j = 0; j < repres.length; j++) {
//                repres[i][j] = 1;
//            }
//        }
    }

    public void deleteColumn(int a, int b) {
        // удаляем столбец b, значения смещаем в a

        for (int i = 0; i < size; i++) {
            if (repres[i][b] == 1) repres[i][a] = 1;
        }
        for (int i = 0; i < size; i++) {
            for (int j = b; j < size - 1; j++) {
                repres[i][j] = repres[i][j+1];
            }
        }
        size--;
        outpud_file();
    }

    public void setRepres(int a, int b) {
        if (a >= size || b >= size) {
            // создать матрицу размером больше и перенести матрицу
            size++;
            int[][] repres1 = new int[size][size];
            for (int i = 0; i <= a; i++) {
                for (int j = 0; j < size-1; j++) {
                    repres1[i][j] = repres[i][j];
                }
            }
            repres = repres1;

        }
        if (repres[a][b] != 1) {
            repres[a][b] = 1; // = 0, если нужно найти обратную матрицу
            outpud_file();
        } 
        
    }

    public int[][] getRepres() {
        return repres;
    }

    private String file = "Eulerian_orientations/src/main/resources/g13/graph13_matrix.txt";

    public void outpud_file() {
        try(FileWriter writer = new FileWriter(file)){
            for (int i = 0; i < size; ++i) {
                for (int j = 0; j < size; ++j) {
                    writer.write(repres[i][j]+ "  ");
                }
                writer.write("\r\n");
            }
        } catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    public void scan_file() {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int n = size;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                repres[i][j] = scanner.nextInt();
            }
        }
    }

}
