public class Main {
    public static void main(String[] args) {
        Graph g = new Graph();

        for (int i = 0; i < 5; i++) {
            g.addVertex(i);
        }

        g.addEdge(0, 1, 4);
        g.addEdge(0, 2, 1);
        g.addEdge(2, 1, 2);
        g.addEdge(1, 3, 1);
        g.addEdge(2, 3, 5);
        g.addEdge(3, 4, 3);

        g.dijkstra(0);
    }
}