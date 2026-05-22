import java.util.*;

public class Graph {
    private Map<Integer, List<Edge>> adjacencyList;

    public Graph() {
        adjacencyList = new HashMap<>();
    }

    public void addVertex(int v) {
        adjacencyList.putIfAbsent(v, new ArrayList<>());
    }

    public void addEdge(int from, int to, int weight) {
        adjacencyList.get(from).add(new Edge(to, weight));
    }

    public void dijkstra(int start) {
        int n = adjacencyList.size();

        Map<Integer, Integer> distance = new HashMap<>();
        Set<Integer> visited = new HashSet<>();

        for (int v : adjacencyList.keySet()) {
            distance.put(v, Integer.MAX_VALUE);
        }

        distance.put(start, 0);

        for (int i = 0; i < n; i++) {
            int current = -1;
            int minDist = Integer.MAX_VALUE;

            for (int v : adjacencyList.keySet()) {
                if (!visited.contains(v) && distance.get(v) < minDist) {
                    minDist = distance.get(v);
                    current = v;
                }
            }

            if (current == -1) break;

            visited.add(current);

            for (Edge edge : adjacencyList.get(current)) {
                int neighbor = edge.to;
                int newDist = distance.get(current) + edge.weight;

                if (newDist < distance.get(neighbor)) {
                    distance.put(neighbor, newDist);
                }
            }
        }

        System.out.println("Shortest distances from " + start + ":");
        for (int v : distance.keySet()) {
            System.out.println(v + " -> " + distance.get(v));
        }
    }
}