package Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class visitAllRooms {

    static boolean isValid(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];
        dfs(0, rooms, visited);

        for(boolean room : visited) {
            if(!room) {
                return false;
            }
        }
        return true;
    }

    static boolean dfs(int n, List<List<Integer>> rooms, boolean[] visited) {
        visited[n] = true;
        for(int key : rooms.get(n)) {
            if(!visited[key]) {
                if(dfs(n, rooms, visited)) return true;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<List<Integer>> rooms = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            rooms.add(new ArrayList<>());
        }
        for(int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

        }
    }

}
