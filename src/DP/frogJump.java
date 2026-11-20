package DP;

public class frogJump {

    static int jump(int n) {
        if(n == 0) return 1;
        if(n == 1) return 1;
        if(n == 2) return 2;
        int a = 1;
        int b = 1;
        int c = 2;
        int next = 0;
        for(int i = 3; i <= n; i++) {
            next = a + b + c;
            a = b;
            b = c;
            c = next;
        }
        return next;
    }

    public static void main(String[] args) {
        int n = 6;
        System.out.println(jump(n));
    }

}
