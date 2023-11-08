package classification;

import java.io.*;
import java.util.ArrayList;

public class Collection {
    private ArrayList<int[][]> graphList = new ArrayList<>();

    public Collection() {
    }
    private void outpud_file(){
        try {
            FileOutputStream fos = new FileOutputStream("Eulerian_orientations/src/main/resources/g11/class11.tmp");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(graphList);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void set_list(int[][] graph) {
        graphList.add(graph);
        outpud_file();
    }


    public ArrayList<int[][]> get_list() {
        return graphList;
    }

}
