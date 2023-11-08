package transition_to_class;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

import classification.Collection;

public class FileMatrix {
    private Collection col;

    public FileMatrix(Collection col) {
        this.col = col;
    }

    // public int[][] getRepres() {
    //     // return repres;
    // }

    private String file = "Eulerian_orientations/src/main/resources/g11/class439.txt";

    public void outpud_file() {
        try(FileWriter writer = new FileWriter(file)){

            for (int i = 0; i < col.get_list().size(); ++i) {
                writer.write((i+1) + "\n");
                // writer.write(Arrays.deepToString(col.get_list().get(i)));
                // (int i = 0; i < col.get_list().size(); ++i) {
                writer.write(Arrays.deepToString(col.get_list().get(i)).replace("], ", "], \n")
                                    .replace("[[", "[\n[")
                    );
                writer.write("\r\n\n");
            }
            writer.write("\r\n");
        } catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
    
}
