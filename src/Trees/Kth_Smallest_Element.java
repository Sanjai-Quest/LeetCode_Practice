package Trees;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Kth_Smallest_Element {

    int count = 0;
    int ans = 0;

    static TreeNode buildTree(String input) {
        input = input.replace("[", "")
                .replace("]", "")
                .trim();

        if(input.isEmpty()) return null;

        String[] arr = input.split("[,\\s]+");

        if(arr[0].equals("null")) return null;

        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;

        while(!queue.isEmpty() && i < arr.length) {
            TreeNode node = queue.poll();

            if(i < arr.length && !arr[i].equals("null")) {
                node.left = new TreeNode(Integer.parseInt(arr[i]));
                queue.offer(node.left);
            }
            i++;

            if(i < arr.length && !arr[i].equals("null")) {
                node.right = new TreeNode(Integer.parseInt(arr[i]));
                queue.offer(node.right);
            }
            i++;
        }

        return root;
    }

    public int kthSmallest(TreeNode root, int k) {
        if(k <= 0) throw new IllegalArgumentException("Invalid k");

        count = 0;
        ans = 0;

        inorder(root, k);

        if(count < k) throw new IllegalArgumentException("Invalid k");

        return ans;
    }

    void inorder(TreeNode root, int k) {
        if(root == null || count == k) return;

        inorder(root.left, k);

        if(count == k) return;

        count++;

        if(count == k) {
            ans = root.val;
            return;
        }

        inorder(root.right, k);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        TreeNode root = buildTree(sc.nextLine());
        int k = sc.nextInt();

        Kth_Smallest_Element obj = new Kth_Smallest_Element();

        System.out.println(obj.kthSmallest(root, k));
    }
}