package Trees;

public class GrandParent_GrandChildrenSum {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static long sumOfGrandChildren(TreeNode root, int k) {
        if (k == 0) {
            throw new IllegalArgumentException("k must be nonzero");
        }
        return helper(root, null, null, k);
    }

    static long helper(TreeNode root, TreeNode parent, TreeNode grandParent, int k) {
        if (root == null) return 0;

        long sum = 0;

        if (grandParent != null && grandParent.val % k == 0) {
            sum += root.val;
        }

        return sum + helper(root.left, root, parent, k)
                + helper(root.right, root, parent, k);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(4);
        root.right = new TreeNode(7);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(8);

        root.left.left.left = new TreeNode(1);
        root.right.left.right = new TreeNode(9);

        int k = 2;
        long result = sumOfGrandChildren(root, k);
        System.out.println("Sum = " + result);
    }
}