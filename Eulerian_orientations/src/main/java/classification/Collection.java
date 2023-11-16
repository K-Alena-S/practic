package classification;

import java.io.*;
import java.util.ArrayList;

import transition_to_class.FileMatrix;

public class Collection {
    private ArrayList<int[][]> graphList = new ArrayList<>();

    public Collection() {
    }
    private void outpud_file(){
        try {
            FileOutputStream fos = new FileOutputStream("Eulerian_orientations/src/main/resources/g11/newclass.tmp");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(graphList);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void set_list(int[][] graph) {
        graphList.add(graph);
        // FileMatrix fm = new FileMatrix(this);
        // fm.outpud_file();
        // outpud_file();
    }


    public ArrayList<int[][]> get_list() {
        return graphList;
    }

}
