public class Mappa {
    public static void main(String[] args){
        LabirintoFile file = new LabirintoFile();
        int[] sizeLabirinto = file.getSize();

        int[][] mappa = new int[sizeLabirinto[0]][sizeLabirinto[1]];

        // OSTACOLI 
            mappa[0][1] = 1;
            mappa[1][2] = 1;
            mappa[2][0] = 1;
            mappa[4][1] = 1; 
            // for(int i = 0; i < mappa.length; i++){
            //     for(int j = 0; j < mappa.length; j++){
            //         if(mappa[i][j] != 1){
            //             mappa[i][j] = 2;
            //         }
            //     }
            // }

        Robot robot = new Robot(mappa, 0, 0);        
    }
}
