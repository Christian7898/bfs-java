import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LabirintoFile {
    File labirinto = new File("labirinto.txt");

    public LabirintoFile() {
    }

    public int[] getSize() {
        int[] size = new int[2];
        try (Scanner myReader = new Scanner(labirinto)) {
            int line = 0;
            if (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] parts = data.split("x");
                size[0] = Integer.parseInt(parts[0].trim());
                size[1] = Integer.parseInt(parts[1].trim());

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return size;
    }

    public int[][] getOstacoli(){
        int[] size = getSize();
        int[][] ostacoli = new int[size[0]][size[1]];
        try(Scanner myReader = new Scanner(labirinto)){
            
        }catch(FileNotFoundException e){
            
        }
        for(int i = 0; i < ostacoli.length; i++){
            for(int j = 0; j < ostacoli[i].length; j++){

            }
        }

        return ostacoli;
    }
}
