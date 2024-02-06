package graph;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

import classification.Collection;
import contours.ContoursGraph;
import classification.ClassOdd;

public class Circulant {
    int N;
    int n;
    Collection col;
    int num;

    public Circulant(int N, Collection col) {
        this.N = N;
        int n = (N-1)/2;
        this.n = n;
        int[] tuple = new int[n]; // кортеж первая половина, вторая это зеркальное отражение
        // Collection col = new Collection();
        this.col = col;

        for (int i = 0; i < n; i++) {
            tuple[i] = -1;
        }

        num = 0;
        System.out.println(n);
        System.out.println();

        for (int k = 0; k < Math.pow(2,n-1); k++) {
            System.out.println(num);
            // System.out.println(tuple[0] + " " + tuple[1] + " " + tuple[2] + " " + tuple[3] + " " + tuple[4] + " " + tuple[5] + " ");

            // место для составления матрицы смежности
            matr(tuple);

            num++;
            func(tuple, n-1);
        }
    }

    private void matr(int[] tuple) {
        int[][] matrix = new int[N][N];

        for (int j = 1; j <= n; j++) {
            matrix[0][j] = tuple[j-1];
            matrix[0][N-j] = -tuple[j-1];
        }

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][(j+1)%N] = matrix[i-1][j];
            }
        }

        ClassOdd cso = new ClassOdd(matrix, col);
        // System.out.println(" class = " + cso.getClassgraph());

    }

    private void func(int[] tuple, int count) { // нахождение всех кортежей
        tuple[count] *= (-1);
        if (tuple[count] == -1) {
            if (count > 0) func(tuple, count-1);
        }
    }
    
}
