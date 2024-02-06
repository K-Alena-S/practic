package graph;


public class Main {

    public static void main(String[] args) {
        int N = 7;
        long startTime = System.currentTimeMillis();
        new ProcessingN(N);
        
        long endTime = System.currentTimeMillis();
        System.out.println("That took " + (endTime - startTime) + " milliseconds");
    }
}
