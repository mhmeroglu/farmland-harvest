import java.util.*;

public class LazyPrimMST {
    private boolean[] marked; // MST vertices
    private Queue<Edge> mst; // MST edges
    private MinPQ<Edge> pq; // PQ of edges

    // constructor
    public LazyPrimMST(EdgeWeightedGraph G) {
        pq = new MinPQ<Edge>();
        mst = new LinkedList<Edge>();
        marked = new boolean[G.V()];
        visit(G, 0);

        while (!pq.isEmpty() && mst.size() < G.V() - 1) {
            Edge e = pq.delMin();
            int v = e.either(), w = e.other(v);
            if (marked[v] && marked[w]) continue;
            mst.add(e);
            if (!marked[v]) visit(G, v);
            if (!marked[w]) visit(G, w);
        }
    }

    //--------------------------------------------------------
    // Summary: Visits a vertex in the specified EdgeWeightedGraph and adds its edges to a priority queue if they connect to an unmarked vertex.
    // Precondition: The G parameter must be a valid EdgeWeightedGraph object and the v parameter must be a valid vertex ID in G. The marked array must be initialized to the same size as the number of vertices in G.
    // Postcondition: Marks the visited vertex v as visited by setting the corresponding value in the marked array to true. Iterates over the adjacent edges of v in G and adds each edge to a priority queue if it connects to an unmarked vertex.
    // --------------------------------------------------------
    public void visit(EdgeWeightedGraph G, int v) {
        marked[v] = true;
        for (Edge e : G.adj(v))
            if (!marked[e.other(v)])
                pq.insert(e);
    }

    // returns mst
    public Iterable<Edge> mst() {
        return mst;
    }
}