package classification;

import java.util.Arrays;

public class ClassSearchOdd {
    private int classgraph;

    private int th;
    private int beg;
    private int end;

    public ClassSearchOdd(int[][] graphArray, Collection col, int th, int beg, int end){
        this.th = th;
        this.beg = beg;
        this.end = end;
        classgraph = 0;
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
//    без цикла
    private boolean arrayChanges(int[][] array, Collection col){
        // проход по всем массивам в коллекции
        for (int i = beg; i < end; i++){
            if (Arrays.deepEquals(array, col.get_list().get(i))) {
                classgraph = i + 1;
                return true;
            }
            if (var1(array,col, i, 0)){
                return true;
            }
        }
        return false;
    }
// для полного графа
    private boolean var1(int[][] array, Collection col, int i, int m1) {
        for (int m = m1; m < array.length; m++) {
            for (int k = m+1; k < array.length; k++) {
                swaps1(array, m, k);
                if (Arrays.deepEquals(array, col.get_list().get(i))) {
                    classgraph = i + 1;
                    return true;
                }
                if (var1(array,col, i, m+1)){
                    return true;
                }
                swaps1(array, m, k);
            }
        }
        return false;
    }

    //    без цикла
    private boolean var(int[][] array, Collection col, int i) {
        for (int k = 0; k < array.length; k++){
            swaps(array);

            if (Arrays.deepEquals(array, col.get_list().get(i))) {
                classgraph = i + 1;
                return true;
            }
        }
        return false;
    }
    //    без цикла
    private void turn(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                array[i][j] *= -1;
            }
        }
    }
    //    для полного графа
    private void swaps1(int[][] array, int s, int f) {
            swap(array, s, f);
            swapColumns(array, s, f);
    }
    //    без цикла
    private void swaps(int[][] array) {
        for (int i = 0; i < array.length-1; i++) {
            swap(array, i, i+1);
            swapColumns(array, i, i+1);
        }
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

