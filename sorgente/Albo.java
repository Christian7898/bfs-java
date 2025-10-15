
import java.util.LinkedList;
import java.util.Queue;

public class Albo {

    // MATRICI
    private int[][] mappa;
    private int[][] Riga;
    private int[][] Colonna;
    private boolean[][] visitato;

    // POSIZIONIy INIZIALI
    private int posInzialeR; // POSIZIONE INIZIALE RIGA
    private int posInzialeC; // POSIZIONE INIZIALE COLONNA

    // CODE
    private LinkedList<Integer> queueRighe;
    private LinkedList<Integer> queueColonne;

    private Queue<Posizioni> coda = new LinkedList<>();

    public Albo(int[][] mappa, int posIniziale1, int posIniziale2, int posFinale, int posFinale2) {
        this.mappa = mappa;
        this.Riga = new int[mappa.length][mappa[0].length];
        this.Colonna = new int[mappa.length][mappa[0].length];
        this.visitato = new boolean[mappa.length][mappa[0].length];
        this.posInzialeR = posIniziale1;
        this.posInzialeC = posIniziale2;

        this.queueRighe = new LinkedList<>();
        this.queueColonne = new LinkedList<>();

        queueRighe.add(posIniziale1);
        queueColonne.add(posIniziale2);

        Posizioni pos = new Posizioni(posIniziale1, posIniziale2);
        coda.add(pos);

        esploraMappa();
        boolean[][] bfs = percorsoMigliore(posFinale, posFinale2);
        stampaMappa(bfs);
    }

    private boolean[][] percorsoMigliore(int posFinale1, int posFinale2) {
        boolean found = false;
        while (!coda.isEmpty() && !found) {
            Posizioni pos = (Posizioni) coda.poll();
            int i;
            int j;
            
            i = pos.getX();
            j = pos.getY();
            
            
            if(i == posFinale1 && j == posFinale2){
                found = true;
            }
            
            Posizioni Posnuova = new Posizioni();
            
            if (i + 1 < mappa.length && mappa[i + 1][j] != 1 && visitato[i+1][j] != true) {
               coda.add( new Posizioni(i+1, j));
            }
            if (i - 1 >= 0 && mappa[i - 1][j] != 1&& visitato[i-1][j] != true) {
               coda.add( new Posizioni(i-1, j));
            }
            if (j + 1 < mappa[i].length && mappa[i][j + 1] != 1 && visitato[i][j+1] != true) {
               coda.add( new Posizioni(i, j+1));

            }

            if (j - 1 >= 0 && mappa[i][j - 1] != 1 && visitato[i][j-1] != true) {
                     coda.add( new Posizioni(i, j-1));
            }
            for (Posizioni p: coda ){
               System.out.print("("+ p.getX() + ", " + p.getY()+ ")" );

            }
            System.out.println();
            visitato[i][j] = true;

        }
        return visitato;
    }

    private boolean esploraMappa() {
        int i, j;
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
        System.out.println("MAPPA ESPLORATA: ");
        for(int r = 0;r < mappa.length; r++){
            for(int c = 0; c < mappa[r].length; c++){
                System.out.print(mappa[r][c] + ", ");
            }
            System.out.println();
        }
        return true;
    }

    private static void stampaMappa(boolean[][] mappa) {
        System.out.println();
        for (int i = 0; i < mappa.length; i++) {
            for (int j = 0; j < mappa[i].length; j++) {
                if(mappa[i][j]){
                    System.out.print("T" + ", ");
                }else{
                   System.out.print("F" + ", ");

                }
            }
            System.out.println();
        }
    }
}
