package transition_to_class;

import static java.lang.Thread.sleep;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

import classification.Collection;
import contours.Anticountours;
import contours.ContoursGraph;
import contours.MyThrea;

public class FileMatrix {
    private Collection col;

    public FileMatrix(Collection col) {
        this.col = col;
    }

    private String file = "Eulerian_orientations/src/main/resources/g11/anti11.txt";

    public void outpud_file() {
        try(FileWriter writer = new FileWriter(file)){
            writer.write(col.get_list().size() + "\n");
            // writer.write("\n");


            // for (int i = 0; i < col.get_list().size(); ++i) {
                int i = 1220;
                // writer.write("class: " + (i+1) + "\n");

                // writer.write(Arrays.deepToString(col.get_list().get(i)).replace("], ", "\n")
                //                 .replace("[", "").replace("]", "")
                // );
                // writer.write("\n\n");
                // System.out.println(i+1);


                // sleep(1000);

                // while (Thread.activeCount() > 4) {
                //     try {
                //         sleep(2000);
                //     } catch (InterruptedException e) {
                //         e.printStackTrace();
                //     }
                // }
                // MyThrea mt = new MyThrea(col.get_list().get(i), writer, i);
    
                // new Thread(mt).start();



                new Anticountours(col.get_list().get(i), writer);
                // new ContoursGraph(col.get_list().get(i), writer, i+1);

                // writer.write("\n");
                // System.out.println();
            // }
            writer.write("\n");

            while (Thread.activeCount() > 1) {
                try {
                    sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        // } catch (InterruptedException e1) {
        //     // TODO Auto-generated catch block
        //     e1.printStackTrace();
        // }
    }
    
}
