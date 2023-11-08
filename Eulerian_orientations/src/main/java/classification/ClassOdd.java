package classification;

import java.util.Arrays;

public class ClassOdd {

    private int classgraph;

    public ClassOdd(int[][] graphArray, Collection col) {
        if (col.get_list().size() == 0){
            int[][] a = Arrays.stream(graphArray).map(int[]::clone).toArray(int[][]::new);
            col.set_list(a);
            classgraph = col.get_list().size();
        } else{
            int[][] array = Arrays.stream(graphArray).map(int[]::clone).toArray(int[][]::new);
            if (!arrayChanges(array, col)){
                col.set_list(array);
                classgraph = col.get_list().size();
            }
        }

    }

    public int getClassgraph(){
        return classgraph;
    }

    private boolean arrayChanges(int[][] array, Collection col) {
        if (ComparisonMatrix(array, col)) {
            return true;
        }
        if (var1(array, col, 0)) {
            return true;
        }

        return false;
    }

    private boolean ComparisonMatrix (int[][] array, Collection col) {
        for (int i = 0; i < col.get_list().size(); i++) {
            if (Arrays.deepEquals(array, col.get_list().get(i))) {
                classgraph = i + 1;
                return true;
            }
        }
        return false;
    }

    private boolean var1(int[][] array, Collection col,  int m1) {
        for (int m = m1; m < array.length; m++) {
            for (int k = m+1; k < array.length; k++) {
                swaps1(array, m, k);
                if (ComparisonMatrix(array, col)) {
                    return true;
                }
                if (var1(array,col, m+1)){
                    return true;
                }
                swaps1(array, m, k);
            }
        }
        return false;
    }

    //    для полного графа
    private void swaps1(int[][] array, int s, int f) {
        swap(array, s, f);
        swapColumns(array, s, f);
    }

    private void swap(int[][] a, int i, int j) {
        int[] tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    private static void swapColumns(int[][] a, int first, int second) {
        for (int r = 0; r < a.length; r++) {
            int temp = a[r][first];
            a[r][first] = a[r][second];
            a[r][second] = temp;
        }
    }

}
