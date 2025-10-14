import java.util.LinkedList;

public class Bfs {
    private LinkedList<Integer> queueRighe;
    private LinkedList<Integer> queueColonne;

    public Bfs(int[][] mappaEsplorata, int posIniziale1, int posIniziale2, int posFinale1, int posFinale2) {
        this.queueRighe = new LinkedList<>();
        this.queueColonne = new LinkedList<>();

        queueRighe.add(posIniziale1);
        queueColonne.add(posIniziale2);

        int[][] mappaBfs = bfs(mappaEsplorata, posFinale1, posFinale2);
        stampaMappa(mappaBfs);
    }

    private int[][] bfs(int[][] mappaEsplorata, int posFinale1, int posFinale2) {
        int i, j;
        boolean found = false;
        while (!queueRighe.isEmpty() && !queueColonne.isEmpty() && !found) {
            i = queueRighe.removeFirst();
            j = queueColonne.removeFirst();

            if (i == posFinale1 && j == posFinale2) {
                found = true;
            }

            if (i + 1 < mappaEsplorata.length && mappaEsplorata[i + 1][j] != 1 && mappaEsplorata[i + 1][j] != 3) {
                queueRighe.add(i + 1);
                queueColonne.add(j);
                mappaEsplorata[i + 1][j] = 3;
            }
            if (i - 1 >= 0 && mappaEsplorata[i - 1][j] != 1 && mappaEsplorata[i - 1][j] != 3) {
                queueRighe.add(i - 1);
                queueColonne.add(j);
                mappaEsplorata[i - 1][j] = 3;
            }
            if (j + 1 < mappaEsplorata[i].length && mappaEsplorata[i][j + 1] != 1 && mappaEsplorata[i ][j+1] != 3) {
                queueRighe.add(i);
                queueColonne.add(j + 1);
                mappaEsplorata[i][j + 1] = 3;
            }
            if (j - 1 >= 0 && mappaEsplorata[i][j - 1] != 1 && mappaEsplorata[i][j-1] != 3) {
                queueRighe.add(i);
                queueColonne.add(j - 1);
                mappaEsplorata[i][j - 1] = 3;
            }

        }
        return mappaEsplorata;
    }

    private static void stampaMappa(int[][] mappa) {
        System.out.println("BFS: ");
        for (int i = 0; i < mappa.length; i++) {
            for (int j = 0; j < mappa[i].length; j++) {
                System.out.print(mappa[i][j] + ", ");
            }
            System.out.println();
        }
    }
}
