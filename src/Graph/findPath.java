package Graph;

import java.util.ArrayList;
import java.util.Scanner;

public class findPath {

    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    static boolean dfs(int node, int dest, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
        if(node == dest) return true;
        visited[node] = true;
        for(int neighbor : adj.get(node)) {
            if(!visited[neighbor]) {
                if(dfs(neighbor, dest, adj, visited)) {
                    return true;
                }
            }
        }
        return false;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            addEdge(adj, u, v);
        }
        int source = 0;
        int dest = 3;
        boolean[] visited = new boolean[n];
        System.out.println(dfs(source, dest, adj, visited));

    }

}
