package graph;

import classification.Collection;
import transition_to_class.Transition;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class ProcessingN {
    public ProcessingN(int N){
        if (N < 4){
            System.out.println("Неподходящее значение N");
        }else{
            Collection col = new Collection();

            file(col);
            System.out.println("Количество классов " + col.get_list().size());

            new Transition(col);
        }
    }


    private void file(Collection col){
        try {
            FileInputStream fis = new FileInputStream("Eulerian_orientations/src/main/resources/g11/class11.tmp");
            ObjectInputStream ois = new ObjectInputStream(fis);
            ArrayList<int[][]> list = (ArrayList<int[][]>) ois.readObject();
            System.out.println("***** " + list.size());

            for (int i = 0; i < list.size(); i++) {
                col.set_list(list.get(i));
            }

            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
