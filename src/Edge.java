public class Edge implements Comparable<Edge> {
    // vertices
    private final int v, w;

    // weight
    private final double weight;

    // constructor
    public Edge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    // return v values
    public int either() {
        return v;
    }

    // return weight
    public double weight() {
        return weight;
    }

    // return w values or v values
    public int other(int vertex) {
        if (vertex == v) return w;
        else return v;
    }

    //--------------------------------------------------------
    // Summary: Compares two Edge objects based on their weight attribute.
    // Precondition: The method must be called on an Edge object and a valid Edge object must be passed as a parameter.
    // Postcondition: Returns -1 if the weight of the current object is less than the weight of the passed object, +1 if it is greater, and 0 if they are equal.
    // --------------------------------------------------------
    public int compareTo(Edge that) {
        if (this.weight < that.weight) return -1;
        else if (this.weight > that.weight) return +1;
        else return 0;
    }

    // to String method
    @Override
    public String toString() {
        return "Edge{" +
                "v=" + v +
                ", w=" + w +
                ", weight=" + weight +
                '}';
    }
}