package transition_to_class;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

import classification.Collection;
import contours.ContoursGraph;

public class FileMatrix {
    private Collection col;

    public FileMatrix(Collection col) {
        this.col = col;
    }

    private String file = "Eulerian_orientations/src/main/resources/g11/matrcont.txt";

    public void outpud_file() {
        try(FileWriter writer = new FileWriter(file)){
            writer.write(col.get_list().size() + "\n");
            writer.write("\n");


            for (int i = 0; i < col.get_list().size(); ++i) {
                writer.write("class: " + (i+1) + "\n");

                writer.write(Arrays.deepToString(col.get_list().get(i)).replace("], ", "\n")
                                .replace("[", "").replace("]", "")
                );
                writer.write("\n\n");

                new ContoursGraph(col.get_list().get(i), writer);

                writer.write("\n\n");
            }
            writer.write("\n");
        } catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
    
}
