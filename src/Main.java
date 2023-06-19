import java.util.*;

public class Main {

    public static void main(String[] args) {
        //scanner
        Scanner scanner = new Scanner(System.in);

        // number of test case
        int numTestCases = scanner.nextInt();

        // getting values
        for (int i = 0; i < numTestCases; i++) {
            int numRows = scanner.nextInt();
            int numCols = scanner.nextInt();
            int startRow = scanner.nextInt() - 1;
            int startCol = scanner.nextInt() - 1;
            int endRow = scanner.nextInt() - 1;
            int endCol = scanner.nextInt() - 1;

            // creating matrix for column and rows values
            int [][] matrix = new int[numRows][numCols];
            for (int j = 0; j < numRows; j++) {
                for (int k = 0; k < numCols; k++) {
                    matrix[j][k] = scanner.nextInt();
                }
            }

            // creating Edge Weight Graph
            EdgeWeightedGraph G = new EdgeWeightedGraph(numRows * numCols);

            //For each cell, an edge is added to the graph connecting...
            // it to its neighboring cells in the right and bottom direction (if they exist).
            //To add an edge, the current cell is represented by a vertex with a unique ID 'v',
            // and its neighboring cell is represented by a vertex with a unique ID 'w'.
            // The weight of the edge between the two vertices is determined
            // by performing a bitwise XOR operation on the values of the two cells.
            for (int k = 0; k < numRows; k++) {
                for (int j = 0; j < numCols; j++) {
                    int v = k * numCols + j;
                    if (j < numCols - 1) {
                        int w = k * numCols + j + 1;
                        int weight = matrix[k][j] ^ matrix[k][j + 1];
                        G.addEdge(new Edge(v, w, weight));
                    }
                    if (k < numRows - 1) {
                        int w = (k + 1) * numCols + j;
                        int weight = matrix[k][j] ^ matrix[k + 1][j];
                        G.addEdge(new Edge(v, w, weight));
                    }
                }
            }

            // creating prim algo class
            LazyPrimMST prim = new LazyPrimMST(G);

            // total weight
            double totalWeight = 0.0;

            //for each for result
            for (Edge e : prim.mst()) {
                totalWeight += e.weight();
            }

            // print result
            System.out.println((int)totalWeight);
        }
    }
}
