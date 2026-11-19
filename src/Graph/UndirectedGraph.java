package Graph;

import java.util.ArrayList;
import java.util.Scanner;

public class UndirectedGraph {

    public static void addEdgeForUndirected(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 5;
        int m = 6;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i <= m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            addEdgeForUndirected(adj, u, v);
        }
        for(int i = 0; i < n; i++) {
            System.out.println(i + " -> " + adj.get(i));
        }

    }

}
