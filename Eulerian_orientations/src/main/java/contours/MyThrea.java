package contours;

import java.io.FileWriter;

public class MyThrea implements Runnable{

    int[][] graphArray;
    FileWriter writer;
    int k;

    public MyThrea(int[][] graphArray, FileWriter writer, int k) {
        this.graphArray = graphArray;
        this.writer = writer;
        this.k = k;
    }

    @Override
    public void run() {
        new ContoursGraph(graphArray, writer, k);
    }

}
