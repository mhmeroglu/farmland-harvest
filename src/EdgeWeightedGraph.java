import java.util.*;
public class EdgeWeightedGraph {
    // number of vertex
    private final int V;

    // adj list
    private final LinkedList<Edge>[] adj;

    // constructor
    public EdgeWeightedGraph(int V) {
        this.V = V;
        adj = new LinkedList[V];
        for (int v = 0; v < V; v++)
            adj[v] = new LinkedList<>();
    }

    // return number of vertex
    public int V() {
        return V;
    }

    //--------------------------------------------------------
    // Summary: Connecting the vertex with the vertices.
    // Precondition: e is Edge
    // Postcondition: vertices connected by edges.
    //--------------------------------------------------------
    public void addEdge(Edge e) {
        int v = e.either(), w = e.other(v);
        adj[v].add(e);
        adj[w].add(e);
    }

    //return adj list
    public Iterable<Edge> adj(int v) {
        return adj[v];
    }
}