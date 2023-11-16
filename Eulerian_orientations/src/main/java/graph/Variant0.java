package graph;

// import classification.ClassSearchEven;
import classification.ClassOdd;
import classification.Collection;
import contours.ContoursGraph;
// import graph.Account;
import java.util.Arrays;

public class Variant0 {

    public Variant0(int[][] graphArray, int[] count, int str, int num,  Collection col){

        int t = str + 1;

        if (count[str] != 0){
            for (int i = graphArray.length-1; i > str; i--){
                if (graphArray[str][i] == -1){
                    t = i;
                    break;
                }
            }
        }

        if (count[str] < num) {
            for (int j = t; j < graphArray.length; j++) {
                if (graphArray[str][j] != -1 && graphArray[str][j] != 0 && (count[str] < num)) {
                    graphArray[str][j] = -1;
                    count[str] += 1;
                    graphArray[j][str] = 1;
                    count[j] -= 1;

                    if (count[str] < num){
                        new Variant0(graphArray, count, str, num, col);
                    }
                    else new Variant0(graphArray, count, str + 1, num, col);

                    graphArray[str][j] = 1;
                    count[str] -= 1;
                    graphArray[j][str] = -1;
                    count[j] += 1;
                }
            }
        }
        else if (count[str] == num){
            if (str < count.length - 1)
                new Variant0(graphArray, count, str + 1, num, col);
            else
                printGraph(graphArray, col);
        }
    }

    private void printGraph(int[][] graphArray, Collection col){
        // acc.set_account(1);
        // System.out.println("№ " + acc.get_account());
        
        ClassOdd cso = new ClassOdd(graphArray, col);
        System.out.println("Класс: " + cso.getClassgraph() + ": из: " + col.get_list().size());
        

//        new ContoursGraph(graphArray);
        System.out.println(Arrays.deepToString(graphArray).replace("], ", "\n")
                .replace("[", "").replace("]", "")
//                .replace("-1", "0")
        );
        System.out.println();
    }

}

