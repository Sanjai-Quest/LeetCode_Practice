package Graph;

import java.util.ArrayList;
import java.util.Scanner;

public class Find_if_Path_Exists_in_Graph_1971 {

    static boolean isValid(int node, int source, ArrayList<ArrayList<Integer>> adj,int dest) {
        if(source == dest) return true;
        boolean[] visited = new boolean[node];
        if(dfs(source, adj, dest, visited)) return true;
        return false;
    }

    static boolean dfs(int n, ArrayList<ArrayList<Integer>> adj, int dest, boolean[] visited) {
        if(n == dest) return true;
        visited[n] = true;
        for(int neighbor : adj.get(n)) {
            if(!visited[neighbor]) {
                if(dfs(neighbor, adj, dest, visited)) return true;
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
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int source = sc.nextInt();
        int dest = sc.nextInt();
        System.out.println("Path Exists ? " + isValid(n, source, adj, dest));
    }

}
