import java.util.LinkedList;

public class Albo {
    // MATRICI
    private int[][] mappa;
    private int[][] Riga;
    private int[][] Colonna;

    // POSIZIONIy INIZIALI
    private int posInzialeR; // POSIZIONE INIZIALE RIGA
    private int posInzialeC; // POSIZIONE INIZIALE COLONNA

    // CODE
    private LinkedList<Integer> queueRighe;
    private LinkedList<Integer> queueColonne;

    public Albo(int[][] mappa, int posIniziale1, int posIniziale2, int posFinale1, int posFinale2) {
        this.mappa = mappa;
        this.Riga = new int[mappa.length][mappa[0].length];
        this.Colonna = new int[mappa.length][mappa[0].length];

        this.posInzialeR = posIniziale1;
        this.posInzialeC = posIniziale2;

        this.queueRighe = new LinkedList<>();
        this.queueColonne = new LinkedList<>();

        queueRighe.add(posIniziale1);
        queueColonne.add(posIniziale2);

        esploraMappa(posIniziale1, posIniziale2, posFinale1, posFinale2);
        stampaMappa(mappa);
    }
    

    public int[][] esploraMappa(int posIniziale1, int posIniziale2, int posFinale1, int posFinale2) {
        int i,j;
        while (!queueRighe.isEmpty() && !queueColonne.isEmpty()) {
            i = queueRighe.removeFirst();
            j = queueColonne.removeFirst();
            

            if (mappa[i][j] == 2) {
                continue;
            }
            
            mappa[i][j] = 2;
           

            if (i + 1 < mappa.length && mappa[i + 1][j] == 0) {
                queueRighe.add(i + 1);
                queueColonne.add(j);
            }
            if (i - 1 >= 0 && mappa[i - 1][j] == 0) {
                queueRighe.add(i - 1);
                queueColonne.add(j);
            }
            if (j + 1 < mappa[i].length && mappa[i][j + 1] == 0) {
                queueRighe.add(i);
                queueColonne.add(j + 1);
            }

            if (j - 1 >= 0 && mappa[i][j - 1] == 0) {
                queueRighe.add(i);
                queueColonne.add(j - 1);
            }
        }
        
        Bfs bfs = new Bfs(mappa, posIniziale1, posIniziale2, posFinale1, posFinale2);
        return mappa;
    }



    private static void stampaMappa(int[][] mappa) {
        for (int i = 0; i < mappa.length; i++) {
            for (int j = 0; j < mappa[i].length; j++) {
                System.out.print(mappa[i][j] + ", ");
            }
            System.out.println();
        }
    }
}
