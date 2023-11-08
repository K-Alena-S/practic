package transition_to_class;

import classification.ClassOdd;
import classification.Collection;

public class MyThread implements Runnable{
    int[][] graphArray;
    int[] matrixN;
    Matrix matr;
    int in;
    Collection col;
    int N = 3;
    int cont;

    public MyThread(int[][] graphArray, int[] matrixN, Matrix matr, int in, Collection col, int cont) {
        this.graphArray = graphArray;
        this.matrixN = matrixN;
        this.matr = matr;
        this.in = in;
        this.col = col;
        this.cont = cont;
    }

    @Override
    public void run() {
        transit();
    }

    private void transit(){

        swaps(graphArray, matrixN);

        if (graphArray.length % 2 != 0){
            ClassOdd cso = new ClassOdd(graphArray, col);
            System.out.println("№ in = "+ (in+1) + " ^ cont = " + cont + " класс: "  + cso.getClassgraph());
            matr.setRepres(in, cso.getClassgraph()-1);
        }

        swaps(graphArray, matrixN);
    }

    private void swaps(int[][] array, int[] matrixN){
        for (int i = 0; i < N; i++){
            array[matrixN[i]][matrixN[(i+1)%N]] *= -1;
            array[matrixN[(i+1)%N]][matrixN[i]] *= -1;
        }
    }

}
