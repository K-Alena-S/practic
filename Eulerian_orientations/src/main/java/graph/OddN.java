package graph;

import classification.Collection;
// import graph.Account;
// import orientations.Variant0;

public class OddN {

    // N нечётное
    public OddN(int N, Collection col){

        int [][] graphArray = new int[N][N];
        int num = 0; // необходимое количество -1 в строке
        int[] count = new int[graphArray.length]; // количество -1 в строке

        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                if (i != j){
                    if (i > j){
                        graphArray[i][j] = -1;
                        count[i] += 1;
                    }
                    else graphArray[i][j] = 1;
                }
//
//                if ((i + 1) % N == j % N || i % N == (j + 1) % N){
//                    graphArray[i][j] = 0;
//                    if (i > j) count[i] -= 1;
//                }
            }
        }

        for (int i = 0; i < N; i++){
            num += graphArray[0][i];
        }

        new Variant0(graphArray, count, 0, num / 2, col);
    }

}

