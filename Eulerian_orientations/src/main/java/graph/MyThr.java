package graph;

// import classification.ClassOdd;
import classification.ClassSearchOdd;
import classification.Collection;

public class MyThr implements Runnable {
    int[][] gA;
    Collection col;
    int th;
    int beg;
    int end;

    public MyThr (int[][] graphArray, Collection col, int th, int beg, int end) {
        gA = graphArray;
        this.col = col;
        this.th = th;
        this.beg = beg;
        this.end = end;
    }


    @Override
    public void run() {
        ClassSearchOdd cso = new ClassSearchOdd(col.get_list().get(th), col, th, beg, end);
        System.out.println("i = " + (th+1) + "  class = " + cso.getClassgraph());
        if (th+1 !=  cso.getClassgraph()) {
            System.out.println("!!!!!!!!!!!!!!!!!!!!   " +  cso.getClassgraph());
        }
    }

}
