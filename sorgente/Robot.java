

public class Robot {

    public Robot(int[][] mappa, int posIniziale1, int posIniziale2, int posFinale1, int posFinale2) {
        Albo albero = new Albo(mappa,posIniziale1,posIniziale2, posFinale1, posFinale2);
    }

    
    // private static int[][] esploraMappa(int[][] mappa, int posIniziale1, int posIniziale2) {
    //     int[][] mappaEsplorata = mappa;

    //     int i = 0;
    //     int j = 0;

    //     while (i < mappaEsplorata.length && j < mappaEsplorata[i].length) {
    //         if (i + 1 < mappaEsplorata.length && mappaEsplorata[i + 1][j] == 0) { // GIÙ

    //             i++;
    //         } else if (j - 1 >= 0 && mappaEsplorata[i][j - 1] == 0) { // SINISTRA
    //             j--;
    //         } else if (j + 1 < mappaEsplorata[i].length && mappaEsplorata[i][j + 1] == 0) { // DESTRA
    //             j++;
                
    //         } else {
    //             break;
    //         }

    //     }

    //     return mappaEsplorata;
    // }

    // private static void stampaMappa(int[][] mappa) {
    //     for (int i = 0; i < mappa.length; i++) {
    //         for (int j = 0; j < mappa[i].length; j++) {
    //             System.out.print(mappa[i][j] + ", ");
    //         }
    //         System.out.println();
    //     }
    // }

}
