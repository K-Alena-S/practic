package graph;

import java.util.Arrays;

import classification.ClassOdd;
import classification.ClassSearchOdd;
import classification.Collection;

public class Dual implements Runnable {
    int[][] gA;
    Collection col;
    int[] dual;
    int th;
    int beg;
    int end;

    public Dual (int[][] graphArray, Collection col, int[] dual, int th, int beg, int end) {
        gA = graphArray;
        this.col = col;
        this.dual = dual;
        this.th = th;
        this.beg = beg;
        this.end = end;
    }


    @Override
    public void run() {
        int[][] a = Arrays.stream(col.get_list().get(th)).map(int[]::clone).toArray(int[][]::new);
        for (int i = 0; i < gA.length; i++) {
            for (int j = 0; j < gA.length; j++) {
                a[i][j] *= -1;
            }
        }

        ClassOdd cso = new ClassOdd(a, col);
        System.out.println("i = " + (th+1) + "  class = " + cso.getClassgraph());
        if (th+1 !=  cso.getClassgraph()) {
            System.out.println("!!!!!!!!!!!!!!!!!!!!   " +  cso.getClassgraph());
        }
        if ((th+1) == cso.getClassgraph()) dual[0]++;
        else dual[1]++;
    }


    // private int[][] func(int[][] graphh) {

    // }



}
