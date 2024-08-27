import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class PathWithMaximumProbability {
    public static void main(String[] args) {

        // Test case: n = 3, edges = [[0,1],[1,2],[0,2]], sucProb = [0.5,0.5,0.3], start = 0, end = 2
        int n = 3;
        int[][] edges = {{0, 1}, {1, 2}, {0, 2}};
        double[] sucProb = {0.5, 0.5, 0.3};
        int start = 0;
        int end = 2;

        // Call the function to calculate the maximum probability path
        double result = maxProbability(n, edges, sucProb, start, end);
        System.out.printf("%.5f\n", result); // Output the result with 5 decimal precision
    }

    /**
     * Function to find the maximum probability of reaching from the start node to the end node.
     * @param n         Number of nodes
     * @param edges     List of edges represented as pairs of nodes
     * @param sucProb   Probability of success for each edge
     * @param start     Starting node
     * @param end       Target node
     * @return          Maximum probability of reaching the end node
     */
    public static double maxProbability(int n, int[][] edges, double[] sucProb, int start, int end) {
        // Create an adjacency list to store edges and their corresponding probabilities
        List<List<Edge>> ways = new ArrayList<>();

        // Initialize adjacency list for each node
        for (int i = 0; i < n; i++) {
            ways.add(new ArrayList<>());
        }

        // Populate the adjacency list with edges and their probabilities
        for (int j = 0; j < edges.length; j++) {
            int x = edges[j][0];
            int y = edges[j][1];
            double prob = sucProb[j];

            // Add the edge to both directions (since it's an undirected graph)
            ways.get(x).add(new Edge(y, prob));
            ways.get(y).add(new Edge(x, prob));
        }

        // Priority queue (max heap) to explore the most promising paths first, ordered by probability
        PriorityQueue<Edge> maxHeap = new PriorityQueue<>((a, b) -> Double.compare(b.prob, a.prob));
        maxHeap.offer(new Edge(start, 1.0)); // Start with the starting node, with probability 1.0

        // Array to store the maximum probability to reach each node
        double[] maxProb = new double[n];
        maxProb[start] = 1.0; // Probability to reach the start node is 1.0

        // Dijkstra-like algorithm to find the path with the maximum probability
        while (!maxHeap.isEmpty()) {
            Edge current = maxHeap.poll();
            int node = current.node;
            double prob = current.prob;

            // If we reach the end node, return the probability
            if (node == end) return prob;

            // Explore all the neighbors of the current node
            for (Edge neighbor : ways.get(node)) {
                int nextNode = neighbor.node;
                double nextProb = neighbor.prob;
                double newProb = prob * nextProb; // Update the probability for the next node

                // If the new probability is higher than the previously known probability, update it
                if (newProb > maxProb[nextNode]) {
                    maxProb[nextNode] = newProb;
                    maxHeap.offer(new Edge(nextNode, newProb)); // Push the neighbor to the heap
                }
            }
        }

        // If there's no valid path from start to end, return 0.0
        return 0.0;
    }
}

/**
 * Helper class to represent an edge with a destination node and a probability.
 */
class Edge {
    int node;      // Destination node
    double prob;   // Probability of reaching that node

    Edge(int node, double prob) {
        this.node = node;
        this.prob = prob;
    }
}