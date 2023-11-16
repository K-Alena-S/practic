package transition_to_class;

import classification.Collection;

import java.util.Arrays;

import static java.lang.Thread.sleep;

public class Transition {

    // какие контуры(длина = N) меняют направление
    private int N = 3;
    int[] matrixN = new int[N];
    private int cont = 0;
    private Collection col;
    private int in;
    private int begin_class = 1; // на 1 меньше
    // private int end_class = 50; // col.get_list().size();
    private int begin_contour = 7; // будет вычисляться класс для begin_contour+1 контура
    private Matrix matr;
    private int num_thread = 4;

    public Transition(Collection col){
        this.col = col;
        matr = new Matrix(col);
        for (int i = begin_class; i < col.get_list().size(); i++) {
            in = i;

            System.out.println();
            System.out.println("***Класс " + (i+1) + ":");
            int[][] array = col.get_list().get(i);
            int[][] graph = Arrays.stream(array).map(int[]::clone).toArray(int[][]::new);

            cont = 0;
            for (int j = 0; j < graph.length; j++) {
                int[] vertex = new int[graph.length];// чтобы вершины не повторялись
                var(graph, vertex, j,0, -1);
            }
        }

        while (Thread.activeCount() > 1) {
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        matr.outpud_file();
    }

    private void var(int[][] graphArray, int[] vertex, int a, int n, int k) {
        if (a == k && n == N) {
            cont += 1;
            if (in > begin_class || cont > begin_contour){
                int[][] graph = Arrays.stream(graphArray).map(int[]::clone).toArray(int[][]::new);
                int[] mN = new int[N];
                for (int i = 0; i < matrixN.length; i++) {
                    mN[i] = matrixN[i];
                }
                while (Thread.activeCount() > num_thread) {
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                MyThread mt = new MyThread(graph, mN, matr, in, col, cont);

                new Thread(mt).start();
            }

        } else if (n < N) {
            if (n == 0) k = a;
            if (vertex[k] < 2) {
                for (int i = a; i < graphArray.length; i++) {
                    if (graphArray[k][i] == 1 && vertex[i] == 0) {
                        n += 1;
                        vertex[i] += 1;
                        matrixN[n-1] = i;
                        var(graphArray, vertex, a, n, i);
                        n -= 1;
                        vertex[i] -= 1;
                    }
                }
            }
        }
    }

}
